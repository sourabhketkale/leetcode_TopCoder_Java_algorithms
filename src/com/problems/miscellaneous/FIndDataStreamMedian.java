package com.problems.miscellaneous;

public class FIndDataStreamMedian {
	
	
	public  static int findLength(int[] A, int[] B) {
        int max = 0;
        if (A == null || B == null) return max;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[5];
		a[0]=1;
		a[1]=2;
		a[2]=3;
		a[3]=2;
		a[4]=1;
		
		int[] b = new int[5];
		b[0]=3;
		b[1]=2;
		b[2]=1;
		b[3]=4;
		b[4]=7;
		
		System.out.println(FIndDataStreamMedian.findLength(a, b));
	}

}
