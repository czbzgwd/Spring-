package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;
//������==�����ļ�
@Configuration //����spring����һ��������
/*@ComponentScan(value = "com.atguigu",excludeFilters = {
		@Filter(type=FilterType.ANNOTATION,classes={Controller.class,Service.class})
},useDefaultFilters=false)*/
@ComponentScans(value={
		@ComponentScan(value = "com.atguigu",includeFilters = {
				/*@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
				@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class})*/
				@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
		},useDefaultFilters=false)	
})
//@ComponentScan  value:ָ��Ҫɨ��İ�
//excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ���
//FilterType.ANNOTATION������ע��
//FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�
//FilterType.ASPECTJ��ʹ��ASPECTJ���ʽ
//FilterType.REGEX��ʹ������ָ��
//FilterType.CUSTOM��ʹ���Զ������
public class MainConfig {

	//@Bean�����е���������ָ��������
	@Bean("person")//��������ע��һ��bean�����;��Ƿ���ֵ���ͣ�idĬ�Ϸ�������id
	public Person person1(){
		return new Person("�ǵ�",24);
	}
}
