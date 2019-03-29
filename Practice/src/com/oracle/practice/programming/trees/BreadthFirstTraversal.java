package com.oracle.practice.programming.trees;

import com.oracle.practice.programming.queues.Queue;
import com.oracle.practice.programming.queues.QueueOverflowException;
import com.oracle.practice.programming.queues.QueueUnderflowException;

public class BreadthFirstTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void breadthFirstTraversal(Node root) throws QueueOverflowException, QueueUnderflowException {

		if (root == null) {
			return;
		}

		Queue<Node> processingQueue = new Queue<Node>(Node.class);

		processingQueue.enqueue(root);

		while (!processingQueue.isEmpty()) {
			Node n = processingQueue.dequeue();
			System.out.print(n.getData() + "->");
			if (n.getLeftChild() != null) {
				processingQueue.enqueue(n.getLeftChild());
			}

			if (n.getRightChild() != null) {
				processingQueue.enqueue(n.getRightChild());
			}
		}
	}

}
