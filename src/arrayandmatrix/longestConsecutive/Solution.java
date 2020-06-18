package arrayandmatrix.longestConsecutive;
/*
 * @description:给定一个未排序的整数数组，找出最长连续序列的长度。
 * @author:liyang
 * @create:2020-06-18
 */

import java.util.*;

//输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
class Solution {

    //思想：遍历nums中的所有元素，对于遍历到的元素A，若nums中存在元素A-1，就跳过该元素；否则就依次判断从A开始最长
    //可连续的序列是多少，并更新最长序列的长度
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longestStreak = 0;
        for (int i : set) {
            if (!set.contains(i-1)) {
                int currentNum = i;
                int currentStreak = 1;
                while (set.contains(currentNum+1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = longestStreak > currentStreak ? longestStreak : currentStreak;
            }
        }
        return longestStreak;
    }
}
