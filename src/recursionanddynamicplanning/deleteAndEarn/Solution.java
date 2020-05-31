package recursionanddynamicplanning.deleteAndEarn;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
        //对nums先进行预处理，先按从小到大的顺序排序,然后去重，
        //然后构造一个数组score，与之对应，score[i]代表排序后的
        //nums[i]被选中后能得到的分数，注意scores[i] = nums[i] * 次数。
        //最后按打家劫舍的思想求出。
        if (nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = 0;
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> newNums = new ArrayList<>();
        while(i < nums.length){
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            scores.add(nums[i] * (j - i));
            newNums.add(nums[i]);
            i = j;
        }
        Integer[] score = (Integer[]) scores.toArray();
        Integer[] newNum = (Integer[]) newNums.toArray();  //newNum[i]与前面的数和后面的数若只相差1，则不能同时选


        if (score.length == 1){
            return score[0];
        }
        if (score.length == 2){
            if (newNum[0] == newNum[1] - 1){
                return Math.max(score[0], score[1]);
            }else{
                return score[0] + score[1];
            }
        }
        if (score.length == 3){
            if (newNum[0] != newNum[1] - 1 && newNum[1] != newNum[2] - 1){
                return score[0] + score[1] + score[2];
            }else if (newNum[0] != newNum[1] - 1){
                return Math.max(score[0], score[1]) + score[2];
            }else {
                return Math.max(score[1], score[2]) + score[0];
            }
        }


        int[] dp = new int[newNum.length];
        dp[0] = score[0];
        dp[1] = newNum[0] == newNum[1] - 1 ? Math.max(score[0], score[1]) : score[0] + score[1];
        if (newNum[0] != newNum[1] - 1 && newNum[1] != newNum[2] - 1){
            dp[2] = score[0] + score[1] + score[2];
        }else if (newNum[0] != newNum[1] - 1){
            dp[2] = Math.max(score[0], score[1]) + score[2];
        }else {
            dp[2] = Math.max(score[1], score[2]) + score[0];
        }
        int result = Math.max(dp[2], Math.max(dp[0], dp[1]));
        for (int k = 3; k < newNum.length; k++){
            if (newNum[k-1] == newNum[k] - 1){
                if (newNum[k-3] == newNum[k-2] - 1){
                    dp[k] = Math.max(dp[k-3], dp[k-2]) + score[k];
                }else{
                    dp[k] = dp[k-2] + score[k];
                }
            }else{
                if (newNum[k-2] == newNum[k-1] - 1){
                    dp[k] = Math.max(dp[k-2], dp[k-1]) + score[k];
                }else{
                    dp[k] =  dp[k-1] + score[i];
                }
            }
            result = Math.max(result, dp[k]);
        }
        return result;
    }
}
