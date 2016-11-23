package com.problems.miscellaneous;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Problem Statement :  Find the maximum possible time from given 4 integers ranging from 0 to 9
 * 
 * 
 * @input:solution(int a , int b, int c, int d)-> 0,9,7,3
 * 
 * @output: 07:39
 * 
 * */


public class ArrangeInDateFormat {
	
	/*
	 * @method: Naive solution to find the maximum time. An attempt to find the maximum time in O(1)
	 * 
	 * public static String convertToDateUtil(int a, int b, int c, int d){
		 
		String dateFormatToReturn ="";
		ArrayList<Integer> inputContainer=  new ArrayList<>();
		inputContainer.add(a);
		inputContainer.add(b);
		inputContainer.add(c);
		inputContainer.add(d);
		int h1 = 0,h2=0,m1=0,m2=0;
		int flagH1=0,flagH2=0,flagH3=0,flagH4=0;
		int indexH1=0,indexH2=0,indexM1=0,indexM2=0;
		Collections.sort(inputContainer);
		
		if(inputContainer.contains(2)){
			h1=2;
			indexH1 = inputContainer.indexOf(inputContainer.contains(h1));
		}else if(inputContainer.contains(1)){
			h1=1;
			indexH1 = inputContainer.indexOf(inputContainer.contains(h1));
		}else if(inputContainer.contains(0)){
			h1=0;
			indexH1 = inputContainer.indexOf(inputContainer.contains(h1));
		}else{
			return "NOT POSSIBLE1"; //h1 setteled
		}
		if(h1==0){
			if(indexH1!= inputContainer.indexOf(inputContainer.get(0))){
				h2=inputContainer.get(0);
				indexH2 = inputContainer.indexOf(h2);
			}else{
				h2 = inputContainer.get(1);
				indexH2 = inputContainer.indexOf(h2);
			}
		}else{
			if(h1==1){
				if(inputContainer.indexOf(inputContainer.get(0))!= indexH1){
					h2=inputContainer.get(0);
					indexH2=inputContainer.indexOf(inputContainer.get(h2));
				}
				
			}else if(h1==2){								//h2 setteled
				
				if(inputContainer.get(0)<4 && inputContainer.indexOf(inputContainer.get(1))!= indexH1){
					h2 = inputContainer.get(1);
					indexH2=inputContainer.indexOf(inputContainer.get(h2));
				}else if(inputContainer.get(2)<4 && inputContainer.indexOf(inputContainer.get(2))!= indexH1){
					h2 = inputContainer.get(2);
					indexH2=inputContainer.indexOf(inputContainer.get(h2));
				}else if(inputContainer.get(3)<4 && inputContainer.indexOf(inputContainer.get(3))!= indexH1){
					h2 = inputContainer.get(3);
					indexH2=inputContainer.indexOf(inputContainer.get(h2));
				}else{
					return "NOT POSSIBLE2";
					
				}
			}
		}if(h2<4){
			if(inputContainer.indexOf(inputContainer.get(1))!=indexH1 || inputContainer.indexOf(inputContainer.get(1))!=indexH2){
				if(inputContainer.get(1)<6){
					m1 = inputContainer.get(1);
					indexM1 = inputContainer.get(m1);
				}
			} else if(inputContainer.indexOf(inputContainer.get(2))!=indexH1 || inputContainer.indexOf(inputContainer.get(2))!=indexH2 && inputContainer.get(2)<6){
				m1 = inputContainer.get(2);
				indexM1 = inputContainer.get(m1);
			}  else if(inputContainer.indexOf(inputContainer.get(3))!=indexH1 || inputContainer.indexOf(inputContainer.get(3))!=indexH2 && inputContainer.get(3)<6){
				m1 = inputContainer.get(3);
				indexM1 = inputContainer.get(m1);
			}  else if(inputContainer.indexOf(inputContainer.get(0))!=indexH1 || inputContainer.indexOf(inputContainer.get(0))!=indexH2 && inputContainer.get(0)<6){
				m1 = inputContainer.get(0);
				indexM1 = inputContainer.get(m1);
			}else{return "NOT POSSIBLE3";}
		}else{return "NOT POSSIBLE4";}
		for(int i=0;i<4;i++){
			if(i!=indexH1 && i!=indexH2 && i!=indexM1){
				m2 = inputContainer.get(i);
				
			}
		}
		
		dateFormatToReturn = Integer.toString(h1)+Integer.toString(h2)+":"+Integer.toString(m1)+Integer.toString(m2);
		
		return dateFormatToReturn;
	 }*/
	
