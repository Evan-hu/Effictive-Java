package com.learn.arrays;

import java.util.Iterator;
import java.util.TreeMap;

public class StoredMapDemo {
//	main 
	public static void main1(String [] args) {
		TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));
		System.out.println(sortedMap);
		
		Integer low = sortedMap.firstKey();
		Integer high = sortedMap.lastKey();
		System.out.println("Low = " + low + "  High = " + high);
		
		Iterator<Integer> it = sortedMap.keySet().iterator();
		for (int i =0 ; i <= 6; i++) {
			if (i == 3) low = it.next();
			if (i == 6) high = it.next();
			else it.next();
		}
		
		System.out.println(low);
		System.out.println(high);
		System.out.println(sortedMap.subMap(low, high)); // get a subMap from 3 to 6
		System.out.println(sortedMap.headMap(high)); // end with the High location (6)
		System.out.println(sortedMap.tailMap(low)); // from Low location(3) start
		
	}
	
	
}
