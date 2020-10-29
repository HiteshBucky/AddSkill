import java.util.*;

class Insert_Interval {

	public static int[][] insertInterval(int arr[][], int[] newInterval) {


		int newArray[][] = new int[arr.length + 1][2];
		for (int i = 0; i < arr.length; i++)
			newArray[i] = arr[i];
		newArray[newArray.length - 1] = newInterval;

		Arrays.sort(newArray, (a, b) -> Integer.compare(a[0], b[0]));


		List <Integer[]> list = new ArrayList<>();
		int j , limit;

		for (int i = 0; i < newArray.length;) {
			j = i + 1;
			limit = newArray[i][1];
			while ( j < newArray.length && newArray[j][0] <= limit) {
				limit = Math.max(limit, newArray[j][1]);
				j++;
			}
			list.add(new Integer[] {newArray[i][0], limit});
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
		int arr[][] = {};
		System.out.println(Arrays.deepToString(insertInterval(arr, new int[] {2, 5})));
	}
}