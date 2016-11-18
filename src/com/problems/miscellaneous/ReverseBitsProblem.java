package com.problems.miscellaneous;

import java.math.BigInteger;

/**
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
26
Related problem: Reverse Integer
 * 
 * */

public class ReverseBitsProblem {
	
	
	long reverseBits(long input){
		
		if(input > 2147483647){
			
			
		}
		if(input==0){
			return 0;
		}
		String binaryString =  Long.toBinaryString(input);
		StringBuilder toConcate = new StringBuilder();
		int limit = 32-binaryString.length()%32;
		if(binaryString.length()!=32){
			
			for(int i=0; i< limit; i++){
				toConcate=toConcate.append("0");
			}
			binaryString = toConcate + binaryString;
		}
		StringBuilder reverseBinaryString = new StringBuilder(binaryString).reverse();
		
		
		return Long.parseLong(reverseBinaryString.toString(), 10);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReverseBitsProblem bitsProblem = new ReverseBitsProblem(); 
		bitsProblem.reverseBits(43261596);
		
	}

}
