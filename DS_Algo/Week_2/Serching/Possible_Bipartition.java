import java.util.*;

class Possible_Bipartition {

	public static boolean solver(int array[][], int n) {

		List<Integer> graph[] = new ArrayList[n];

		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();

		// Initialize the dislike list who dislike whom, -1 for 0 based indexing
		for (int[] arr : array) {
			graph[arr[0] - 1].add(arr[1] - 1);
			graph[arr[1] - 1].add(arr[0] - 1);
		}

		// Keep a track which element is visited for colouring purpose
		int visited[] = new int[n];

		/*
			In visited array 0 -> not visited, 1 and -1 is used for coloring ,
			if 1 is color then all its adjacent will have -1 color
		*/
		for (int i = 0; i < n; i++ ) {
			if (visited[i] != 0) continue;
			visited[i] = 1;

			/*BFS*/
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);

			while (!queue.isEmpty()) {
				int curr_node = queue.remove();
				//Traverse all the neighbour of curr eleme
				for (int neighbour : graph[curr_node] ) {
					if (visited[neighbour] == visited[curr_node]) //If we found neighbour adn curr have same colour then return fasle
						return false;

					if (visited[neighbour] == 0) {	//If neighbour is not visited then set visited by changing its colour and add it in queue
						visited[neighbour] = -visited[curr_node];
						queue.add(neighbour);
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int arr[][] = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
		System.out.println(solver(arr, 5));

	}

}


