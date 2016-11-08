package com.algorithms.StacksAndQueues;


class Node {
    int data;
    Node left;
    Node right;
 }

public class CheckIfBinaryTreeIsBST {

	
	  boolean checkBST(Node root) {
	      
	        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	    }

	  boolean checkBST(Node root, int min, int max){
	          
	    if(root==null){
	        return true;
	    }
	    if(root.data <= min || root.data > max){
	          return false;
	    }
	    
	    return checkBST(root.left, min, root.data) && checkBST(root.right, root.data,max);
	      
	  }
}
