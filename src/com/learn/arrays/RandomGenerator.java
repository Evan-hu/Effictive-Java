package com.learn.arrays;

import java.util.Random;

public class RandomGenerator {
	private static Random r = new Random(47);

	public static class Boolean extends CountingGenerator.Boolean {

		public java.lang.Boolean next() {
			return r.nextBoolean();
		}
	}

	public static class Byte extends CountingGenerator.Byte {

		public java.lang.Byte next() {
			return (byte) r.nextInt();
		}
	}

	// static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
	// "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

	public static class Character extends CountingGenerator.Character {

		public java.lang.Character next() {
			return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
		}
	}

	public static class String extends CountingGenerator.String {
		{
			cg = new Character();
		}

		public String() {
		}

		public String(int length) {
			super(length);
		}

		public static class Short implements Generator<java.lang.Short> {

			public java.lang.Short next() {
				return (short) r.nextInt();
			}

		}
	}

	public static class Short extends CountingGenerator.Short {
		public java.lang.Short next() {
			return (short) r.nextInt();
		}
	}

	public static class Integer extends CountingGenerator.Integer {
		private int mod = 1000;

		public Integer() {
		}

		public Integer(int module) {
			this.mod = module;
		}

		public java.lang.Integer next() {
			return r.nextInt(mod);
		}
	}

	public static class Long extends CountingGenerator.Long {
		private int mod = 1000;

		public Long() {
		}

		public Long(int module) {
			this.mod = module;
		}

		public java.lang.Long next() {
			return new java.lang.Long(r.nextInt(mod));
		}
	}

	public static class Float extends CountingGenerator.Float {
		public java.lang.Float next() {
			int trimed = Math.round(r.nextFloat() * 100);
			return ((float) trimed) / 100;
		}
	}

	public static class Double extends CountingGenerator.Double {
		public java.lang.Double next() {
			long trimed = Math.round(r.nextDouble() * 100);
			return ((double) trimed) / 100;
		}
	}

}
