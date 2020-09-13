package com.cisco.preparation.javabasics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Write a function to connect all the adjacent nodes at the same level in a
 * binary tree. Structure of the given Binary Tree node is like following.
 * 
 * 
 * struct Node{
 * 
 * int data;
 * 
 * Node* left;
 * 
 * Node* right;
 * 
 * Node* nextRight;
 * 
 * }
 * 
 * 
 * Initially, all the nextRight pointers point to garbage values. Your function
 * should set these pointers to point next right for each node.
 * 
 * Example:
 * 
 * Input Tree 10 / \ 3 5 / \ \ 4 1 2
 * 
 * 
 * Output Tree 10--->NULL / \ 3-->5-->NULL / \ \ 4-->1-->2-->NULL
 * 
 * 
 * Input:
 * 
 * The task is to complete the method which takes one argument, root of Binary
 * Tree. There are multiple test cases. For each test case, this method will be
 * called individually.
 * 
 * Output: The function should update nextRight pointers of all nodes.
 * 
 * Constraints: 1 <=T<= 30 1 <=Number of nodes<= 100 1 <=Data of a node<= 1000
 * 
 * Example: Input: 2 2 3 1 L 3 2 R 4 10 20 L 10 30 R 20 40 L 20 60 R
 * 
 * Output: 3 1 2 1 3 2 10 20 30 40 60 40 20 60 10 30
 * 
 * There are two test casess. First case represents a tree with 3 nodes and 2
 * edges where root is 3, left child of 3 is 1 and right child of 3 is 2. Second
 * test case represents a tree with 4 edges and 5 nodes.
 * 
 * The output contains level order and inorder traversals of the modified tree.
 * Level order traversal is done using nextRight pointers.
 * 
 * 
 * 
 * Note:The Input/Ouput format and Example given are used for system's internal
 * purpose, and should be used by a user for Expected Output only. As it is a
 * function problem, hence a user should not read any input from stdin/console.
 * The task is to complete the function specified, and not to write the full
 * code.
 * 
 * @author MSantoshGiriGovind
 *
 */
public class Oracle_LinkNodesInSameLevelBT {
	public static void main(String[] args) {
		SLNode root = createTree();
		levelOrderTraverse(root);
	}

	private static void levelOrderTraverse(SLNode root) {
		Map<Integer, List<SLNode>> levelNodes = new TreeMap<>();
		Queue<SLNode> q = new LinkedList<>();
		q.add(root);
		root.nextRight = null;
		int level = 0;
		identifyLevelNodes(root, levelNodes, level);
		for (Integer key : levelNodes.keySet()) {
			List<SLNode> list = levelNodes.get(key);
			// All other levels
			for (int i = 0; i < list.size(); i++) {
				if (i == 0)
					list.get(i).nextRight = null;
				else
					list.get(i).nextRight = list.get(i - 1);
			}
		}

		for (Integer key : levelNodes.keySet()) {
			List<SLNode> list = levelNodes.get(key);
			System.out.println("Nodes in level " + key);
			for (int i = list.size() - 1; i >= 0; i--) {
				System.out.print(list.get(i).data + "-->" + list.get(i).nextRight + " ");
			}
			System.out.println();
		}

		System.out.println("Level order traversal");
		while (!q.isEmpty()) {
			SLNode n = q.poll();
			System.out.print(n.data + " ");
			if (n.left != null) {
				q.offer(n.left);
			}
			if (n.right != null) {
				q.offer(n.right);
			}
		}
	}

	private static void identifyLevelNodes(SLNode node, Map<Integer, List<SLNode>> levelNodes, int level) {
		// Base case
		if (node == null)
			return;
		List<SLNode> list = levelNodes.get(level);
		if (list == null) {
			list = new ArrayList<>();
			levelNodes.put(level, list);
		}
		list.add(node);

		identifyLevelNodes(node.right, levelNodes, level + 1);
		identifyLevelNodes(node.left, levelNodes, level + 1);
	}

	private static SLNode createTree() {
		SLNode n = new SLNode(1);
		n.left = new SLNode(2);
		n.right = new SLNode(3);
		n.left.left = new SLNode(4);
		n.left.right = new SLNode(5);
		n.right.right = new SLNode(6);
		return n;
	}
}

class SLNode {
	int data;
	SLNode left, right, nextRight;

	SLNode(int data) {
		this.data = data;
		left = right = nextRight = null;

	}

	public String toString() {
		return data + " ";
	}
}
