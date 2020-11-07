import java.util.*;

class Island_Perimeter {

	public  static int getPerimeterFromNeighbour(int grid[][], int x, int y) {
		int rows[] = { -1, 0,  1, 0};
		int cols[] = {0, 1, 0, -1};

		int currRow, currCol, ans = 0;
		for (int i = 0; i < rows.length; i++) {
			currRow = x + rows[i];
			currCol = y + cols[i];
			System.out.println("currRow " + currRow + " ");
			if (currRow < 0 || currRow == grid.length || currCol < 0 || currCol == grid[0].length || grid[currRow][currCol] == 0)
				ans++;
		}
		System.out.println("Called at : " + x + " , " + y + " ans : " + ans);
		return ans;
	}

	public static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				perimeter += (grid[i][j] == 1) ? getPerimeterFromNeighbour(grid, i, j) : 0;

		return perimeter;
	}

	public static void main(String[] args) {
		int grid[][] = {{1}};

		System.out.println(islandPerimeter(grid));
	}

}