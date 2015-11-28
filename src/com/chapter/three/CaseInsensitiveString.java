package com.chapter.three;

public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString>{
	private final String s;

//	Lazily init
	private volatile int hashCode;
	
	public CaseInsensitiveString(String s) {
		if (null == s) 
			throw new NullPointerException();
		this.s = s;
	}
	
	@Override public boolean equals(Object o) {
//		if (o instanceof CaseInsensitiveString) 
//			return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//		if (o instanceof String) 
//			return s.equalsIgnoreCase((String) o);
		
		return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
	}
	
	/**
	 * 指定toString（） 方法返回的字符串格式
	 */
	@Override public String toString() {
		return String.format("%s", s);
	}

	
	/**
	 * 
	 */
	public int compareTo(CaseInsensitiveString o) {
		
		return 0;
	}
	
	
}
