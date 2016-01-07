package com.learn.proxyAndreflection;

public class TestReflection {
	
	private int a;
	private String stringName;
	
	public TestReflection() {
		this.a = 1;
		this.stringName = "Fuck !";
	}
	
	public void printValue() {
		System.out.println("stringName = " + stringName);
		System.out.println("int a value = " + a);
	}
}
