package com.cisco.preparation.javabasics;

/**
 * The diameter of a tree (sometimes called the width) is the number of nodes on
 * the longest path between two leaves in the tree. The diagram below shows two
 * trees each with diameter nine, the leaves that form the ends of a longest
 * path are shaded (note that there is more than one path in each tree of length
 * nine, but no path longer than nine nodes).
 * 
 * 
 * 
 * The diameter of a tree T is the largest of the following quantities:
 * 
 * the diameter of T’s left subtree the diameter of T’s right subtree the
 * longest path between leaves that goes through the root of T (this can be
 * computed from the heights of the subtrees of T)
 * 
 * @author MSantoshGiriGovind
 *
 */
public class Oracle_DiameterOfBinaryTree {

	public static void main(String[] args) {
		Node root = createTree();
		System.out.println(diameter(root));
	}

	private static Node createTree() {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.left.right = new Node(5);
		n.right.left = new Node(6);
		n.right.right = new Node(7);
		n.left.left.left = new Node(8);
		return n;
	}

	public static int diameter(Node n) {
		if (n == null)
			return 0;

		int lH = height(n.left);
		int rH = height(n.right);

		int lD = diameter(n.left);
		int rD = diameter(n.right);

		return Math.max(lH + rH + 1, Math.max(lD, rD));
	}

	public static int height(Node n) {
		if (n == null)
			return 0;

		return (1 + Math.max(height(n.left), height(n.right)));
	}
}
