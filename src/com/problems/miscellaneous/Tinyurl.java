package com.problems.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class Tinyurl {


	    Map<Integer, String> map = new HashMap<>();
	    public String encode(String longUrl) {
	        map.put(longUrl.hashCode(),longUrl);
	        System.out.println(longUrl.hashCode());
	        return "http://tinyurl.com/"+longUrl.hashCode();
	    }
	    public String decode(String shortUrl) {
	    	System.out.println(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tinyurl ty = new Tinyurl();
		String shortUrl = ty.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/");
		System.out.println(shortUrl);
		String longUrl = ty.decode(shortUrl);
		System.out.println(longUrl);
		

	}

}
