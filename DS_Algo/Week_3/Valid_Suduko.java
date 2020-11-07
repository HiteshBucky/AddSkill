class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet bucket = new HashSet();

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.')
                    if (!bucket.add("row" + i + " " + board[i][j])
                            || !bucket.add("col" + j + " " + board[i][j])
                            || !bucket.add("grid" + ((i / 3) * 3 + j / 3) + " " + board[i][j]))
                        return false;

        return true;
    }
}