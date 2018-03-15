package com.problems.miscellaneous;

public class SlidingWindowMaximum {
	
	 public static int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums == null || nums.length == 0  || k<=1)
	            return nums;
	        int[] left_max = new int[nums.length];
	        int[] right_max = new int[nums.length];
	        left_max[0] = nums[0];
	        right_max[nums.length-1] = nums[nums.length-1];
	        
	        for(int i=1; i<nums.length; i++){
	            left_max[i] = (i%k == 0) ? nums[i] : Math.max(nums[i], left_max[i-1]);
	            
	            int j = nums.length-1-i;
	            right_max[j] = (j%k == 0) ? nums[j] : Math.max(nums[j], right_max[j+1]);
	        }
	        
	        int[] maxWindow = new int[nums.length-k+1];
	        for(int i=0; i<maxWindow.length; i++)
	            maxWindow[i] = Math.max(right_max[i], left_max[i+k-1]);
	        
	        return maxWindow;
	    }
	
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[8];
		nums[0] = 1;
		nums[1]= 3;
		nums[2]= -1;
		nums[3]= 3;
		nums[4] = 5;
		nums[5] = 3;
		nums[6] = 6;
		nums[7]= 7;
		System.out.println(SlidingWindowMaximum.maxSlidingWindow(nums, 3 ));

	}

}
