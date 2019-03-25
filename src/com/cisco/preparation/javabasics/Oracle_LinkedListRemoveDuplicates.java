package com.cisco.preparation.javabasics;

/**
 * Complete the removeDuplicates() function which takes a list sorted in
 * non-decreasing order and deletes any duplicate nodes from the list. The list
 * should only be traversed once.
 * 
 * For example if the linked list is 11->11->11->21->43->43->60 then
 * removeDuplicates() should convert the list to 11->21->43->60.
 * 
 * Input: You have to complete the method which takes 1 argument: the head of
 * the linked list .You should not read any input from stdin/console. There are
 * multiple test cases. For each test case this method will be called
 * individually.
 * 
 * Output: Your function should return a pointer to a linked list with no
 * duplicate element.
 * 
 * Constraints: 1<=T<=100 1<=size of linked lists<=50
 * 
 * Note: If you use "Test" or "Expected Output Button" use below example format.
 * 
 * Example: Input 2 4 2 2 4 5 5 2 2 2 2 2
 * 
 * Output 2 4 5 2
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
public class Oracle_LinkedListRemoveDuplicates {
	public static void main(String[] args) {
		LinkedNode head = createList(new int[] { 1, 1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6 });
		LinkedNode noDuplHead = removeDuplicates(head);
		printList(noDuplHead);
	}

	private static void printList(LinkedNode noDuplHead) {
		while(noDuplHead != null){
			System.out.print(noDuplHead.data + " ,");
			noDuplHead = noDuplHead.next;
		}
	}

	private static LinkedNode removeDuplicates(LinkedNode head) {
		LinkedNode temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			while (temp.next != null && temp.data == temp.next.data) {
				count++;
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		System.out.println("total iterations : " + count);
		return head;
	}

	private static LinkedNode createList(int[] input) {
		LinkedNode head = new LinkedNode(input[0]);
		LinkedNode temp = head;
		for (int i = 1; i < input.length; i++) {
			LinkedNode n = new LinkedNode(input[i]);
			temp.next = n;
			temp = n;
		}
		return head;
	}
}
