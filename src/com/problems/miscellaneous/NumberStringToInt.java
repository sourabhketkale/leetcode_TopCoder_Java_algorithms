package com.problems.miscellaneous;

public class NumberStringToInt {

	 public static int getNumber(String number) {
		    int result = 0;
		    boolean isNegative = false;
		    if(number.charAt(0)=='-'){
		    	String[] numberWithNegativeSign = number.split("-");
		    	number = numberWithNegativeSign[1];
		    	isNegative= true;
		    }
		    for (int i = 0; i < number.length(); i++) {
		        
		        //System.out.println(number.charAt(i)-'0');
		    	int inter = number.charAt(i) - '0';
		        System.out.println(inter);
		        result = result * 10 + inter;
		        
		    }
		    if(isNegative){
		    	return 0-result;
		    }else{
		    	return result;
		    }
		    
		}

		     public static void main(String []args){
		        
		        
		    	 NumberStringToInt hw = new  NumberStringToInt();
		        //System.out.println('1'-'0');
		        System.out.println(NumberStringToInt.getNumber("-3495"));
		        
		        
		     }
}
