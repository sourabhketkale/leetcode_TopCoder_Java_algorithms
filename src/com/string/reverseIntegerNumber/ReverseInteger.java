package com.string.reverseIntegerNumber;

public class ReverseInteger {

	public int ReverseNumber(int x){
	 
	   String numHolder = Integer.toString(x);
	   String[] numContainer = new String[numHolder.length()];
	   if(numHolder.contains("-")){
		   numContainer =numHolder.split("-");
		   StringBuilder builder = new StringBuilder(numContainer[1]);
		   String out= "-" + builder.reverse().toString();
		   return Integer.parseInt(out);
	   }else{
		   numContainer[0]=numHolder;
		   StringBuilder builder = new StringBuilder(numContainer[0]);
		   String out = builder.reverse().toString();
		   return Integer.parseInt(out);
	   }

 }
	
	

	public static void main(String[] args) {
		// TODO Auto-enerated method stub
			
		ReverseInteger reverseInteger = new ReverseInteger();
		System.out.println(reverseInteger.ReverseNumber(-1020));
		
	}

}
