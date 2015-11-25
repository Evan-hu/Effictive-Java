package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chapter.three.CaseInsensitiveString;

public class CaseInsensitiveStringTest {

	@Test
	public void testCaseInsensitiveString() {
		CaseInsensitiveString test = new CaseInsensitiveString("Test");
		String s = "test";
		System.out.println("result = " + test.equals(s));
		System.out.println("equality result = " + s.equals(test));
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
