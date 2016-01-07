package com.learn.proxyAndreflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestReflectioner {

	/**
	 * @param args
	 * @return void
	 * @author Evan
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @date Dec 23, 2015 4:32:40 PM 
	 */
	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException {
		
		TestReflection1 testReflection = new TestReflection1();
		Class<? extends TestReflection1> test = testReflection.getClass();
		
		for (int i = 0; i < test.getDeclaredFields().length; i++) {
			System.out.println(test.getDeclaredFields()[i]);
		}
		
		try {
			// 获取一个 Method 并为参数赋值
			Method method = test.getDeclaredMethod("callMethod", int.class);
			method.setAccessible(true);
			// 此处打印为 null 与 调用 invoke() 有关
			System.out.println(method.invoke(testReflection, new Object[]{10}));
			// 获取一个 Field 并修改值
			Field f = test.getDeclaredField("a");
			f.setAccessible(true);
			//Object object = f.get(testReflection);
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
	
	public void callMethod(int a) {
		System.out.println("callMethod the params value a = " + a);
	}
}
