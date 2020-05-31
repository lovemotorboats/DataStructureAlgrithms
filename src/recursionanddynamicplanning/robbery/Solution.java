package recursionanddynamicplanning.robbery;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
//影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
//如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
//一夜之内能够偷窃到的最高金额。
class Solution {
    public int rob(int[] nums) {
        //本题相当于求非负整数数组的子序列之和的最大值，子序列要求相邻两个元素的索引值之差大于1
        //dp[i]表示以索引值未i的元素结尾，且满足上述子序列要求的所有子序列中，和的最大值
        //dp[i] = max{dp[i-2], dp[i-3]} + nums[i]; (i >= 3)
        //dp[0] = nums[0], dp[1] = nums[1], dp[2] = dp[0] + nums[2];
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        int max = Math.max(Math.max(dp[0], dp[1]), dp[2]);
        for (int i = 3; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
