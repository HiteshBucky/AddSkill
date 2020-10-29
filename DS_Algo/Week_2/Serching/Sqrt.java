/*
	Implement int sqrt(int x).

	Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

	Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

	Example 1:

	Input: 4
	Output: 2
	Example 2:

	Input: 8
	Output: 2
*/

import java.util.*;

class Sqrt {

	static int mySqrt(int left, int right, int n) {
		if (n < 2) return ;
		while (left < right) {
			int mid = (left + right) / 2;
			if (mid <= n / mid && (mid + 1) > n / (mid + 1)) return mid;
			else if (mid > n / mid) right = mid;
			else left = mid + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(1, 2147395599, 2147395599));
	}
}