package com.problems.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class FindMinTimeDifference {
	
	 public static int findMinDifference(List<String> timePoints) {
	        
	        int[] marked = new int[24*60];
	        for(String s : timePoints){
	            String[] arr = s.split(":");
	            int index = Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
	            if(marked[index] == 1)
	                return 0;
	            marked[index] = 1;
	        }
	        int first = Integer.MAX_VALUE, last = Integer.MAX_VALUE;
	        int prev = Integer.MAX_VALUE, curr = Integer.MAX_VALUE;
	        int min = Integer.MAX_VALUE;
	        
	        for(int i=0; i<24*60; i++){
	            if(marked[i] == 1){
	                if(prev == Integer.MAX_VALUE){
	                    if(first == Integer.MAX_VALUE)
	                        first = i;
	                    prev = i;
	                }
	                else{
	                    if(curr != Integer.MAX_VALUE)
	                        prev = curr;
	                    curr = i;
	                    last = i;
	                }
	            min = Math.min(min, curr-prev);
	            }
	        }
	        
	        return Math.min(min,24*60-last+first);
	    }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> timePoints = new ArrayList<String>();
		timePoints.add("23:30");
		timePoints.add("3:11");
		System.out.println(FindMinTimeDifference.findMinDifference(timePoints));

	}

}
