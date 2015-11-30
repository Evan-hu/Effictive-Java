package com.chapter.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class PhoneNumber implements Comparable<PhoneNumber>{
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "lineNumber");
		this.areaCode = (short)areaCode;
		this.prefix = (short)prefix;
		this.lineNumber = (short)lineNumber;
	}
	
	public static void rangeCheck (int arg, int max, String name) {
		if (arg < 0 || arg > max) {
			throw new IllegalArgumentException(name + ":" + arg);
		}
	}
	
	@Override public boolean equals (Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNumber == lineNumber && 
			pn.areaCode == areaCode && 
			pn.prefix == prefix;
	}
	
	@Override public int hashCode() {
		int result = 17;
		result = 31 *result + lineNumber;
		result = 31 *result + areaCode;
		result = 31 *result + prefix;
		return result;
	}
	
	/**
	 * 设置不同类型的比较
	 */
	public int compareTo(PhoneNumber o) {
		if (areaCode < o.areaCode)
			return -1;
		if (areaCode > o.areaCode)
			return 1;
		
		//optimize structure
		int areaCodeDiff = areaCode-o.areaCode;
		if (0 != areaCodeDiff)
			return areaCodeDiff;
		
		return 0;
	}
	
	
	
//	设置Set的比较代码,  没有使用原始类型，这样做比较安全，如果换成Set就危险
		static int numElementsInCommon(Set<?> s1, Set<?> s2) {
			int result = 0;
			for (Object o1 : s1)
				if (s2.contains(o1))
					result++;
			return result;
		}
		
//		优先考虑泛型方法
		static <E> E reduce(List<E> list, Function<E> f, E initval) {
			List<E> snalshot;
			synchronized (list) {
				snalshot = new ArrayList<E>(list);
			}
			E result = initval;
			for (E e: list)
				result = f.apply(result, e);
			return result;
		}
	
}

interface Function<T>{
	T apply(T arg1, T arg2);
}


