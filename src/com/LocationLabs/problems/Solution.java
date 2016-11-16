package com.LocationLabs.problems;

public class Solution {

	static String rollingString(String s, String[] operations) {

		// String toBeManipulated =s;
		StringBuilder toBeManipulated = new StringBuilder(s);
		String stringAfterEachOperation = "";

		if (s.length() == 0 || operations.length == 0) {
			return null;

		}
		for (int i = 0; i < operations.length; i++) {
			String[] currentOperation = operations[i].split(" ");
			if (currentOperation[2].equals("R")) {

				toBeManipulated = performRollForwardStringmanipulation(Integer.parseInt(currentOperation[0]),Integer.parseInt(currentOperation[1]), toBeManipulated);
			}
			if (currentOperation[2].equals("L")) {

				toBeManipulated = performRollBackwardStringmanipulation(Integer.parseInt(currentOperation[0]),Integer.parseInt(currentOperation[1]), toBeManipulated);
			}

		}

		return toBeManipulated.toString();
	}

	static StringBuilder performRollForwardStringmanipulation(int startIndex, int endIndex,StringBuilder toBeManipulated) {
		String tempString="";
		if(endIndex==toBeManipulated.length()-1){
			tempString= toBeManipulated.substring(startIndex, endIndex);
		}else{
			tempString= toBeManipulated.substring(startIndex, endIndex+1);	
		}
		String[] remainingStringarray = toBeManipulated.toString().split("");
	
		String returnString = "";
		int asciValue;
		for (char c : tempString.toCharArray()) {
			/*returnString += Character.toString((char) (((c - 'a' - 1) % 26) + 'a'));*/
			if(c=='z'){
				asciValue = (int)c-25;
				
			}else{
				asciValue = (int)c+1;
				
			}
			returnString+= Character.toString((char)asciValue);
		}
		StringBuilder returnBuilder = new StringBuilder();
		for(int i=startIndex;i<=endIndex;i++){
			returnBuilder.append(returnString.charAt(i));
		}
		return returnBuilder;
	}

	static StringBuilder performRollBackwardStringmanipulation(int startIndex, int endIndex,StringBuilder toBeManipulated) {
		
		String tempString ="";
		if(endIndex<toBeManipulated.length()-1 && startIndex==endIndex ){
			tempString= toBeManipulated.substring(startIndex, endIndex);
		}else{
			tempString= toBeManipulated.substring(startIndex, endIndex+1);	
		}
		
		String[] remainingStringarray = toBeManipulated.toString().split("");
		String returnString = "";
		int asciValue;
		for (char c : tempString.toCharArray()) {
			if(c=='a'){
				asciValue = (int)c+25;
			}else{
				asciValue = (int)c-1;
			}
			returnString+= Character.toString((char)asciValue);
			
		}
		StringBuilder returnBuilder = new StringBuilder();
		for(int i=startIndex;i<=endIndex;i++){
			returnBuilder.append(returnString.charAt(i));
		}
		return returnBuilder;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] operations = { "0 0 L", "2 2 L", "0 2 R" };
		System.out.println(rollingString("abc", operations));

	}

}
