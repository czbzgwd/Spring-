package com.atguigu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//Ĭ�ϼ���ioc�����е��������������������޲ι��������������ٽ��г�ʼ����ֵ�Ȳ���
@Component
public class Boss {

	private Car car;

	public Car getCar() {
		return car;
	}

	//������Ҫ�õ���������Ǵ������л�ȡ
	//@Autowired
	public Boss(@Autowired Car car){
		this.car = car;
		System.out.println("Boss�вι�����");
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
