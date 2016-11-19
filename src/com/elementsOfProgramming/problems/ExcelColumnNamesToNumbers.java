package com.elementsOfProgramming.problems;

/**
 * 
 * Elements of programming:- 5.8:-Write a function that converts Excel column ids to the corresponding
 *								  integer, with" A" corresponding to 1. The function signature is int
 * 								  ssDecodeColID(string); you may ignore error conditions, such as col containing
 *								  characters outside of [A, Z). How would you test your code? 
 *
 * 
 * */

public class ExcelColumnNamesToNumbers {

	
	public static StringBuilder convertColumnNamesToNumbers(String input){
		
		int lengthOfColumnName= input.length();
		char[] inputToCharArray = input.toCharArray();
		StringBuilder outputBuilder =  new StringBuilder();
		for(int i=0;i<lengthOfColumnName;i++){

			char ch = inputToCharArray[i];
			outputBuilder = outputBuilder.append((int)inputToCharArray[i]);
			
			
		}
		
		
		return outputBuilder;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ExcelColumnNamesToNumbers.convertColumnNamesToNumbers("DAB"));
		
		
	}

}
