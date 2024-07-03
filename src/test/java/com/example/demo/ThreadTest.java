package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ThreadTest{





    @Test
    public void testMultiAdd(){
        //分组计算
        int threadSize = 4;
        int chunkSize = 1000/threadSize;
        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        int start = 0;
        int end = start + chunkSize;
        Future<Long>[] futures = new Future[threadSize];
        while (true){
            for (int i = 0; i < threadSize; i++) {
                SumTest threadTest = new SumTest(start, end);
                futures[i] = executorService.submit(threadTest);
                start = end + 1;
                end = Math.min(chunkSize + start,1000) ;
                System.out.println("end="+end);
            }
            if (end == 1000){
                break;
            }
        }
        Long total = 0L;

        for (Future<Long> future : futures) {
            try {
                Long o = future.get();
                total += o;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();

        System.out.println("total 总数之和="+total);
    }


    static class  SumTest implements Callable<Long>{

        int startNum;
        int endNum;

        public SumTest(int startNum,int endNum){
            this.startNum = startNum;
            this.endNum = endNum;
        }


        @Override
        public Long call() throws Exception {
            Long threadSum = 0L;
            for (int i = startNum; i <= endNum; i++) {
                threadSum += i;
            }
            return threadSum;
        }
    }



}
