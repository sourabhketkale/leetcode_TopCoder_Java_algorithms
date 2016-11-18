package com.elementsOfProgramming.problems;


/**
 * Problem Statement: 
 * Problems  : 
 * 
 * 	5.1: Calculate parity of the 64 bit number.
 * 	5.3: Write a function that takes a 64-bit integer x and returns a 64-bit integer
                consisting of the bits of x in reverse order. #Elements of programming
 * 	Playing around with bits. Knowing the Combinations of ~,^,&,| to be put to use
 * 
 * @input: int input 32 bit number  
 * 
 * */

public class BitReversalProblem {

	
	boolean calculateParityUtil(long input){
		
		
		return false;
	}
	
	 public static int reverseBitsInt(int x) {
		  int intSize = 32;
		  int y=0;
		  System.out.println("\tx:"+x+"\ty:"+y);
		  for(int position=intSize-1; position>0; position--){
		    y+=((x&1)<<position);
		    x >>= 1;
		    System.out.println("\tposition th:"+position+"\tx:"+x+"\ty:"+y);
		  }
		  return y;
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long input= 32;

	    int a = 39;	/* 60 = 0011 1100 */
	    int b = 15;	/* 13 = 0000 1101 */
	    int c = 0;
	    //System.out.println(BitReversalProblem.reverseBitsInt(a));
	    
	    System.out.println(BitReversalProblem.reverseBitsInt(a));
	    
	    /* System.out.println(Integer.toBinaryString(a));
	    System.out.println(BitReversalProblem.reverseBitsInt(a));
	    System.out.println(Integer.toBinaryString(BitReversalProblem.reverseBitsInt(a)));
	    System.out.println(Integer.toBinaryString(BitReversalProblem.reverseBitsInt(a)).length());
	    */
	    
		/*System.out.println("Pure longnumber:"+input);
		System.out.println((input >> 128));1073741824*/
			
	}

}
