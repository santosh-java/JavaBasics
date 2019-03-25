package com.cisco.preparation.javabasics;
// non-recursive java program for inorder traversal
 
/* importing the necessary class */
import java.util.Stack;

/* Class to print the inorder traversal */
public class BinaryTree {

    Node root;

    void inorder() {
        if (root == null) {
            return;
        }

        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        // traverse the tree
        while (stack.size() > 0) {

            // visit the top node
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    void preOrder() {
        if(root == null)
        {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty()) {
            Node n = nodeStack.pop();
            System.out.print(n.data + " ");

            if(n.right != null)
                nodeStack.push(n.right);
            if(n.left != null)
                nodeStack.push(n.left);

        }
    }

    void postOrder() {
        if(root == null)
            return;

        Stack<Node> firstSt = new Stack<>();
        Stack<Node> secondSt = new Stack<>();

        firstSt.push(root);

        while(!firstSt.isEmpty()) {
            Node n = firstSt.pop();
            secondSt.push(n);
            if(n.left != null) {
                firstSt.push(n.left);
            }
            if(n.right != null) {
                firstSt.push(n.right);
            }

        }

        while(!secondSt.isEmpty()) {
            Node n1 = secondSt.pop();
            System.out.print(n1.data + " ");
        }
    }

    public static void main(String args[]) {
         
        /* creating a binary tree and entering 
         the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("Inorder is : ");
        tree.inorder();

        System.out.println("\nPreorder is : ");
        tree.preOrder();


        System.out.println("\nPostorder is : ");
        tree.postOrder();
    }
}