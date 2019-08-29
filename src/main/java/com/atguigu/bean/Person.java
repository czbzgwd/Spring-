package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class Person {
	//ʹ��@Value��ֵ��
	//1��������ֵ
	//2������дSpEL�� #{}
	//3������д${}��ȡ�������ļ���properties���е�ֵ�������л������������ֵ��
	@Value("����")
	private String name;
	@Value("#{20*2}")
	private Integer age;
	//ͨ��${}���������ļ��е�ֵʱ������Ҫ������������м���@PropertySource(value="classpath:/person.properties")
	@Value("${person.nickName}")
	private String nickName;
	
	public Person() {
		super();
	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}

	
	

}
