package com.problems.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Method: Iterative method to calculate binary tree using Queue handling all corner cases.
 * @input:  Node root
 * @output: int height. 
 * Logic: -Use level order traversal with queues
 * 		  -Offer  null after every level into the queue
 * 
 *   This solution can be extended for problems like 
 *   1:Find full nodes 
 *   2: Half nodes in a tree
 *   Complexity: O(n)
 * */

class Node{
	
	int data;
	Node left;
	Node right;
}

public class HeightOfAtree {

	static int getHeight(Node root) {
   	
     
     if(root==null){
         return 0;
     }
     if(root.left==null && root.right==null){
         return 0;
     }
    
     Queue<Node> BTqueue = new LinkedList<Node>();
     BTqueue.offer(root);
     BTqueue.offer(null);
     int height=1;
     while(!BTqueue.isEmpty()){
         Node temp = BTqueue.poll();
        if(temp!=null){
            if(temp.left==null && temp.right==null){
                return height;
            }  
            if(temp.left!=null){
                  BTqueue.offer(temp.left);                
             }
             if(temp.right!=null){
                  BTqueue.offer(temp.right);                
             }
        }else{
            if(!BTqueue.isEmpty()){
                 height++;
                 BTqueue.offer(null);   
            }
             
        }
         
     }
     
     return height-1;
 }
	
	public static Node insert(Node root,int data){
        if(root==null){
            return new Node();
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            int height=getHeight(root);
            System.out.println(height);
        }	
}
	


