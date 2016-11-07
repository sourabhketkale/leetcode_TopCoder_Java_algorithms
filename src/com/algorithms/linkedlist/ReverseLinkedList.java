package com.algorithms.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		int [] linkedListArray={3,5,6,1,7};
		LinkedList head=new LinkedList();
		head=createLinkedList(linkedListArray);
		printLinkedList(head);
		System.out.println("\nReversed Linked List:");
		LinkedList rhead=reverseLinkedList(head);
		printLinkedList(rhead);		
	}
	
	private static LinkedList createLinkedList(int[] linkedListArray) {
		LinkedList head=new LinkedList(linkedListArray[0]);  
		head.next=null;
		LinkedList current;
		current=head;
		LinkedList temp;
		for(int i=1;i<linkedListArray.length;i++)
		{
			temp=new LinkedList();
			current.next=temp;
			temp.data=linkedListArray[i];
			current=temp;
		}
		current.next=null;
		return head;
	}
	
	private static void printLinkedList(LinkedList head) {
		LinkedList current=head;
		System.out.println("Printing Linked List:");
		while(current!=null)
		{
			System.out.print(current.data);
			if(current.next!=null)
				System.out.print("->");
			current=current.next;
		}
	}
	
	private static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList before=head;
		LinkedList current=head.next;
		LinkedList after=current.next;
		//before.next=null;
		//current=current.next;
		//after=current.next;
		while(after!=null)
		{
			/*current.next=before;
			before=current;
			current=after;
			//if(after!=null)
				after=after.next;*/
			
		}
		current.next=before;	
		head=current;
		return head;
	}	
}
