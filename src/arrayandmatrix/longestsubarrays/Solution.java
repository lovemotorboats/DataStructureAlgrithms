package arrayandmatrix.longestsubarrays;

import java.util.HashMap;

//未排序数组中累加和为给定值的最长子数组系列问题
public class Solution {
    //原问题：给定一无序整数数组arr，元素可正可负可零，给定一个整数k，求arr的所有子数组
    //中累加和为k的最长子数组长度
    //本题思路：
    //1、令sum=0，代表从位置0开始一直累加到i位置所有元素的和，令len=0，表示累加和
    //为k的最长子数组长度。设置map<key, value>，其中key表示从arr最左边开始累加的过程
    //中出现过的sum值，对应的value则表示sum值最早出现的位置
    //2、从左开始遍历，在map中查找是否存在sum-k，如果存在，记它的为value值为j，因为map中
    //只记录每一个累加和最早出现的位置，所以arr[j+1...i]时在以arr[i]结尾的所有子数组中
    //最长的累加和为k的子数组，如果其长度大于len，则更新len；若果map中不存在sum，就将(sum,i)
    //加入到map中，然后继续遍历。
    //3、非常重要的一点，初始化令map(0, -1)
    public static int maxSubLength(int[] arr, int k){
        if (arr == null || arr.length == 0)
            return 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  //非常重要
        int len = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (map.containsKey(sum - k))
                len = Math.max(len, i - map.get(sum - k));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return len;
    }

    //
}
