import java.util.*;


// class DynamicArray {
// 	int myArray[];
// 	int sizeOfMyArray;
// 	int arrayCapacity;

// 	public DynamicArray() {
// 		myArray = new int[2];
// 		sizeOfMyArray = 0;
// 		arrayCapacity = 2;
// 	}

// 	public void addElementsToArray(int element) {
// 		if (sizeOfMyArray == arrayCapacity)
// 			increaseCapacity(2);

// 		myArray[sizeOfMyArray] = element;
// 		sizeOfMyArray++;
// 	}

// 	public void addElementAtPosition(int position, int value) {
// 		if (sizeOfMyArray == arrayCapacity)
// 			increaseCapacity(2);

// 		// shifting array elements
// 		for (int p = sizeOfMyArray - 1; p >= position; p--)
// 			myArray[p + 1] = myArray[p];

// 		// adding the element at specific position
// 		myArray[position] = value;
// 		sizeOfMyArray++;
// 	}

// 	public int getElementAtposition(int position) {
// 		return myArray[position];
// 	}

// 	// method for increasing capacity if all the elements in an array filled
// 	public void increaseCapacity(int minimumCapacity) {
// 		int temp[] = new int[arrayCapacity * minimumCapacity];
// 		for (int p = 0; p < arrayCapacity; p++) {
// 			temp[p] = myArray[p];
// 		}
// 		myArray = temp;
// 		arrayCapacity = arrayCapacity * minimumCapacity;
// 	}

// 	public int displaySize() {
// 		return sizeOfMyArray;
// 	}

// 	public int displayCapacity() {
// 		return arrayCapacity;
// 	}

// 	public void displayArrayElements() {
// 		System.out.println("Size of myArray =>" + displaySize() + " and Capacity :" + displayCapacity());
// 		System.out.println("elements in array are :" + Arrays.toString(myArray));
// 	}

// 	public int searchElement(int key) {
// 		for (int i = 0; i < arrayCapacity; i++)
// 			if (myArray[i] == key)
// 				return i;
// 		return -1;
// 	}

// 	public void deleteArrayElements(int key) {
// 		int index = searchElement(key);
// 		if (index == -1) return ;

// 		for (int i = index; i < arrayCapacity - 1; i++)
// 			myArray[i] = myArray[i + 1];
// 		sizeOfMyArray--;
// 	}

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		DynamicArray array = new DynamicArray();

// 		int choice;
// 		do {
// 			System.out.println("******************** Dynamic Array *************************");
// 			System.out.println("\n1. Add Element\n2. ADD AT INDEX\n3. SEARCH AN ELEMENT\n4. DELETE AN ARRAY\n5. DISPLAY\n0. EXIT");
// 			choice = sc.nextInt();

// 			if (choice == 1) {
// 				System.out.print("ENTER AN ELEMENT TO ADD INTO ARRAY : ");
// 				array.addElementsToArray(sc.nextInt());
// 			} else if (choice == 2) {
// 				System.out.print("ENTER AN ELEMENT TO ADD INTO ARRAY : ");
// 				int value = sc.nextInt();
// 				System.out.print("ENTER THE INDEX : ");
// 				int index = sc.nextInt();
// 				array.addElementAtPosition(index, value);
// 			} else if (choice == 3) {
// 				System.out.print("ENTER	AN ELEMENT TO SEARCH : ");
// 				int index = array.searchElement(sc.nextInt());
// 				if (index == -1)
// 					System.out.println("*** NOT FOUND ***");
// 				else
// 					System.out.println("FOUND AT : " + index);
// 			} else if (choice == 4) {
// 				System.out.print("ENTER AN TO DELETE : ");
// 				array.deleteArrayElements(sc.nextInt());
// 			} else if (choice == 5) {
// 				array.displayArrayElements();
// 			} else break;

// 		} while (choice != 0);

// 	}
// }



// ******************************************************************** LInked LIst ******************************************************************





import java.io.*;

class LinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) { data = d; next = null; }
	}

	// **************INSERTION**************
	public static LinkedList insert(LinkedList list, int data) {
		Node new_node = new Node(data);


		if (list.head == null) list.head = new_node;

		else {

			Node last = list.head;
			while (last.next != null)
				last = last.next;

			last.next = new_node;
		}
		return list;
	}

	public static void insertNth(LinkedList list, int data, int position) {
		Node new_node = new Node(data);

		if (list.head == null) {
			if (position != 0) return;
			else list.head = new_node;
		}

		if (head != null && position == 0) {
			new_node.next = list.head;
			list.head = new_node;
			return;
		}

		Node current = list.head;
		Node previous = null;
		int i = 0;

		while (i < position) {
			previous = current;
			current = current.next;

			if (current == null) break;

			i++;
		}

		new_node.next = current;
		previous.next = new_node;

	}
	public static boolean searchElement(int x) {
		Node current = head;
		while (current != null) {
			if (current.data == x)
				return true;
			current = current.next;
		}
		return false;
	}

	public static int GetNth(int index) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (count == index)
				return current.data;
			count++;
			current = current.next;
		}

		return -1;
	}


	// ************** DELETION AT A POSITION**************
	public static LinkedList deleteAtPosition(LinkedList list, int index) {
		Node currNode = list.head, prev = null;

		if (index == 0 && currNode != null) {
			list.head = currNode.next; // Changed head
			System.out.println(index + " position element deleted");
			return list;
		}
		int counter = 0;
		while (currNode != null) {
			if (counter == index) {
				prev.next = currNode.next;
				System.out.println(index + " position element deleted");
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}

		if (currNode == null) System.out.println(index + " position element not found");
		return list;
	}

	public static void printList(LinkedList list) {
		Node currNode = list.head;

		System.out.print("\nLinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println("\n");
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();

		int choice;
		do {
			System.out.println("******************** Linked List *************************");
			System.out.println("\n1. Add Element\n2. ADD AT INDEX\n3. SEARCH AN ELEMENT\n4. DELETE AN ARRAY\n5. GET NTH ELEMENT\n6. PRINT\n0. EXIT");
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.print("ENTER AN ELEMENT TO ADD INTO LINKED LIST : ");
				list = insert(list, sc.nextInt());
			} else if (choice == 2) {
				System.out.print("ENTER AN ELEMENT TO ADD INTO LINKED LIST : ");
				int value = sc.nextInt();
				System.out.print("ENTER THE INDEX : ");
				int index = sc.nextInt();
				insertNth(list, value, index);
			} else if (choice == 3) {
				System.out.print("ENTER	AN ELEMENT TO SEARCH : ");
				if (searchElement(sc.nextInt())) System.out.println("FOUND");
				else System.out.println("NOT FOUND");
			} else if (choice == 4) {
				System.out.print("ENTER AN INDEX TO DELETE : ");
				deleteAtPosition(list, sc.nextInt());
			} else if (choice == 5) {
				System.out.print("ENTER INDEX : ");
				System.out.println(GetNth(sc.nextInt()));
			} else if (choice == 6) {
				printList(list);
			} else break;

		} while (choice != 0);

	}
}
