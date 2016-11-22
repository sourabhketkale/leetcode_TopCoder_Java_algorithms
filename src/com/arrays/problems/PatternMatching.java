package com.arrays.problems;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching {
	 public static boolean wordPattern(String pattern, String str) {
	        
	        Map patternToStrMap = new HashMap();
	      
	        String[] patternArray = new String[pattern.length()];
	        String[] strArray = new String[pattern.length()];
	        
	        if(patternArray.length != strArray.length){
	            return false;
	        }
	        
	        
	        strArray = str.split(" ");
	        int patternLength = pattern.length();
	        
	       for(Integer i=0; i<patternLength;++i){
	           if(patternToStrMap.put(pattern.charAt(i),i) != patternToStrMap.put(strArray[i],i))
	               return false;
	       }
	       return true;
	    }
	
	 
		public static boolean wordPattern1(String pattern, String str) {
		    String[] words = str.split(" ");
		    if (words.length != pattern.length())
		        return false;
		    Map index = new HashMap();
		    for (Integer i=0; i<words.length; ++i)
		        if (index.put(pattern.charAt(i), i).equals((index.put(words[i], i))))
		            return false;
		    return true;
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(PatternMatching.wordPattern("abba", "a cat cat a"));

	}

}
