package com.problems.miscellaneous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordinDictionary {
	
	 public  static String longestWord(String[] words) {
	        Arrays.sort(words);
	        Set<String> built = new HashSet<String>();
	        String res = "";
	        for (String w : words) {
	            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
	                
	            	if(w.length() > res.length()){
	            		res = w;
	            	}

	            	//res =  ? w : res;
	                built.add(w);
	            }
	        }
	        return res;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[7];
		//arr = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		
		arr[0] = "a";
		arr[1]="banana";
		arr[2] = "app";
		arr[3]="appl";
		arr[4] = "ap";
		arr[5] = "apply";
		arr[6]= "apple";
		System.out.println(LongestWordinDictionary.longestWord(arr));
		
	}

}
