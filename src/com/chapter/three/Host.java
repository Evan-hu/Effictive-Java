package com.chapter.three;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 
 * @Description: 实现策略模式：：Exporting a concrete strategy
 *
 * @author Evan
 *
 * @date 2015年11月28日 下午2:05:14
 */
class Host {
	@SuppressWarnings({ "unused", "rawtypes", "serial" })
	private static class StrLenCmp implements Comparator, Serializable {

		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return ((String) o1).length() - ((String) o2).length();
		}

		public static final Comparator STRING_LENGTH_COMPARE = new StrLenCmp();

	}
}
