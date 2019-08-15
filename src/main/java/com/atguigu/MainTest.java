package com.atguigu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;

public class MainTest {

	public static void main(String[] args) {
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	    Person person = (Person)applicationContext.getBean("person");
	    System.out.println(person);*/
		
		ApplicationContext annotationContext = new AnnotationConfigApplicationContext(MainConfig.class);
	    Person p = annotationContext.getBean(Person.class);
	    System.out.println(p);
	    
	    String[] namesForType = annotationContext.getBeanNamesForType(Person.class);
	   for(String str:namesForType){
		   System.out.println(str);
	   }
	}
}
