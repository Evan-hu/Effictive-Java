package com.chapter.two;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * 
 * @Description: implements stack
 *
 * @author Evan
 *
 * @date Nov 26, 2015 1:49:42 PM
 */
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack () {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push() {
		ensureCapacity();
		elements[size++] = 0;
	}
	
	public Object pop() {
		if (size == 0) 
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size+1);
		}
	}
	
	@Override public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
}
