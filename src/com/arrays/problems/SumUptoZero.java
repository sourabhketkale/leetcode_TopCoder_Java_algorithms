package com.arrays.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem statement: Given an array of integer elements, find the 3 integers who sum upto 0.
 * input: {1, 5, 3, -8, 0, 7, 11,9}
 * output:{5,3,-8}
 * 
 * Logic: Fill  all the elements of the array into a hashmap and check for the negative sum value of the third number in the hashmap
 * a+b+c = 0
 * b+c =-a
 * */

public class SumUptoZero {

	ArrayList<Integer> elementSumtozero(int[] elements){
		int[] resultElements = new int[3];
		
		if(elements.length<3){
			return null;
		}
		Map<Integer, ArrayList<Integer>> container = new HashMap<>();
		for(int i=0; i< elements.length; i++){
			for(int j=i+1;  j<elements.length;j++){
				ArrayList< Integer> numberWithSumeZero =  new ArrayList<>();
				numberWithSumeZero.add( elements[i]);
				numberWithSumeZero.add(elements[j]);
				container.put(elements[i]+elements[j],numberWithSumeZero);
			}
		}	
		
		for(int k=0; k< elements.length;k++){
			int negativeValueOfSum = -elements[k];	
			if(container.containsKey(negativeValueOfSum)){
				ArrayList<Integer> numberWithSumZeroToreturn =container.get(negativeValueOfSum);
				numberWithSumZeroToreturn.add(negativeValueOfSum);
				return numberWithSumZeroToreturn;
			}
		}
		
	
		return null;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] elements = {1, 5, 3, -8, 0, 7, 11,9};
		//int[] elements = {0, 0, 0, 0, 0, 7, 11,9};
		//int[] elements = {};
		SumUptoZero sumObject = new SumUptoZero();
		System.out.println(sumObject.elementSumtozero(elements));
		
	}

}
