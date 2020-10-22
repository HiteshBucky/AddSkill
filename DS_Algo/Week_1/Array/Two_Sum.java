import java.util.*;

class Two_Sum {
	public static int[] twoSum(int nums[], int target) {

		if (nums == null || nums.length < 2) return new int[2];

		Map<Integer, Integer> map = new  HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if ( !map.containsKey(target - nums[i]))
				map.put(nums[i], i);
			else
				return new int[] {map.get(target - nums[i]), i};
		}
		return new int[2];
	}

	public static void main(String[] args) {
		int arr[] = {4, 1, 3, 3};
		int target = 6;
		int ans[] = twoSum(arr, target);
		System.out.println(Arrays.toString(ans));
	}

}