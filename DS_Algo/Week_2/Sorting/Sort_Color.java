/*
	Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

	Follow up:

	Could you solve this problem without using the library's sort function?
	Could you come up with a one-pass algorithm using only O(1) constant space?


	Example 1:

	Input: nums = [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
	Example 2:

	Input: nums = [2,0,1]
	Output: [0,1,2]
	Example 3:

	Input: nums = [0]
	Output: [0]
	Example 4:

	Input: nums = [1]
	Output: [1]
*/


import java.util.*;

class Sort_Color {

	/*Not an inplace solution*/
	static void countingSort(int arr[]) {
		int countArray[] = new int[3];

		//Countarray storecount of each element
		for (int i = 0; i < arr.length; i++)
			countArray[arr[i]]++;

		//Store index of every element where it will go insorted array
		for (int i = 1; i < countArray.length; i++)
			countArray[i] += countArray[i - 1];

		int sortedArray[] = new int[arr.length];
		for (int i = arr.length - 1; i > -1; i--)
			sortedArray[--countArray[arr[i]]] = arr[i];

		arr = sortedArray;
	}
	/*Inplace solution*/
	public void sortColors(int[] arr) {
		int count_0 = 0, count_1 = 0, count_2 = 0;
		for (int num : arr) {
			if (num == 0) count_0++;
			if (num == 1) count_1++;
			if (num == 2) count_2++;
		}

		int i = 0;
		while (count_0 != 0) {
			arr[i++] = 0;
			count_0--;
		}
		while (count_1 != 0) {
			arr[i++] = 1;
			count_1--;
		}
		while (count_2 != 0) {
			arr[i++] = 2;
			count_2--;
		}
	}

	public static void main(String[] args) {
		int arr[] = {2, 0, 2, 1, 1, 0};
		countingSort(arr);
	}
}

