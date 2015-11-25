package com.chapter.three;

public final class CaseInsensitiveString {
	private final String s;
	
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
	
}
