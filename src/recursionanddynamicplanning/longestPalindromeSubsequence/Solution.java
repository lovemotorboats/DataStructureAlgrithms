package recursionanddynamicplanning.longestPalindromeSubsequence;


//最长回文子序列
public class Solution {

    //给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]表示s[i...j]的最长子序列的长度
        //当s[i] == s[j]时，dp[i][j] = dp[i+1][j-1];
        //当s[i] != s[j]时，dp[i][j] = max{dp[i+1][j], dp[i][j-1]}
        //base case:当i == j时，dp[i][j] = 1;当i > j时，dp[i][j] = 0
        //遍历方式：斜向
        char[] s_array = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s_array[i] == s_array[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
