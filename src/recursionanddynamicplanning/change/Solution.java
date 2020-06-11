package recursionanddynamicplanning.change;

//找零钱
//问题描述：给定纸币面值数组arr,arr中的所有数都是正整数且不重复。
// 每种面值的货币可以有任意张，再给定一个整数aim，代表要找的钱数，
//请问有多少种换零钱的方法？
//例如arr=[5, 10, 25, 1], aim=0 ->只有一种方法：所有面值都不用
//例如arr=[5, 10, 25, 1], aim=15 ->总共有6种方法，分别是：
//5*3, 10+5, 10+1*5，5+1*10, 5*2+1*5, 1*15

public class Solution {
    //方法一：暴力递归
    public static int process1(int[] arr, int index, int aim){
        int res = 0;
        if (index == arr.length){
            res = aim == 0 ? 1 : 0;
        }else {
            for (int i = 0; arr[index] * i <= aim; i++){
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }
    //主方法
    public static int coins1(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        return process1(arr, 0 , aim);
    }

    //方法二：机器人套路
    //生成行数为N，列数为aim+1的矩阵dp，dp[i][j]表示在使用arr[0...i]货币的条件下，组成钱数
    //j有多少种方法
    public static int coins3(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++){  //初始化列
            dp[i][0] = 1;
        }
        for (int j = 1; j * arr[0] <= aim; j++){  //初始化行
            dp[0][j * arr[0]] = 1;
        }
        int num;
        for (int i = 1; i < arr.length; i++){
            for (int j = 1; j < aim; j++){
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++){
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    //方法三：排列组合
    public static int waysToChange(int n) {
        int[] value = {5, 10, 25};
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++){
            dp[i] = 1;
        }
        for (int v : value){
            for(int i = 1; i <= n; i++){
                if (i >= v){
                    dp[i] = (dp[i] + dp[i-v]) % 1000000007;
                }
            }
        }
        return dp[n] ;
    }
}
