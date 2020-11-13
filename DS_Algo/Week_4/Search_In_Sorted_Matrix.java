import java.util.*;


/*
	74. Search a 2D Matrix
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.

	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
	Output: false

*/

class Search_In_Sorted_Matrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		//looping through each row
		for (int i = 0; i < matrix.length; i++) {
			int left = 0;
			int right = matrix[0].length - 1;
			//Looping through each col Using Binary Searach
			while (left <= right) {
				int mid = (left + right) / 2;
				if (matrix[i][mid] == target)return true;
				else if (matrix[i][mid] < target)left = mid + 1; //Goright
				else if (matrix[i][mid] > target)right = mid - 1; // GO left
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 13;
		System.out.println(searchMatrix(matrix, target));
	}
}