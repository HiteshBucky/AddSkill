import java.util.*;
import static java.util.Arrays.*;

class Brick_Wall {

	static int getLeastBricks(List<List<Integer>> grid) {
		Map<Integer, Integer> map = new HashMap<>();

		int max_frequency = 0;

		for (List<Integer> row : grid) {
			int edge_positioin = 0;
			for (int brick_no = 0; brick_no < row.size() - 1; brick_no++) {
				edge_positioin += row.get(brick_no); //Next edge position, (last position + curr length)
				map.put(edge_positioin, map.getOrDefault(edge_positioin, 0) + 1); // if this is new put it in map with freq 1, otherwise freq++
				max_frequency = Math.max(max_frequency, map.get(edge_positioin)); // Updating our frequency
			}
		}
		System.out.println(map);

		return grid.size() - max_frequency;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = asList( asList( 1, 2, 2, 1 ), asList( 3, 1, 2 ), asList( 1, 3, 2), asList( 2, 4), asList(3, 1, 2), asList(1, 3, 1, 1) );
		// System.out.println(list);
		System.out.println(getLeastBricks(list));
	}
}