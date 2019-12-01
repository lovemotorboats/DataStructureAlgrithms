package string.longestsubstring;

import java.util.ArrayList;
import java.util.Scanner;

//最长递增子序列问题
//给定整数数组arr，返回arr的最长递增子序列
//arr=[2,1,5,3,6,4,8,9,7],其最长递增子序列为[1,3,4,8,9]
public class Solution {
    //经典的动态规划问题
    //dp[i]表示以arr[i]结尾的情况下，arr[0...i-1]的最大递增子序列的长度
    //1、先求出dp数组(方式一：时间复杂度为O(N2))
    public static int[] getdp1(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp;
    }
    //先求出dp数组(方式二：时间复杂度为O(NlogN))


    //2、根据dp数组求出最长递增子序列。
    //先找到dp数组中最大值的值value及位置index，arr[index]就是最长递增子序列的最后一个数，value就是
    //最长递增子序列的长度；然后从该位置向左寻找，如果有个位置i既能满足arr[i]小于arr[index]，
    //又能满足dp[i]=dp[index]-1，那么这个数就是最长子序列中倒数第二个数。继续以此类推直到所有数都找出来。
    public static int[] generateLSS(int[] arr, int[] dp){
        //根据arr数组和dp数组生成arr的最长递增子序列
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++){
            if (dp[i] > len){
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--){
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1){
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    public static int[] getLongestIncrementSubstring(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLSS(arr, dp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入arr数组：");
        while (true){
            int temp = input.nextInt();
            if (temp == -1){
                break;
            }
            list.add(temp);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        int[] subString = getLongestIncrementSubstring(arr);
        for (int i = 0; i < subString.length; i++){
            System.out.print(" " + subString[i]);
        }
    }
}
