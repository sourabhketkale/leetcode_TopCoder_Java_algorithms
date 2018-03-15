package com.problems.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class Bstdistance {

	// 1:insert into binary tree with the given argument array of elements
	// 2: find the distance from 2 specific nodes

	Node root;

	Node createTree(int[] inputElements) {

		for (int i = 0; i < inputElements.length; i++) {

			root = insert(inputElements[i]);
		}

		return root;

	}

	Node insert(int key) {
		root = insertRec(root, key);
		return root;

	}

	Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		return root;
	}

	void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	static int depth(Node root, Node x) {
		if (root == null)
			return -1;
		if (x.key == root.key)
			return 0;

		else if (x.key < root.key) {
			return depth(root.left, x) + 1;

		} else
			return depth(root.right, x) + 1;
	}

	int bstDistance(int[] inputElements, int n, int left1, int right1) {

		int distance;

		Node left = new Node(left1);
		Node right = new Node(right1);
		Bstdistance bstd = new Bstdistance();
		Node root = bstd.createTree(inputElements);

		if(!(Arrays.asList(inputElements).contains(left1)  && Arrays.asList(inputElements).contains(right1) )){
				return -1;
		}

		if (left == right)
			return 0;
		else if (left == root)
			return depth(root, right);
		else if (right == root)
			return depth(root, left);

		Node greater = left.key > right.key ? left : right;
		Node smaller = left.key < right.key ? left : right;

		if (root.key > smaller.key && root.key < greater.key) {
			distance = depth(root, left) + depth(root, right);
			return distance;

		} else {
			return depth(root, smaller) - depth(root, greater);
		}

	}

	public static void main(String[] args) {
		
		Bstdistance bstd = new Bstdistance();
		int[] treeElements = new int[10];
		treeElements[0] = 50;
		treeElements[1] = 56;
		treeElements[2] = 12;
		treeElements[3] = 19;
		treeElements[4] = 99;
		treeElements[5] = 55;
		treeElements[6] = 37;
		treeElements[7] = 73;
		// bstd.createTree(treeElements);

		Node root = bstd.createTree(treeElements);
		
		System.out.println(bstd.bstDistance(treeElements, 8, 12, 33));

	}

}
