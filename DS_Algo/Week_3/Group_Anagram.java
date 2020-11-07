import java.util.*;

/*
	Count the char of every char in a word
	two words will be anagram if and only ifbothwords have same countfor each alaphabet

*/

class Solution {

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) return null;

		Map<String, List<String>> map = new HashMap<>();
		for (String word : strs) {
			String currMap = countCharacterInArray(word);

			List<String> l = map.getOrDefault(currMap, new ArrayList<>());
			l.add(word);
			map.put(currMap, l);
		}
		return new ArrayList<>(map.values());
	}

	public static String countCharacterInArray(String word) {
		int[] wordCountArray = new int[26];
		for (char ch : word.toCharArray()) {
			wordCountArray[ch - 'a']++;
		}
		return Arrays.toString(wordCountArray);
	}

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

		System.out.println(groupAnagrams(strs));

	}
}