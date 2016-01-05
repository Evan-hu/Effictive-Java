package com.learn.arrays;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;


class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

	private int size = 9;
	private int number = 1;
	private char letter = 'A';

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public Integer next() {
				return number++;
			}

			public boolean hasNext() {
				return number < size;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

	}

	public Pair<Integer, String> next() {
		return new Pair<Integer, String>(number++, "" + letter++);
	}
}

public class MapDataTest {

	public static void main(String [] args) {
//		Set set = new SortedSet(){};
		System.out.println(MapData.map(new Letters(), 11));
		System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8));
		System.out.println(MapData.map(new CountingGenerator.Character(), "value", 6));
		System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
		System.out.println(MapData.map(new Letters(), "pop"));
	}

}
