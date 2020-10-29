import java.util.*;
import java.io.*;


public class Insertion_Sort_mylist_Linkedmylist {
	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head = null;
	public Node tail = null;

	public void addNode(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void display() {
		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly linked list: ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	//	1 3 5 0 4

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
				}
			}
		}
	}

	public void insertionSort() {
		if (head = null || head.next == null) return;

		Node i = head, next = null;
		Node newHead = new Node(0);

		while (i != null) {
			next = i.next;

			Node j = newHead;
			while (j.next != null && j.next.data < i.data)
				j = j.next;

			i.next = j.next;
			j.next = i;
			i = nextNode;
		}

		head = newHead.next;
	}

	public static void main(String[] args) {

		Insertion_Sort_mylist_Linkedmylist sList = new Insertion_Sort_mylist_Linkedmylist();
		sList.addNode(1);
		sList.addNode(5);
		sList.addNode(3);
		sList.addNode(4);
		sList.addNode(0);

		sList.display();
	}
}