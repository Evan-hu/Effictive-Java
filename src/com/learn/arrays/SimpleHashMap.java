package com.learn.arrays;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

	static final int SIZE = 997;
	
	@SuppressWarnings("unchecked")
	// bucket 代表散列表中的“槽位”，为使散列分布均匀，桶的数量通常为质数
	LinkedList<MapEntry<K,V>> [] buckets = new LinkedList[SIZE];
	
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) { // 判断 index 位置是否为空， 为空就 赋一个LinkedList
			buckets[index] = new LinkedList<MapEntry<K, V>>();
		}
		
		// 不为空， 则 取出对应的 LinkedList
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		boolean found = false;
		
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		// 判断 LinkedList 中是否有值
		while (it.hasNext()) {
			// 取 LinkedList 的值
			MapEntry<K, V> iPair = it.next(); 
			// 如果 key 值相等， 则用新的值 取代旧的值
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				break;
			}
		}
		// 如果没有找到对应的key 就 add
		if (!found)
			buckets[index].add(pair);
		
		return oldValue;
	}
	
	
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) return null; 
		for (MapEntry<K, V> iPair: buckets[index])
			if (iPair.getKey().equals(key))
				return iPair.getValue();
		return null;
		
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null ) continue;
			for (MapEntry<K, V> mpair : bucket)
				set.add(mpair);
		}
		return set;
	}
	
	
	public static void main(String [] args) {
		SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
		System.out.println(m);
	}

}
