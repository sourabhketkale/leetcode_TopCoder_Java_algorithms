package com.problems.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AmazonTest {

	static List<String> substringWithOneCharacterRepeated(List<String> subtringsOfLengthKList){
			
			
			ArrayList<String> outputList= new ArrayList<>();
			for(int i = 0; i< subtringsOfLengthKList.size(); i++ ){
					
				String [] strArray  = subtringsOfLengthKList.get(i).split("");
				
				int count=0;
				ArrayList<String> list= new ArrayList<>();
				for(int i1 = 0; i1 < strArray.length; i1++){
					
					if(list.contains(strArray[i1])){
						
						
							list.add(strArray[i1]);
							count++;
						
					}else{
						list.add(strArray[i1]);
						
					}
					
				}
				
				if(count==1){
					
				StringBuilder sb = new StringBuilder();
				for(String tempString : strArray){
						sb.append(tempString);
					}
					//System.out.println(Arrays.toString(strArray));
					String str1 = Arrays.toString(strArray);
					String str2= Arrays.asList(strArray).toString();
					str1 = str1.substring(1, str1.length()-1).replaceAll(",", "");
					 str2 = str2.substring(1, str2.length()-1).replaceAll(",", "");
					//System.out.println(str2.replaceAll("\\s+", ""));
					 System.out.println(str1.replaceAll("\\s+", ""));
					
					outputList.add(sb.toString());
				}
				
			} 
			return outputList;
			
		
	}
	
	public static List<String> findSubstringsWithKDistinctCharacters(String s, int k) {

			
		List<String> subtringsOfLengthK = new ArrayList<String>();
		for (int i = 0; i <= s.length() - k; i++) {
		    String substr = s.substring(i, i + k);
		    if (substr.matches("[a-zA-Z]+")) { 
		    	
		    	subtringsOfLengthK.add(substr);
		    }
		}
		
		return substringWithOneCharacterRepeated(subtringsOfLengthK);
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String k = "awagak";
		int n = 4;
		AmazonTest i = new AmazonTest();
	
		System.out.println(i.findSubstringsWithKDistinctCharacters(k,4));
		
		
	}

}
