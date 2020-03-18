package recursionanddynamicplanning.mostEOR;

import java.util.HashMap;

//子数组异或和等于0的最多划分
public class Solution {

    //给定一个整型数组arr，可正可负可0，可以将数组切分成若干个子数组（顺序不变哦）,求
    //异或和等于零的子数组最多有多少个
    //分析：动态规划
    //dp[i]的含义是如果在arr[0..i]上做划分，最多有多少个.
    //如果依次求出dp[0]、dp[1]...dp[N-1],那么dp[N-1]即为所求

    public static int getMostEOR(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int eor = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        dp[0] = arr[0] == 0 ? 1 : 0;
        map.put(arr[0], 0);
        for (int i = 1; i < arr.length; i++){
            eor ^= arr[i];
            if (map.containsKey(eor)){
                int preEorIndex = map.get(eor);
                dp[i] = preEorIndex == -1 ? 1 : (dp[preEorIndex] + 1);
            }
            dp[i] = Math.max(dp[i-1], dp[i]);
            map.put(eor, i);
        }
        return dp[dp.length -1];
    }
}
