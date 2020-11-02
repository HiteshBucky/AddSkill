import java.util.*;


class DynamicArray {
	int myArray[];
	int sizeOfMyArray;
	int arrayCapacity;

	public DynamicArray() {
		myArray = new int[2];
		sizeOfMyArray = 0;
		arrayCapacity = 2;
	}

	public void addElementsToArray(int element) {
		if (sizeOfMyArray == arrayCapacity)
			increaseCapacity(2);

		myArray[sizeOfMyArray] = element;
		sizeOfMyArray++;
	}

	public void addElementAtPosition(int position, int value) {
		if (sizeOfMyArray == arrayCapacity)
			increaseCapacity(2);

		// shifting array elements
		for (int p = sizeOfMyArray - 1; p >= position; p--)
			myArray[p + 1] = myArray[p];

		// adding the element at specific position
		myArray[position] = value;
		sizeOfMyArray++;
	}

	public int getElementAtposition(int position) {
		return myArray[position];
	}

	// method for increasing capacity if all the elements in an array filled
	public void increaseCapacity(int minimumCapacity) {
		int temp[] = new int[arrayCapacity * minimumCapacity];
		for (int p = 0; p < arrayCapacity; p++) {
			temp[p] = myArray[p];
		}
		myArray = temp;
		arrayCapacity = arrayCapacity * minimumCapacity;
	}

	public int displaySize() {
		return sizeOfMyArray;
	}

	public int displayCapacity() {
		return arrayCapacity;
	}

	public void displayArrayElements() {
		System.out.println("Size of myArray =>" + displaySize() + " and Capacity :" + displayCapacity());
		System.out.println("elements in array are :" + Arrays.toString(myArray));
	}

	public int searchElement(int key) {
		for (int i = 0; i < arrayCapacity; i++)
			if (myArray[i] == key)
				return i;
		return -1;
	}

	public void deleteArrayElements(int key) {
		int index = searchElement(key);
		if (index == -1) return ;

		for (int i = index; i < arrayCapacity - 1; i++)
			myArray[i] = myArray[i + 1];
		sizeOfMyArray--;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DynamicArray array = new DynamicArray();

		int choice;
		do {
			System.out.println("******************** Dynamic Array *************************");
			System.out.println("\n1. Add Element\n2. ADD AT INDEX\n3. SEARCH AN ELEMENT\n4. DELETE AN ARRAY\n5. DISPLAY\n0. EXIT");
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.print("ENTER AN ELEMENT TO ADD INTO ARRAY : ");
				array.addElementsToArray(sc.nextInt());
			} else if (choice == 2) {
				System.out.print("ENTER AN ELEMENT TO ADD INTO ARRAY : ");
				int value = sc.nextInt();
				System.out.print("ENTER THE INDEX : ");
				int index = sc.nextInt();
				array.addElementAtPosition(index, value);
			} else if (choice == 3) {
				System.out.print("ENTER	AN ELEMENT TO SEARCH : ");
				int index = array.searchElement(sc.nextInt());
				if (index == -1)
					System.out.println("*** NOT FOUND ***");
				else
					System.out.println("FOUND AT : " + index);
			} else if (choice == 4) {
				System.out.print("ENTER AN TO DELETE : ");
				array.deleteArrayElements(sc.nextInt());
			} else if (choice == 5) {
				array.displayArrayElements();
			} else break;

		} while (choice != 0);

	}
}