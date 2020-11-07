import java.util.*;

class Solution {
	public static int[] dailyTemperatures(int[] T) {
		int[] ans = new int[T.length];
		for (int currDay = T.length - 1; currDay >= 0; currDay--)
			for (int prevDay = currDay - 1; prevDay >= 0 && T[prevDay] < T[currDay]; prevDay--)
				ans[prevDay] = currDay - prevDay;
		return ans;
	}

	public static void main(String[] args) {
		int tem[] = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toStrign(dailyTemperatures(temp)));
	}
}