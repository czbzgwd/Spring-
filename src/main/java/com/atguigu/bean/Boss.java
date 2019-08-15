package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {

	private Car car;

	public Car getCar() {
		return car;
	}

	//构造器要用的组件，都是从容器中获取
	//@Autowired
	public Boss(@Autowired Car car){
		this.car = car;
		System.out.println("Boss有参构造器");
	}
	//@Autowired
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
	
}
