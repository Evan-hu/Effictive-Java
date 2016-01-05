package com.learn.arrays;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
	public static void main(String [] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(new CountingMapData(9));
		System.out.println("LinkedMap = " + linkedMap);
		
		// least-recently-used order
		linkedMap = new LinkedHashMap<Integer, String>(16, .75f, true);
		linkedMap.putAll(new CountingMapData(9));
		
		System.out.println(linkedMap); // print origin Map
		for (int i = 0; i < 6; i++)
			linkedMap.get(i);
		
		// 修改后的 Map 显示访问后，指针到了倒数第三个；
		// 打印时，指针也就到了这个位置(倒数第三个)
		System.out.println(linkedMap);
		linkedMap.get(0);
		
		System.out.println(linkedMap);
	}
	
}
