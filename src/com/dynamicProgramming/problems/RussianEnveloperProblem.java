package com.dynamicProgramming.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * Sort the array. Ascend on width and descend on height if width are same.
	Find the longest increasing subsequence based on height.
	The key is to realise that after sorting using comparater, the longest increasing subsequesnce would be the action of 
	putting smaller envelopes into bigger envelopes
	
	Since the width is increasing, we only need to consider height.
	[3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted
 	as an increasing number if the order is [3, 3], [3, 4]
 * */
public class RussianEnveloperProblem {

	public int maxEnvelopes(int[][] envelopes) {
	    if(envelopes == null || envelopes.length == 0 
	       || envelopes[0] == null || envelopes[0].length != 2)
	        return 0;
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        public int compare(int[] arr1, int[] arr2){
	            if(arr1[0] == arr2[0])
	                return arr2[1] - arr1[1];
	            else
	                return arr1[0] - arr2[0];
	       } 
	    });
	    int dp[] = new int[envelopes.length];
	    int len = 0;
	    for(int[] envelope : envelopes){
	        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
	        if(index < 0)
	            index = -(index + 1);
	        dp[index] = envelope[1];
	        if(index == len)
	            len++;
	    }
	    return len;
	}
	
	/*public int maxEnvelopesSolution2( int[][] envelopes){
		Map<int[][], ArrayList<int[][]>>  fitEnveloperContainer = new HashMap<>();
		if(envelopes == null || envelopes.length == 0 
			       || envelopes[0] == null || envelopes[0].length != 2)
			        return 0;
			    Arrays.sort(envelopes, new Comparator<int[]>(){
			        public int compare(int[] arr1, int[] arr2){
			            if(arr1[0] == arr2[0])
			                return arr2[1] - arr1[1];
			            else
			                return arr1[0] - arr2[0];
			       } 
			    });
		for(int i=0; i< envelopes[0].length;i++){
			if(envelopes[i][0] < envelopes[i+1][0]){
				if(){
					
					
				}
			}
			
		}
		
		return 0;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RussianEnveloperProblem russianObj = new RussianEnveloperProblem();
		int[][] input = new int[4][2];
		input[0][0] = 5;
		input[1][0] = 6;
		input[2][0] = 6;
		input[3][0] = 2;
		
		input[0][1] = 4;
		input[1][1] = 4;
		input[2][1] = 7;
		input[3][1] = 3;
		russianObj.maxEnvelopes(input);
		
	}

}
