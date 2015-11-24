package com.chapter.two;

public class Nutri {
	private final int serSize;
	private final int serings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	public static class Builder {
		private final int serSize;
		private final int serings;
		private int calories;
		private int fat;
		private int sodium;
		private int carbohydrate;
		
		public Builder(int serSize, int servings) {
			this.serSize = serSize;
			this.serings = servings;
		}
		
		public Builder calorise(int val) {
			calories = val;
			return this;
		}
		
		public Builder fat(int val) {
			fat = val;
			return this;
		}
		
		public Builder sodium(int val) {
			sodium = val;
			return this;
		}
		
		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}
		
		public Nutri builder() {
			return new Nutri(this);
		}
	}
	
	
	private Nutri(Builder builder) {
		serings = builder.serings;
		serSize = builder.serSize;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
}
