class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";

        String first = strs[0], last = strs[0];

        for (String str : strs) {
            if (str.compareTo(first) < 0)
                first = str;
            if (str.compareTo(last) > 0)
                last = str;
        }

        int k = 0;
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) == last.charAt(i)) k++;

            else break;
        }
        return last.substring(0, k);
    }
}