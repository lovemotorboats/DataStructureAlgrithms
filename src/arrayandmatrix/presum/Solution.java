package arrayandmatrix.presum;
/*
 * @description:前缀和
 * @author:liyang
 * @create:2020-06-23
 */

import java.util.HashMap;
import java.util.Map;

//算出一共有几个和为 k 的子数组。
public class Solution {

    public static int subArraySum(int[] nums, int k) {
        //求出数组nums中有多少个子数组的和等于k
        int n = nums.length;
        Map<Integer, Integer> preSum = new HashMap<>();  //前缀和->出现的次数
        preSum.put(0, 1);
        int res = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                res += preSum.get(sum0_j);
            }
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subArraySum(nums, 3));
    }
}
