/*
	Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

	If target is not found in the array, return [-1, -1].

	Example 1:

	Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]
	Example 2:

	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]
	Example 3:

	Input: nums = [], target = 0
	Output: [-1,-1]

*/
import java.util.*;
class First_And_Last_Range_Search {

	public static int[] searchRange(int nums[], int target) {
		int start = searchLeft(nums, target);
		int end = searchRight(nums, target);
		if (start > end) return new int[] { -1, -1};

		return new int[] {start, end};
	}

	public static int searchLeft(int[] nums, int target) {
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (target > nums[mid]) left = mid + 1;
			else right = mid;
		}
		return left;
	}

	public static int searchRight(int[] nums, int target) {
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (target < nums[mid]) right = mid;
			else left = mid + 1;
		}
		return right - 1;
	}
	public static void main(String[] args) {
		int arr[] = {5, 7, 7, 8, 8, 10};
		System.out.println(Arrays.toString(searchRange(arr, 8)));
	}
}