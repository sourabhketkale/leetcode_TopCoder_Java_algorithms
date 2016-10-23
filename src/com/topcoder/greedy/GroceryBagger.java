package com.topcoder.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Problem statement: 	
You have just begun working as a grocery bagger at the local TopGrocer food store. Your job is to place all of a 
customer's items into bags, so they can be carried from the store. Your manager has instructed you to use as few bags 
as possible, to minimize the store's overall cost. However, for the customer's convenience, you are instructed that only 
items of the same type can be placed in the same bag. For instance, a produce item can be bagged with any other produce items,
but not with dairy items. You are given a String[] itemType indicating the type of each item that needs to be bagged.
You are also given an int strength indicating the maximum number of items that can be placed in each bag. 
You are to return an int indicating the minimum number of bags required to package the customer's items.

 
Definition
    	
Class:	GroceryBagger
Method:	minimumBags
Parameters:	int, String[]
Returns:	int
Method signature:	int minimumBags(int strength, String[] itemType)
(be sure your method is public)
    
 
Constraints
-	strength will be between 1 and 50, inclusive.
-	itemType will contain between 0 and 50 elements, inclusive.
-	Each element of itemType will contain between 1 and 50 characters, inclusive.
-	Each element of itemType will contain only the characters 'A'-'Z'.

Examples
0)	
    	
2
{"DAIRY",
 "DAIRY",
 "PRODUCE",
 "PRODUCE",
 "PRODUCE",
 "MEAT"}
Returns: 4
Here, you have six items. You could put two items in each bag, but you would have to mix item types. The single meat item must get its own bag. The two dairy items fit in one bag. The three produce items will require two bags.
1)	

time complexity: O(1)
 * 
 * */


public class GroceryBagger {

	int minimumBags(int stregth, String[] itemType){
		
		//take a unique set by putting  in a hashset
		Map<String, Integer> UniqueItemsMap = new HashMap<String, Integer>();
		
		if(itemType.length==0){
			return 0;
		}
		for(String iterator : itemType){
			if(UniqueItemsMap.containsKey(iterator)){
				UniqueItemsMap.put(iterator, UniqueItemsMap.get(iterator)+1) ;
			}else{
				
				UniqueItemsMap.put(iterator,1);
			}
		}
		
		int countBags=UniqueItemsMap.size();
		for(Map.Entry<String, Integer> entry : UniqueItemsMap.entrySet()){
			
			if(entry.getValue()>stregth ){
				if(entry.getValue()/stregth!=0){
					countBags = countBags-1 + entry.getValue()/stregth + 1;		
				}
			}
		}
		return countBags;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] itemType ={"DAIRY",
				 "DAIRY",
				 "PRODUCE",
				 "PRODUCE",
				 "PRODUCE",
				 "MEAT"};
		
		GroceryBagger bagger= new GroceryBagger();
		System.out.println(bagger.minimumBags(2, itemType));
		
		

	}

}
