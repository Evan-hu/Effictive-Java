package com.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

	public static void main(String[] args) {
		
		Object [] elements = new Object[1000];
		
		// fill elements with proxies for the integers 1...1000
		for (int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			// 创建代理对象， handler 为调用处理器 ， null为 class loader， 中间的为 一个class对象数组，每个元素都是需要实现的接口
			// 无论何时调用代理对象  proxy 的方法， 调用处理器 handler 的 invoke方法都会被调用，
			// 并向调用处理器  handler 传递 method 对象和原始的调用参数，调用处理器 handler 必须给出处理调用的方式
			Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
			elements[i] = proxy;
		}
		
		// construct a random integer
		Integer key = new Random().nextInt(elements.length) + 1;
		
		// search for the key
		int result = Arrays.binarySearch(elements, key);
		
		//print match if found
		if (result >= 0 )
			System.out.println(elements[result]);
		
		
	}

}
