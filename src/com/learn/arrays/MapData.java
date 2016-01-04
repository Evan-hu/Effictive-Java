package com.learn.arrays;

import java.util.LinkedHashMap;

public class MapData<K, V> extends LinkedHashMap<K, V> {

	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> pair = gen.next();
			put(pair.key, pair.value);
		}
	}

	public MapData(Generator<K> genk, Generator<V> genv, int quantity) {
		for (int i = 0; i < quantity; i++)
			put(genk.next(), genv.next());
	}

	public MapData(Generator<K> genk, V value, int quantity) {
		for (int i = 0; i < quantity; i++)
			put(genk.next(), value);
	}

	public MapData(Iterable<K> genk, Generator<V> genv) {
		for (K key : genk)
			put(key, genv.next());
	}

	public MapData(Iterable<K> genk, V value) {
		for (K key : genk)
			put(key, value);
	}
	
	public static <K,V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
		return new  MapData<K, V>(gen, quantity);
	}

	public static <K,V> MapData<K, V> map(Generator<K> genk, Generator<V> genv, int quantity) {
		return new  MapData<K, V>(genk, genv, quantity);
	}

	public static <K,V> MapData<K, V> map(Generator<K> genk, V value, int quantity) {
		return new  MapData<K, V>(genk, value, quantity);
	}

	public static <K,V> MapData<K, V> map(Iterable<K> genk, Generator<V> genv) {
		return new  MapData<K, V>(genk, genv);
	}

	public static <K,V> MapData<K, V> map(Iterable<K> genk, V value) {
		return new  MapData<K, V>(genk, value);
	}
	
}
