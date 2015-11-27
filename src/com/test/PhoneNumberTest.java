package com.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chapter.three.PhoneNumber;

public class PhoneNumberTest {

	@Test
	public void testPhoneNumber() {
		 Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		 m.put(new PhoneNumber(707, 867, 5309), "Jenny");
		 System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
	}

	@Test
	public void testRangeCheck() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
