package com.learn.arrays;

public class GeneratorTest {
	public static int size = 10;
	
	public static void test(Class<?> surroundingClass) {
		for(Class<?> type : surroundingClass.getClasses()) {
			System.out.println(type.getSimpleName()+ ":");
			
			Generator<?> g;
			try {
				g = (Generator<?>) type.newInstance();
				for (int i = 0; i < size; i++)
					System.out.println(g.next()+": ");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
		}
	}
	
	
	public static void main (String [] args) {
		test(CountingGenerator.class);
	}
}
