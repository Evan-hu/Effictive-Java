package com.test;

import org.junit.Test;

import com.chapter.two.Nutri;

public class NutriTest {

	@Test
	public void test() {
		Nutri nutri1 = new Nutri.Builder(240, 100).calorise(110).carbohydrate(10).builder();
		System.out.println(nutri1.toString()+"hashcode = "+ nutri1.hashCode());
		
		Nutri nutri2 = new Nutri.Builder(240, 100).calorise(110).carbohydrate(10).builder();
		System.out.println("nutri2 = "+nutri2.toString()+"hashcode = "+ nutri1.hashCode());
		
		System.out.println("equal = "+nutri1.equals(nutri2)+ " == "+ (nutri1 == nutri2));
	}
}
