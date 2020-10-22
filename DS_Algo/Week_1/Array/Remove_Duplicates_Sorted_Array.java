class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int i = 0, j = i + 1;
        for (; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}