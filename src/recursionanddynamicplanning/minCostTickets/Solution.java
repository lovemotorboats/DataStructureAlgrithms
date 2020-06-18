package recursionanddynamicplanning.minCostTickets;
/*
 * @description:最低票价
 * @author:liyang
 * @create:2020-06-02
 */

//在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 
//days 的数组给出。每一项是一个从 1 到 365 的整数。火车票有三种不同的销售方式：
//1、一张为期一天的通行证售价为 costs[0] 美元；
//2、一张为期七天的通行证售价为 costs[1] 美元；
//3、一张为期三十天的通行证售价为 costs[2] 美元。
//通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：
// 第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
//返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
public class Solution {
    public static int mincostTickets(int[] days, int[] costs) {
        //dp[i]表示要游玩days[0...i]这些天需要得最低消费
        //days[i]天的游程的票只可能在三种情况内，即日票、周票、月票。
        int[] dp = new int[days.length];
        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));  //只游玩第一天，买票价最低即可
        for (int i = 1; i < days.length; i++){
            //算出最后一天是日票的消费
            int price1 = dp[i-1] + costs[0];
            //算出最后一天是周票的消费
            int j = i - 1;
            int price2;
            while(j >= 0 && days[i] - days[j] < 7){
                j--;
            }
            if (j >= 0){
                price2 = dp[j] + costs[1];
            }else{
                price2 = costs[1];
            }
            //算出最后一天是月票的消费
            int k = i - 1;
            int price3;
            while(k >= 0 && days[i] - days[k] < 30){
                k--;
            }
            if (k >= 0){
                price3 = dp[k] + costs[2];
            }else{
                price3 = costs[2];
            }
            dp[i] = Math.min(price1, Math.min(price2, price3));
        }
        return dp[days.length - 1];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {7, 2, 15};
        System.out.println(mincostTickets(days, costs));
    }
}
