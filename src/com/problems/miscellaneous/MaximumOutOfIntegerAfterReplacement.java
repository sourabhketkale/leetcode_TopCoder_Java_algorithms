package com.problems.miscellaneous;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MaximumOutOfIntegerAfterReplacement {
	
	int replaceAndFindMaximum(long input){
		
		String numberBuffer = Long.toString(input);
		ArrayList<Integer> numberContainerAfterOperation = new ArrayList<>();
		
		if(Long.toString(input).length()<2){
			return (int)input;
		}
		for(int i=0;i<numberBuffer.length()-1;i++){
			String rightPartOfTheNumber = "";
			String leftPartOfTheNumber = "";
			if(Integer.valueOf(numberBuffer.charAt(i))> Integer.valueOf(numberBuffer.charAt(i+1))){
				
				if(i!=0){
					leftPartOfTheNumber = numberBuffer.substring(0,i );
				}
				if(i!=numberBuffer.length()-2){
					rightPartOfTheNumber = numberBuffer.substring(i+2, numberBuffer.length());
				}
				String tempNumber = leftPartOfTheNumber + numberBuffer.charAt(i) + rightPartOfTheNumber;
				numberContainerAfterOperation.add(Integer.valueOf(tempNumber));
			}else {
				if(i!=0){
					leftPartOfTheNumber = numberBuffer.substring(0,i );
				}
				if(i!=numberBuffer.length()-2){
					rightPartOfTheNumber = numberBuffer.substring(i+2, numberBuffer.length());
				}
				String tempNumber = leftPartOfTheNumber + numberBuffer.charAt(i+1) + rightPartOfTheNumber;
				numberContainerAfterOperation.add(Integer.valueOf(tempNumber));
			}
		}
		//System.out.println(numberContainerAfterOperation);
		Collections.sort(numberContainerAfterOperation);
		
		return numberContainerAfterOperation.get(0);
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution maxobj = new Solution();
		System.out.println(maxobj.solution(29384697));

	}

}
