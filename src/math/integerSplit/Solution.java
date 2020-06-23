package math.integerSplit;
/*
 * @description:整数加法划分
 * @author:liyang
 * @create:2020-06-22
 */

public class Solution {

    //普通整数划分
    public static int intSplit(int n) {
        //dp[n][m]表示n划分成不超过m的数的整数划分总数
        //dp[n][m] = 1 (m == 1 || n == 1)
        //dp[n][m] = dp[n][n]  (m > n)
        //dp[n][m] = dp[n-m][m] + dp[n][m-1] (n > m)
        //dp[n][m] = 1 + dp[n][m-1]  (n == m)
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else if (i > j) {
                    dp[i][j] = dp[i - j][j] + dp[i][j - 1];
                } else if (i < j) {
                    dp[i][j] = dp[i][i];
                } else {
                    dp[i][j] = 1 + dp[i][j - 1];
                }
            }
        }
        return dp[n][n];
    }

    //加条件的整数划分
    public static int intSplitPlus(int n) {
        //不能划分成相等的数相加（比如3 = 1 + 1 + 1， 4 = 1 + 1 + 1 + 1或4 = 2 + 2都不合法）

        //找从1到n中能整除n的数有多少
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (n % i == 0 ? 1 : 0);
        }
        return intSplit(n) - sum;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            System.out.println(intSplitPlus(i));
        }
//        System.out.println(intSplit(2));
    }
}
