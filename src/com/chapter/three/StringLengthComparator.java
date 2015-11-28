package com.chapter.three;


/**
 * 
 * @Description: 可以用作SingleTon
 *
 * @author Evan
 *
 * @date 2015年11月28日 下午1:57:34
 */
class StringLengthComparator {
	private StringLengthComparator() {
	}

	public static final StringLengthComparator INSTANCE = new StringLengthComparator();
	
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}
