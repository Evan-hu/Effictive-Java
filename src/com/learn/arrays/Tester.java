package com.learn.arrays;

import java.util.List;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

public class Tester<C> {
	public static int filedWidth = 8;
	public static TestParam[] defaultParams = TestParam.array(10, 5000, 100,
			5000, 1000, 5000, 10000, 500);

	protected C initialize(int size) {
		return container;
	}

	protected C container;
	private String headline = "";
	private List<Test<C>> tests;

	private static String stringField() {
		return "%" + filedWidth + "s";
	}

	private static String numberField() {
		return "%" + filedWidth + "d";
	}

	private static int sizeWidth = 5;
	private static String sizeField = "%" + filedWidth + "s";
	private TestParam[] paramList = defaultParams;

	public Tester(C container, List<Test<C>> tests) {
		this.container = container;
		this.tests = tests;
		if (null != container)
			headline = container.getClass().getSimpleName();
	}

	public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
		this(container, tests);
		this.paramList = paramList;
	}

	public void setHeadline(String name) {
		headline = name;
	}

	public static <C> void run(C cnter, List<Test<C>> tests) {
		new Tester<C>(cnter, tests).timedTest();
	}

	public static <C> void run(C cnter, List<Test<C>> tests,
			TestParam[] paramList) {
		new Tester<C>(cnter, tests, paramList).timedTest();
	}

	// Display Stytle
	private void displayHeader() {
		int width = filedWidth * tests.size() + sizeWidth;
		int dashLength = width - headline.length() - 1;
		StringBuilder head = new StringBuilder(width);
		for (int i = 0; i < dashLength / 2; i++)
			head.append('-');
		head.append(' ');
		head.append(headline);
		head.append(' ');

		for (int i = 0; i < dashLength / 2; i++)
			head.append('-');

		System.out.println(head);
		System.out.format(sizeField, "size");
		for (Test test : tests)
			System.out.format(stringField(), test.name);
		System.out.println();
	}

	//
	public void timedTest() {
		displayHeader();
		for (TestParam param : paramList) {
			System.out.format(sizeField, param.size);
			for (Test<C> test : tests) {
				C kontainer = initialize(param.size);
				long start = System.nanoTime();
				int reps = test.test(kontainer, param);
				long duration = System.nanoTime();
				long timePerRep = duration / reps;
				System.out.format(numberField(), timePerRep);
			}
			System.out.println();
		}
	}
}

