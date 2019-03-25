package com.cisco.preparation.javabasics;

public class Oracle_RemoveLoopInLinkedList {
	public static void main(String[] args) {
		int[] nodeData = { 1, 2, 3, 4, 5, 6, 7, 8};
		ListNode head = createLinkedList(nodeData);
		printList(detectAndRemoveLoop(head));
	}

	private static void printList(ListNode node) {
		System.out.print("[");
		while (node != null) {
			System.out.print(node.data + ",");
			node = node.next;
		}
		System.out.println("]");
	}

	private static ListNode createLinkedList(int[] nodeData) {
		ListNode head = new ListNode();
		head.data = nodeData[0];
		ListNode temp = head;
		for (int i = 1; i < nodeData.length; i++) {
			ListNode n = new ListNode();
			n.data = nodeData[i];
			temp.next = n;
			temp = n;
		}
		temp.next = temp;

		return head;
	}

	public static ListNode detectAndRemoveLoop(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return removeLoop(slow, fast, head);
			}
		}

		return head;
	}

	private static ListNode removeLoop(ListNode slow, ListNode fast, ListNode head) {
		if (fast == head) {
			while (slow.next != fast) {
				slow = slow.next;
			}
			slow.next = null;
		} else {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
		return head;
	}
}

class ListNode {
	int data;
	ListNode next;
}
