package com.arrays.problems;
/**
 * 
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

logic: compare the asci value of char at both respective strings. Store the asci values in the integer array

important note: we can compare characters with asci values directely in a integer array 
				eg : if(a1[s.charAt(i)] == 0 && a2[t.charAt(i)] == 0)
 * 
 * */
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	
/**
 * @method: method to check is string are isomorphic
 * 
 * */
public static boolean isIsomorphic(String s, String t) {
        
		
	
	Map<Character, Character> LetterMapContainer =  new HashMap();
        if(s.length()!=t.length()){
            return false;
        }
        int lengthOfFirstString = s.length();
        for(int i=0; i< lengthOfFirstString;i++ ){    
            if(LetterMapContainer.containsKey(s.charAt(i))){
                if(LetterMapContainer.get(s.charAt(i))==(t.charAt(i))){
                    LetterMapContainer.put(s.charAt(i),t.charAt(i));
                }else{
                    return false;
                }
            }else{
            	if(!LetterMapContainer.containsValue(t.charAt(i))){
            		LetterMapContainer.put(s.charAt(i),t.charAt(i));
            	}else{
            		return false;
            	}
                
            }
        }
        
        return true;
    }


/**
 * @method: Improved solution. Lower runtime 
 * */
public static boolean isIsomorphic1s(String s, String t) {
    int[] a1 = new int[256];
    int[] a2 = new int[256];
    
    for(int i = 0; i < s.length(); i++){
        if(a1[s.charAt(i)] == 0 && a2[t.charAt(i)] == 0){
            a1[s.charAt(i)] = t.charAt(i);
            a2[t.charAt(i)] = s.charAt(i);
        }
        else if(a1[s.charAt(i)] != t.charAt(i) || a2[t.charAt(i)] != s.charAt(i)) return false;
    }
    return true;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IsomorphicStrings.isIsomorphic1s("aa", "bb"));
	}

}
