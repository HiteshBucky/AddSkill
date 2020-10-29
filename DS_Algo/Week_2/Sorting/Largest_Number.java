import java.util.*;
import java.util.Arrays;

class Largest_Number {

	static String getLargestNumber(int arr[]) {

		Integer[] sorted = Arrays.stream( arr ).boxed().toArray( Integer[]::new );

		Arrays.sort(sorted, new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {
				String s1 = i.toString() + j.toString();
				String s2 = j.toString() + i.toString();
				return s2.compareTo(s1);
			}
		});

		System.out.println(Arrays.toString(sorted));
		String ans = "";
		for (int num : sorted)
			ans += num;
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		System.out.println(getLargestNumber(arr));
	}
}