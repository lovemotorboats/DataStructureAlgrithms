package recursionanddynamicplanning.maxSharesProfit;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），
//设计一个算法来计算你所能获取的最大利润。
//注意：你不能在买入股票前卖出股票。
class Solution {
    public int maxProfit(int[] prices) {
        //本题相当于找出数组中的两个数，使之满足：
        //1、后面的数比前面的数大；
        //2、两者的差最大；
        //如果整个数组都没有任何两个数满足条件1，那么就返回0
        //dp[i]表示以索引为i结尾的数为后数，能取得的最大利润
        if (prices == null || prices.length < 2){
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];  //max代表prices[0]到prices[i-1]的最小值
        int max = 0;  //结果
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > min){
                dp[i] = prices[i] - min;
            }else{
                min = prices[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
