package com.problems.miscellaneous;

import java.util.Arrays;


/*
 * @problem: 3 sum closest problem leetcode: https://leetcode.com/problems/3sum-closest/description/ 
 * 
 * **/
public class SumClosest {
	
	public static int FindClosest( int[] num, int target){
		
		int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }     
        return result;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {-1, 2, 1, -4};
		
		System.out.println(SumClosest.FindClosest(input, 1));
	}

}
