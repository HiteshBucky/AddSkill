import java.util.*;

class Valid_Anagram {

	static boolean isValidAnagram(String s, String t) {
		int count[] = new int[26];
		for (char ch : s.toCharArray())
			count[ch - 'a']++;
		for (char ch : t.toCharArray())
			count[ch - 'a']--;

		for (int num : count)
			if (num != 0) return false;

		return true;
	}

	public static void main(String[] args) {
		String s = "rat" , t = "";
		System.out.println(isValidAnagram(s, t));
	}
}