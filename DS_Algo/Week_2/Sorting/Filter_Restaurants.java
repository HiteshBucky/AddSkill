import java.util.*;

class Filter_Restaurants {
	public static void main(String[] args) {
		int restaurants[][] = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
		int veganFriendly = 1, maxPrice = 50, maxDistance = 10;


		System.out.println(Arrays.deepToString(restaurants));

		return Arrays.stream(restaurants)
		       .filter(a -> a[2] >= veganFriendly && a[3] <= maxPrice && a[4] <= maxDistance)
		       .sorted((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1])
		       .map(a -> a[0])
		       .collect(Collectors.toList());

		System.out.println(Arrays.deepToString(restaurants));
	}
}