	static List<List<Integer>> permutatedList = new ArrayList<>();
	
	/**
	 * @Method: method to find the maximum time from the permutations produced from the numbers and return the maximum string time
	 * 
	 * @input: int a, int b, int c, int d
	 * @output: String maxTime
	 * 
	 * */
	public static String findMaxDateUtil(int a, int b, int c, int d){
		
		String maxDateToReturn = "";
		int[] input ={a,b,c,d};
	
		
		List<List<Integer>> datePermutationsList =doPermutationHelper(input);
		List<Integer> tempContainer = new ArrayList<>();
		
		
		for(List<Integer> iterator : datePermutationsList){
			if((iterator.get(0)==1 || iterator.get(0)==2 ||  iterator.get(0)==0) && (iterator.get(1)<4) && (iterator.get(2)<6) ){

				tempContainer.add(Integer.parseInt(iterator.toString().replaceAll("[\\[\\-\\+\\.\\^:,\\]\\s]","")));
			}else if(iterator.get(0)==1){
				if(iterator.get(0)!=2 && iterator.get(2) < 6){
					tempContainer.add(Integer.parseInt(iterator.toString().replaceAll("[\\[\\-\\+\\.\\^:,\\]\\s]","")));
				}
			}else if(iterator.get(0)==0 && iterator.get(1) > 4){
				tempContainer.add(Integer.parseInt(iterator.toString().replaceAll("[\\[\\-\\+\\.\\^:,\\]\\s]","")));
			}
		}if(tempContainer.isEmpty()){
			return "NOT POSSIBLE";
		}
		
	
		Collections.sort(tempContainer);
		
		String[] returnMaxDate = tempContainer.get(tempContainer.size()-1).toString().split("");
		if(returnMaxDate.length!=3){
			return returnMaxDate[0]+returnMaxDate[1]+":"+returnMaxDate[2]+returnMaxDate[3];
		}else{
			return "0"+returnMaxDate[0]+":"+returnMaxDate[1]+returnMaxDate[2];
		}
		
		
	}
	
	/**
	 * @method: This method computes the permutations of the possible Times
	 * 
	 * */
	public static List<List<Integer>> doPermutationHelper(int[] input) {
    	List<List<Integer>> datePermutationsList= doPermutationHelper1(input, 0, input.length - 1);
    	
    	return datePermutationsList;
    }
	/**
	 * 
	 * @method: Calculate all the permutations of the input as Times
	 * */
	
    public static List<List<Integer>> doPermutationHelper1(int[] a, int l, int r) {
        int i;
        List<Integer> tempList = new ArrayList<>();
        
        if (l == r) {
           for( i=0; i<a.length;i++){
        	 //  System.out.print(a[i]) ;  
        	   tempList.add(a[i]);
           }
           //System.out.println("");
           permutatedList.add(tempList);
            
        } else {
            for (i = l; i <= r; i++) {
                swap(a, l, i);
                doPermutationHelper1(a, l+1, r);
                swap(a, l, i); //backtrack
            }
        }
		return permutatedList;
    }

    public static void swap(int[] a, int i1, int i2) {
        int tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,3,7,8};
		System.out.println(ArrangeInDateFormat.findMaxDateUtil(3, 4, 5, 0));
	

	}

}
