class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //looping through each row
		for (int i = 0; i < matrix.length; i++) {
			int left = 0;
			int right = matrix[0].length - 1;
			//Looping through each col Using Binary Searach
			while (left <= right) {
				int mid = left + (right-left) / 2;
				if (matrix[i][mid] == target)return true;
				else if (matrix[i][mid] < target)left = mid + 1; //Goright
				else if (matrix[i][mid] > target)right = mid - 1; // GO left
			}
		}
		return false;
    }
}
