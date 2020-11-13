import java.util.*;

class Count_One {

	static int solver(int num) {

		// // /*MEthod 1*/
		String str = Integer.toBinaryString(num);
		System.out.println(str);
		// // int count = 0;
		// // for (char ch : str.toCharArray())
		// // 	count += ch - '0';
		// // return count;

		// // /*Method 2*/
		// // return Integer.bitCount(num);

		// /*Method 3*/
		if (num == 0) return num;
		int index = 0;
		while (num != 0) {
			if ( (num & 1) == 1) return index;
			index++;
			num >>= 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(solver(num));
	}
}