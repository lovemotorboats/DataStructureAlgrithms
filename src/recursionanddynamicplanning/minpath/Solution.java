package recursionanddynamicplanning.minpath;

//有一个M*N的矩阵m，从起点每次只能往右或者往下走，走到终点（右下角位置），所经过的
//所有点的数值加起来的最小值是多少？
public class Solution {
    //典型的动态规划问题。生成一个M*N的矩阵dp[M][N]，其中dp[i][j]表示从dp[0][0]到
    //dp[i][j]的最短路径长度，dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+m[i][j]
    public static int getMinPath1(int[][] m) {
        //方法一：空间复杂度为O(M*N)
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
            return 0;
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++)
            dp[i][0] = dp[i-1][0] + m[i][0];
        for (int i = 1; i < col; i++)
            dp[0][i] = dp[0][i-1] + m[0][i];
        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + m[i][j];
        }
        return dp[row-1][col-1];
    }
    //方法二：(滚动dp数组减少空间复杂度为O(min{M, N}))
    public static int getMinPath2(int[][] m){
        if (m == null || m.length == 0 ||m[0] == null || m[0].length == 0)
            return 0;
        int more = Math.max(m.length, m[0].length);
        int less = Math.max(m.length, m[0].length);
        boolean rowMore = more == m.length;  //行数是否大于列数
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++){
            arr[i] = arr[i-1] + (rowMore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++){
            arr[0] = arr[0] + (rowMore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++){
                arr[j] = Math.min(arr[j-1], arr[j]) + (rowMore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less-1];

    }
}
