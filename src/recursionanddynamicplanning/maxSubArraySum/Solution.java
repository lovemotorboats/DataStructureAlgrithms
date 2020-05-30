package recursionanddynamicplanning.maxSubArraySum;

//输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
//求所有子数组的和的最大值。要求时间复杂度为O(n)。
class Solution {
    public static int maxSubArray(int[] nums) {
        //dp[i]：以nums[i]结尾的连续子数组中最大和
        //若dp[i-1] <= 0:  dp[i] = nums[i];
        //若dp[i-1] > 0:  dp[i] = dp[i-1] + nums[i];
        //dp[0] = nums[0].
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = dp[i-1] <= 0 ? nums[i] : dp[i-1] + nums[i];
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
