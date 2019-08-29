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
		// 工厂Bean获取的是调用getObject创建的对象
		Object ob = applicationContext.getBean("colorFactoryBean");
		System.out.println("查看colorFactoryBean的类型" + ob.getClass());
		// 要获取工厂Bean本身，我们需要给id前面加一个&
		Object ob1 = applicationContext.getBean("&colorFactoryBean");
		System.out.println("查看colorFactoryBean的类型" + ob1.getClass());
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
		// 获取操作系统的名称
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
		System.out.println("IOC容器创建完成");
		// 默认是单实例的
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
