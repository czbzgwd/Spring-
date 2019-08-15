package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfigOfLifeCycle;
import com.atguigu.config.MainConfigOfPropertyValues;

public class IOCTest_PropertyValue {
	AnnotationConfigApplicationContext applicationContext = 
			new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	@Test
	public void test01(){
		//1¡¢´´½¨iocÈÝÆ÷
		printBeans(applicationContext);
		Person person = (Person)applicationContext.getBean("person");
		System.out.println(person);
		//¹Ø±ÕÈÝÆ÷
		applicationContext.close();
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String[] names = applicationContext.getBeanDefinitionNames();
		for(String name:names){
			System.out.println(name);
		}
	}

}
