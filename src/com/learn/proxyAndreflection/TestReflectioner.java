package com.learn.proxyAndreflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class TestReflectioner {

	/**
	 * @param args
	 * @return void
	 * @author Evan
	 * @date Dec 23, 2015 4:32:40 PM 
	 */
	public static void main(String[] args) {
		
		TestReflection1 testReflection = new TestReflection1();
		Class<? extends TestReflection1> test = testReflection.getClass();
		
		for (int i = 0; i < test.getDeclaredFields().length; i++) {
			System.out.println(test.getDeclaredFields()[i]);
		}
		
		try {
			Field f = test.getDeclaredField("a");
			f.setAccessible(true);
//			Object object = f.get(testReflection);
			String type = f.getType().toString();
			int a = 20;
			if (type.endsWith("int")) {
				f.set(testReflection, a);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		testReflection.printValue();
		
	}

}


class TestReflection1 {
	
	private int a;
	private String stringName;
	
	public TestReflection1() {
		this.a = 1;
		this.stringName = "Fuck !";
	}
	
	public void printValue() {
		System.out.println("stringName = " + stringName);
		System.out.println("int a value = " + a);
	}
}
