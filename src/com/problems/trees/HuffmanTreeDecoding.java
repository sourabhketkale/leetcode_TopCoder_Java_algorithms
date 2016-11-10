package com.problems.trees;

/**
 *      {ϕ,5}
     0 /     \ 1
    {ϕ,2}   {A,3}
   0/   \1
{B,1}  {C,1}  =

A - 1
B - 00
C - 01
S="1001011"
Processing the string from left to right.
S[0]='1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
We move back to the root.

S[1]='0' : we move to the left child. 
S[2]='0' : we move to the left child. We encounter a leaf node with value 'B'. We add 'B' to the decoded string.
We move back to the root.

S[3] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
We move back to the root.

S[4]='0' : we move to the left child. 
S[5]='1' : we move to the right child. We encounter a leaf node with value C'. We add 'C' to the decoded string.
We move back to the root.

 S[6] = '1' : we move to the right child of the root. We encounter a leaf node with value 'A'. We add 'A' to the decoded string.
We move back to the root.

Decoded String = "ABACA"
 * */
class HUffmanNode{
   public  int frequency; // the frequency of this tree
    public  char data;
    public  HUffmanNode left, right;
 
} 


public class HuffmanTreeDecoding {

	

	String decode(String S ,HUffmanNode root)
	    {
	        String returnOutput="";
	        HUffmanNode currHUffmanNode = root;
	         
	        if(root==null || S.length()<1){
	            System.out.println(returnOutput);
	        }
	        for(int i=0; i< S.length()-1; i++){

	            if(Character.toString(S.charAt(i))=="1"){
	                currHUffmanNode = currHUffmanNode.right;
	                
	                if(isLeaf(currHUffmanNode.right)){
	                    returnOutput= returnOutput +  Character.toString(currHUffmanNode.data);
	                        
	                    currHUffmanNode=root;
	                }else{
	                    continue;
	                }
	                
	            }else if(Character.toString(S.charAt(i))=="0"){
	                currHUffmanNode = currHUffmanNode.left;
	               
	                if(isLeaf(currHUffmanNode.left)){
	                    returnOutput= returnOutput + Character.toString(currHUffmanNode.data);
	                                
	                    currHUffmanNode=root;
	                }else{
	                    continue;
	                }
	                
	            }
	        }
	    
	    return returnOutput;
	        
	    }

	public static boolean isLeaf(HUffmanNode node){
	    
	    if(node.right!= null && node.left!=null){
	       return false;
	    }else{
	        return true;
	    }
	}
	
}
