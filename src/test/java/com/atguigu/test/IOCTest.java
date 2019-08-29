package com.atguigu.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;

public class IOCTest {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

	@Test
	public void testImport() {
		//printBeans(applicationContext);
		// ����Bean��ȡ���ǵ���getObject�����Ķ���
		Object ob = applicationContext.getBean("colorFactoryBean");
		System.out.println("�鿴colorFactoryBean������" + ob.getClass());
		// Ҫ��ȡ����Bean����������Ҫ��idǰ���һ��&
		Object ob1 = applicationContext.getBean("&colorFactoryBean");
		System.out.println("�鿴colorFactoryBean������" + ob1.getClass());
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void test03() {
		String[] strings = applicationContext.getBeanNamesForType(Person.class);
		// ��ȡ����ϵͳ������
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println(property);// Windows 7
		for (String str : strings) {
			System.out.println(str);
		}
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}

	@Test
	@SuppressWarnings("resource")
	public void test02() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfig2.class);
		/*
		 * String[] names = applicationContext.getBeanDefinitionNames();
		 * for(String str: names){ System.out.println(str); }
		 */
		System.out.println("IOC�����������");
		// Ĭ���ǵ�ʵ����
		//Object bean = applicationContext.getBean("person");
		
		 /* Object bean2 = applicationContext.getBean("person");
		  System.out.println(bean == bean2);*/
		 
	}

	@Test
	@SuppressWarnings("resource")
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfig.class);
		Person p = applicationContext.getBean(Person.class);
		System.out.println("p: " + p);
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String str : names) {
			System.out.println(str);
		}
	}

}
