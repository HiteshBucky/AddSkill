// Find_Common_Characters.java
import java.util.*;

class Find_Common_Characters {

	static List<String> commonChar(String[] strs) {
		int counter[] = new int[26];
		int length = strs.length;

		for (char ch : strs[0].toCharArray())
			counter[ch - 'a']++;


		for (int i = 1; i < length; i++) {

			int curr[] = new int[26];

			for (char ch : strs[i].toCharArray())
				curr[ch - 'a']++;

			for (int j = 0; j < 26; j++)
				counter[j] = Math.min(counter[j], curr[j]);
		}

		List<String> list = new ArrayList<>();
		for (int i = 0; i < 26; i++)
			for (int j = 0; j < counter[i]; j++)
				list.add( ((char)('a' + i)) + "" );

		return list;
	}

	public static void main(String[] args) {
		String str[] = {"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"};
		System.out.println(commonChar(str));
	}
}