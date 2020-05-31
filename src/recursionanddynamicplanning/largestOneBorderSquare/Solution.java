package recursionanddynamicplanning.largestOneBorderSquare;

//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大正方形
//子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        //构造两个二维dp数组，left[i][j]表示从grid[i][j]位置向左有多少个连续的1，
        //up[i][j]表示从grid[i][j]位置向上有多少个连续的1.
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    if (i == 0 && j == 0){
                        up[i][j] = 1;
                        left[i][j] = 1;
                    }else if (i == 0){
                        up[i][j] = 1;
                        left[i][j] = left[i][j-1] + 1;
                    }else if (j == 0){
                        left[i][j] = 1;
                        up[i][j] = up[i-1][j] + 1;
                    }else{
                        left[i][j] = left[i][j-1] + 1;
                        up[i][j] = up[i-1][j] + 1;
                    }
                }
                int min = Math.min(left[i][j], up[i][j]);
                for (int k = min; k >= 1; k--){
                    if (left[i-k+1][j] >= k && up[i][j-k+1] >= k){
                        result = Math.max(result, k);
                        break;
                    }
                }
            }
        }
        return result * result;
    }
}
