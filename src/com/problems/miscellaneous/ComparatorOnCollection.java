package com.problems.miscellaneous;

/**
 * Input : ccbbbbdddxxxxxaaaaaaxxxxyrrr
 * output: xxxxxxxxxaaaaaabbbbrrrdddccy
 * 
 * */

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ComparatorOnCollection {

	
	/**
	 * 
	 * @method: Method to implement the string reform by collecting the alphabets and occurrences into the collection and s
	 * 			sorting them
	 * */
	public static StringBuilder stringReform(String input) {

		String returnString = "";
		String[] inputContainer = new String[input.length()];
		inputContainer = input.split("");
		Map<String, Integer> unsortedMap = new TreeMap<>();
		
		if(input.length()==0){
			return null;
		}
		for (int i = 0; i < inputContainer.length; i++) {

			if (unsortedMap.containsKey(inputContainer[i])) {
				int value = unsortedMap.get(inputContainer[i]);
				value++;
				unsortedMap.put(inputContainer[i], value);
			} else {
				unsortedMap.put(inputContainer[i], 1);
			}
		}

		Map<String, Integer> sortedMap = sortBtValues(unsortedMap);
		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {

			for (int i = 0; i < entry.getValue(); i++) {

				returnString = returnString + entry.getKey();
			}
		}

		return new StringBuilder(returnString).reverse();

	}

	/**
	 * @method: To sort Treemap collection on  basis values using a comparators 
	 * 
	 * 
	 * */
	public static <K, V extends Comparable<V>> Map<K, V> sortBtValues(final Map<K, V> map) {

		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));

				if (compare == 0) {
					return 1;
				} else {
					return compare;
				}
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ComparatorOnCollection.stringReform("ccbbbbdddxxxxxaaaaaaxxxxyrrr"));

	}

}
