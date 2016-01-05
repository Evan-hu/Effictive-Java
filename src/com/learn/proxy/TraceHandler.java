package com.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * @Description: 
 *
 * @author Evan
 *
 * @date 2015年12月26日 下午2:30:00
 */


public class TraceHandler implements InvocationHandler {
	// Tracehandler 为一个调用处理器，调用处理器 是实现了 InvocationHandler接口 的 类对象
	public TraceHandler(Object t) {
		target = t;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Target = "+target);
		// print method name and parameters
//		method.getParameterTypes().toString();
		System.out.println("Method Name = "+method.getName()+ method.getParameterTypes().toString());
		// 调用实际的方法
		return method.invoke(target, args);
	}
	
	private Object target;
	
}
