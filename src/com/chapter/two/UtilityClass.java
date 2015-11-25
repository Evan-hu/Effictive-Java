package com.chapter.two;

/**
 * 
 * @Description: 不能实例化的类
 *
 * @author Evan
 *
 * @date Nov 25, 2015 9:58:32 AM
 */
public class UtilityClass {
	//Suppress default constructor for noninstantiability
	private UtilityClass () {
		throw new AssertionError();
	}
	
	public void test() {
		System.out.println("Just a test");
	}
}
