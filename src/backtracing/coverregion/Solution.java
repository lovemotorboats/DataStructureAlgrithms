package backtracing.coverregion;

//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

//被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
//任何不在边界上，且不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
//如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

public class Solution {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        System.out.println();
    }

    public static void solve(char[][] board) {
        //1、先从边界上的'O'开始进行dfs搜索，将与之相邻的0设置为'#'
        //2、对内部所有的'O'都改成'X'，'#'还原成'O'
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < cols; i++) {
            dfs(board, 0, i);
        }
        for (int i = 1; i < rows; i++) {
            dfs(board, i, cols - 1);
        }
        for (int i = cols - 1; i >= 0; i--) {
            dfs(board, rows - 1, i);
        }
        for (int i = rows - 2; i >= 1; i--) {
            dfs(board, i, 0);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            dfs(board, row + dx[i], col + dy[i]);
        }
    }
}
