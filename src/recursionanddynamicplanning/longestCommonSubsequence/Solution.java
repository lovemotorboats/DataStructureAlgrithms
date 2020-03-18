package recursionanddynamicplanning.longestCommonSubsequence;

//给定两个字符串，返回两个字符串的最长公共子序列
public class Solution {
    //动态规划来求解，生成大小为M*N的矩阵dp，dp[i][j]的含义是str1[0..i]和str2[0..j]的最长
    //公共子序列的长度，可以从左到右从上到下依次计算矩阵dp
    //分析：第一行第一列很容易，就不分析了
    //对于其它行列只有三种情况，dp[i][j]应该等于
    // max{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+1(如果str1[i]==str2[j])}

    //根据str1和str2获取dp矩阵
    public static int[][] getdp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);  //当某一个位置和str2[0]相等
            //后，后面的都等于1
        }
        for (int j = 1; j < str2.length; j++){
            dp[0][j] = Math.max(dp[0][j-1], str2[j] == str1[0] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++){
            for (int j = 1; j < str2.length; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp;
    }

    //通过整个dp矩阵的状态，可以逆推出最长公共子序列
    //如果dp[i][j]大于dp[i-1][j]和dp[i][j-1]，说明当初是选择了str[i]这个字符，然后向左上方移动
    //如果dp[i][j]等于dp[i-1][j]，说明dp[i-1][j-1]+1不是必须的决策，上移
    //如果dp[i][j]等于dp[i][j-1]，说明dp[i-1][j-1]+1不是必须的决策，左移

    //完整代码
    public static String getLongestCommonSubsequence(String str1, String str2){
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[][] dp = getdp(chas1, chas2);
        int m = str1.length() - 1;
        int n = str2.length() - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0){
            if (n > 0 && dp[m][n] == dp[m][n-1]){
                n--;
            }else if (m > 0 && dp[m][n] == dp[m-1][n]){
                m--;
            }else {
                res[index--] = chas1[m];
            }
        }
        return String.valueOf(res);
     }
}
