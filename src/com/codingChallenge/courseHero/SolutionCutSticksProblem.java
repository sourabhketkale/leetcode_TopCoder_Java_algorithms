package com.codingChallenge.courseHero;

/**
 * Sticks cut problem: keep cutting the lengths of the stick with the smallest element in the lengths and return the counts of how
 * how many times the stick were cut. only stick with length geater than 1 can be cut
 * 
 * Input: lengths = {6,5,4,4,2,2,8};
 * output :(6,4,2,1)
 * 
 * */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SolutionCutSticksProblem {

	 static int[] cutSticks(int[] lengths) {
	        
	        int noOfGivenLength =lengths[0];
	        ArrayList<Integer> tempLengthContainer =  new ArrayList<>();
	        int[] lengthsContainer = new int[noOfGivenLength];
	        lengthsContainer = removeFirstElement(lengths);
	        //sort
	        if(lengths.length<2){
	        	return null;
	        	
	        }
	        Arrays.sort(lengthsContainer);
	        int countOfCuts= 0;
	        boolean canCut =false;
	        
	        while(zeroCheck(lengthsContainer)!=true){
	        			int smallestCuttablepart = getTheSmalletElementInArray(lengthsContainer);
	        			for(int i =0; i<lengthsContainer.length;i++){
	    		        	if(lengthsContainer[i]>0){
	    		        		lengthsContainer[i] =lengthsContainer[i]-smallestCuttablepart;
	    		        		countOfCuts++;
	    		        	}
	    		        }
	        			tempLengthContainer.add(countOfCuts);
	        			countOfCuts=0;
	        			
	        }
	        return convertIntegers(tempLengthContainer);
	     }
	 
	 static boolean  zeroCheck(int[] lengthContainer){
		 
		 int zeroCheckcounter = 0;
	        for(int i = 0; i< lengthContainer.length;i++){
	        	if(lengthContainer[i]==0){
	        		zeroCheckcounter++;
	        		continue;
	        	}
	        	else{
	        		break;
	        	}
	        }
	        if(zeroCheckcounter==lengthContainer.length){
	        	return true;
	        }
	        else{
	        	return false;
	        }
		 
	 }
	 static int getTheSmalletElementInArray(int[] lengthsContainers){
		 Arrays.sort(lengthsContainers);
		 int smallestCuttablePart=0;
		 for(int i=0; i<lengthsContainers.length;i++){
			  if(lengthsContainers[i]!=0){
				  smallestCuttablePart = lengthsContainers[i];
				  break;
			  }
			 
		 }
		 return smallestCuttablePart;
		 
	 }
	 public static int[] convertIntegers(ArrayList<Integer> integers)
	 {
	     int[] ret = new int[integers.size()];
	     Iterator<Integer> iterator = integers.iterator();
	     for (int i = 0; i < ret.length; i++)
	     {
	         ret[i] = iterator.next().intValue();
	     }
	     return ret;
	 }
	static int[] removeFirstElement(int[] lengths){
		 ArrayList<Integer> tempBuffer= new ArrayList<>();
		 for(int i = 1; i < lengths.length; i++){
			 tempBuffer.add(lengths[i]);
		 }
		 
		 
		return convertIntegers(tempBuffer); 
	 }
	        
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] lengths = {6,5,4,4,2,2,8};
		//int[] lengths = {1,3};
		int[] cutLengthsContainer = cutSticks(lengths);
		for(int i=0;i<cutLengthsContainer.length;i++){
			System.out.println(cutLengthsContainer[i]);
			
		}
	
	}

}


