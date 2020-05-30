package recursionanddynamicplanning.minCostStairs;

//数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //本题相当于求数组的子序列之和的最小值
        //要求：1、每相邻两个数的索引值的差小于等于2大于等于1；
        //2、子序列必须以数组的最后一个元素或者倒数第二个元素结尾。
        //dp[i]代表以索引i的元素结尾，并且相邻两个元素的索引值相差不超过2的子序列的最小和

        //dp[i] = min{dp[i-1], dp[i-2]} + cost[i]；
        //dp[0] = cost[0];
        //dp[1] = cost[1];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            dp[i] = dp[i-1] > dp[i-2] ? dp[i-2] + cost[i] : dp[i-1] + cost[i];
        }
        return dp[cost.length - 2] > dp[cost.length - 1] ? dp[cost.length - 1] : dp[cost.length - 2];
    }
}