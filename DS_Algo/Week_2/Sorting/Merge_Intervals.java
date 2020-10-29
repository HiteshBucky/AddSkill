import java.util.*;

class Merge_Intervals {

	public static int[][] mergeInterval(int arr[][]) {
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		List <Integer[]> list = new ArrayList<>();
		int j , limit;

		for (int i = 0; i < arr.length;) {
			j = i + 1;
			limit = arr[i][1];
			while ( j < arr.length && arr[j][0] <= limit) {
				limit = Math.max(limit, arr[j][1]);
				j++;
			}
			list.add(new Integer[] {arr[i][0], limit});
			i = j;
		}


		int result[][] = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i][0] = list.get(i)[0];
			result[i][1] = list.get(i)[1];
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[][] = {{1, 3}, {8, 10}, {2, 6},  {15, 18}};
		System.out.println(Arrays.deepToString(mergeInterval(arr)));
	}
}