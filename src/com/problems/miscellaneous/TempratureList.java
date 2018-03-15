package com.problems.miscellaneous;

import java.util.Stack;

public class TempratureList {
	
	public static int[] dailyTemperatures(int[] temperatures) {
	    Stack<Integer> stack = new Stack<>();
	    int[] ret = new int[temperatures.length];
	    for(int i = 0; i < temperatures.length; i++) {
	        while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
	            int idx = stack.pop();
	            ret[idx] = i - idx;
	        }
	        stack.push(i);
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temps = new int[8];
		temps[0]=73;
		temps[1]=74;
		temps[2]=75;
		temps[3]=71;
		temps[4]=69;
		temps[5]=72;
		temps[6]=76;
		temps[7]=73;
		
		
		System.out.println(TempratureList.dailyTemperatures(temps));
	}

}
