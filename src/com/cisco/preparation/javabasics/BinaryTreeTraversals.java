package com.cisco.preparation.javabasics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by MSantoshGiriGovind on 12/15/2016.
 */
public class BinaryTreeTraversals {
	class Node {
		Node(int data) {
			this.data = data;
		}

		int data;
		Node left;
		Node right;
	}

	public static void main(String args[]) {
		BinaryTreeTraversals btt = new BinaryTreeTraversals();
		Node root = btt.createBinaryTree();

		System.out.println("\nIterative InOrder traversal of tree is :  ");
		btt.inorder(root);

		System.out.println("\nRecursive InOrder traversal of tree is :  ");
		btt.inorder_recur(root);

		System.out.println("\nIterative PreOrder traversal of tree is :  ");
		btt.preorder(root);

		System.out.println("\nRecursive PreOrder traversal of tree is :  ");
		btt.preorder_recur(root);
		
		System.out.println("\nIterative PosOrder traversal of tree is :  ");
		btt.postorder(root);

		System.out.println("\nRecursive PosOrder traversal of tree is :  ");
		btt.postorder_recur(root);

		System.out.println("\nIterative LevelOrder traversal of tree is :  ");
		btt.levelorder(root);
	}

	private void postorder_recur(Node node) {
		if(node == null)
			return;
		postorder_recur(node.left);
		postorder_recur(node.right);
		System.out.print(node.data + " ");
	}

	private void preorder_recur(Node node) {
		if(node == null)
			return;
		System.out.print(node.data + " ");
		preorder_recur(node.left);
		preorder_recur(node.right);
	}

	private void inorder_recur(Node node) {
		if(node == null)
			return;
		inorder_recur(node.left);
		System.out.print(node.data+ " ");
		inorder_recur(node.right);
	}

	private void levelorder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
	}

	private void postorder(Node root) {
		Stack<Node> one = new Stack<>();
		Stack<Node> two = new Stack<>();

		one.push(root);

		while (!one.isEmpty()) {
			Node n = one.pop();

			two.push(n);

			if (n.left != null)
				one.push(n.left);
			if (n.right != null)
				one.push(n.right);
		}

		while (!two.isEmpty()) {
			Node n = two.pop();
			System.out.print(n.data + " ");
		}
	}

	private void inorder(Node root) {
		Stack<Node> s = new Stack<>();

		Node n = root;

		while (n != null) {
			s.push(n);
			n = n.left;
		}

		while (!s.isEmpty()) {
			Node temp = s.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					s.push(temp);
					temp = temp.left;
				}
			}
		}
	}

	private void preorder(Node root) {
		Stack<Node> s = new Stack<>();
		s.push(root);

		while (!s.isEmpty()) {
			Node n = s.pop();
			System.out.print(n.data + " ");
			if (n.right != null)
				s.push(n.right);
			if (n.left != null)
				s.push(n.left);
		}
	}

	private Node createBinaryTree() {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.right.left = new Node(6);
		n.right.right = new Node(7);
		return n;
	}

}
