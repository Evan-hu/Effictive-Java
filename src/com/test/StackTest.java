package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chapter.two.Stack;

public class StackTest {

	@Test
	public void testStack() {
		Stack stack = new Stack();
		System.out.println("stack.clone().equals(stack) = " + stack.clone().equals(stack));
	}

	@Test
	public void testPush() {
		fail("Not yet implemented");
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

}
