class Solution {
    public int numberOfSteps (int num) {
        int one = 0, zero = 0;
        for(int i = 0; i < 32; i++) {
            if((num & (1 << i)) > 0) {
                one ++;
                zero = Math.max(zero, i);
            }
        }
        return one + zero;
    }
}
