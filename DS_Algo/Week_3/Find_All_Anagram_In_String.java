import java.util.*;

class Find_All_Anagram_In_String {

	static int countForT[];

	static boolean isValidAnagram(String s, int start, int last) {

		int cuurrCount[] = new int[26];

		for (int i = start; i < last; i++)
			cuurrCount[s.charAt(i) - 'a']++;

		return Arrays.equals(countForT, cuurrCount);
	}

	static List<Integer> isValidAnagram(String s, String t) {

		List<Integer> ans = new ArrayList<>();

		countForT = new int[26];

		for (char ch : t.toCharArray())
			countForT[ch - 'a']++;

		for (int i = 0; i <= s.length() - t.length(); i++)
			if (isValidAnagram(s, i, i + t.length()))
				ans.add(i);

		return ans;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd" , t = "csdjkjdskfjsk";
		System.out.println(isValidAnagram(s, t));
	}

}