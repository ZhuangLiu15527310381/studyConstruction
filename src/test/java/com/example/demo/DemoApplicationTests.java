package com.example.demo;

import com.example.demo.design.abstractFactory.BJFactory;
import com.example.demo.design.abstractFactory.OrderPizza;
import com.example.demo.entity.Apee;
import com.example.demo.entity.PersionDTO;
import com.example.demo.entity.PersonVO;
import com.example.demo.mapstruct.inter.MyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void testMapStruct(){
		PersionDTO persionDTO = new PersionDTO();
		persionDTO.setpId(15135151L);
		persionDTO.setName("小天");
		persionDTO.setAge(18);
		persionDTO.setSex("male");
		persionDTO.setBirthDay(new Date());
		persionDTO.setDescribe("你好");
		persionDTO.setBirthLocation("chinese");
		persionDTO.setMarried(false);
		persionDTO.setHasChildren(false);
		persionDTO.setHasParents(true);
		List<String> test = Arrays.asList("游泳", "健身");
		persionDTO.setHobby(test);


		Apee apee = new Apee();
		apee.setAp("good choice");


		// 转化
		PersonVO personVO = MyMapper.INSTANCE.transToViewObject(persionDTO);
		System.out.println(persionDTO.toString());
		System.out.println(personVO.toString());
	}


	@Test
	void performenceTest(){
		for(int i=0; i<5; i++) {
			//beanUtils的测试
			Long startTime = System.currentTimeMillis();
			for(int count = 0; count<1000000; count++) {
				PersionDTO persionDTO = new PersionDTO();
				persionDTO.setpId(15135151L);
				persionDTO.setName("小天");
				persionDTO.setAge(18);
				persionDTO.setSex("male");
				persionDTO.setBirthDay(new Date());
				persionDTO.setDescribe("你好");
				persionDTO.setBirthLocation("chinese");
				persionDTO.setMarried(false);
				persionDTO.setHasChildren(false);
				persionDTO.setHasParents(true);
				PersonVO personVO = new PersonVO();
				BeanUtils.copyProperties(persionDTO,personVO);
			}
			System.out.println("BeanUtils 100w次实体映射耗时：" + (System.currentTimeMillis() - startTime));
			startTime = System.currentTimeMillis();
			for(int count = 0; count<1000000; count++) {
				PersionDTO persionDTO = new PersionDTO();
				persionDTO.setpId(15135151L);
				persionDTO.setName("小天");
				persionDTO.setAge(18);
				persionDTO.setSex("male");
				persionDTO.setBirthDay(new Date());
				persionDTO.setDescribe("你好");
				persionDTO.setBirthLocation("chinese");
				persionDTO.setMarried(false);
				persionDTO.setHasChildren(false);
				persionDTO.setHasParents(true);
				PersonVO personVO = MyMapper.INSTANCE.transToViewObject(persionDTO);
			}
			System.out.println("MapStruct 100w次实体映射耗时：" + (System.currentTimeMillis()-startTime));
			System.out.println();
		}
	}



}
