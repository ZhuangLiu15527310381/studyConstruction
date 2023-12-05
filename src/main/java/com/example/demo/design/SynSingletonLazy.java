package com.example.demo.design;


import sun.management.jmxremote.SingleEntryRegistry;

/**
 * 线程安全类型的单例模式
 */
public class SynSingletonLazy {


    private volatile static Singleton singleton;


    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (SynSingletonLazy.class){
                //二次判断是否为空
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
