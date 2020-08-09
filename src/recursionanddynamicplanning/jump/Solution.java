package recursionanddynamicplanning.jump;

//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。

public class Solution {

    public static int jump(int[] nums) {
        //方法一：动态规划
        //dp[i]表示从索引i开始跳到最后一个位置需要的最少步数
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            int len = nums[i];
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j - i <= len && j < n; j++) {
                min = Math.min(min, dp[j]);
            }
            dp[i] = min != Integer.MAX_VALUE ? min + 1 : min;
        }
        return dp[0];

        //方法二：贪心
        // int res = 0, end = 0, farthest = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        //     farthest = Math.max(farthest, nums[i] + i);
        //     if (end == i) {
        //         end = farthest;
        //         res++;
        //     }
        // }
        // return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        System.out.println(jump(nums));
    }
}
