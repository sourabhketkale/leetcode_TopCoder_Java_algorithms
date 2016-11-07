package com.algorithms.linkedlist;

public class LinkedList {
	int data;
	LinkedList next;
	
	public LinkedList()
	{
		
	}
	
	public LinkedList(int data)
	{
		this.data=data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}
	
}
