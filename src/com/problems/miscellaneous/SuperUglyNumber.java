package com.problems.miscellaneous;

public class SuperUglyNumber {
		
	public static int nthSuperUglyNumberI(int n, int[] primes) {
	    int[] ugly = new int[n];
	    int[] idx = new int[primes.length];

	    ugly[0] = 1;
	    for (int i = 1; i < n; i++) {
	        //find next
	        ugly[i] = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++)
	            ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
	        
	        //slip duplicate
	        for (int j = 0; j < primes.length; j++) {
	            while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
	        }
	    }

	    return ugly[n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] primes = new int[4];
		primes[0]=2;
		primes[1]=7;
		primes[2]=13;
		primes[3]=19;
		
		System.out.println(SuperUglyNumber.nthSuperUglyNumberI(8,primes));
	}

}
