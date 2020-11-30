package com.dongnaoedu.news;

public class InterfaceMethodImpl implements InterfaceMethod {
	public void print(String name) {
		InterfaceMethod.super.print(name);
		
		System.out.println("我是动脑学院[" + name + "]老师......实现类方法");
	}
}
