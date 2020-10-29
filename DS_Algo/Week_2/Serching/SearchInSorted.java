import java.util.*;
class SearchInSorted {

	static int searchElement(int arr[], int target) {
		if (arr == null || arr.length < 1) return -1;

		int left = 0, right = arr.length - 1, mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (target == arr[mid]) return mid;

			else if (arr[mid] <= arr[right]) {
				if (target > arr[mid] && target <= arr[right]) left = mid + 1;
				else right = mid - 1;
			} else {
				if (target < arr[mid] && target >= arr[left]) right = mid - 1;
				else left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int ar[] = {1, 3};
		System.out.println(searchElement(ar, 3));
		int arr[] = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(searchElement(arr, 3));
		int aaar[] = {1};
		System.out.println(searchElement(aaar, 0));
	}
}