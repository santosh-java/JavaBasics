package com.cisco.preparation.javabasics;

public class Oracle_MergeTwoSortedLinkedLists {
	public static void main(String[] args) {
		LinkedNode l1 = createLinkedList(5, 1, 3);
		printList(l1);
		LinkedNode l2 = createLinkedList(10, 2, 2);
		printList(l2);
		LinkedNode m = merge(l1, l2);
		printList(m);
	}

	private static void printList(LinkedNode m) {
		System.out.println();
		while (m != null) {
			System.out.print(m.data + "-->");
			m = m.next;
		}
	}

	private static LinkedNode createLinkedList(int size, int start, int increment) {
		LinkedNode l = new LinkedNode(start);
		LinkedNode head = l;
		for (int i = 0; i < size; i++) {
			l.data = start + increment * i;
			if (i < size - 1) {
				l.next = new LinkedNode(0);
				l = l.next;
			} else
				l.next = null;
		}

		return head;
	}

	private static LinkedNode merge(LinkedNode l1, LinkedNode l2) {
		LinkedNode mergedLst = new LinkedNode(0);
		LinkedNode l3 = mergedLst;
		while (l1 != null && l2 != null) {
			boolean hasNext = false;
			if (l1.data <= l2.data) {
				l3.data = l1.data;
				l1 = l1.next;
				if (l1 != null)
					hasNext = true;
			} else {
				l3.data = l2.data;
				l2 = l2.next;
				if (l2 != null)
					hasNext = true;
			}

			if (hasNext) {
				l3.next = new LinkedNode(0);
				l3 = l3.next;
			} else
				l3.next = null;
		}

		while (l1 != null) {
			l3.next = new LinkedNode(l1.data);
			l3 = l3.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			l3.next = new LinkedNode(l2.data);
			l3 = l3.next;
			l2 = l2.next;
		}

		l3.next = null;
		return mergedLst;
	}
}
