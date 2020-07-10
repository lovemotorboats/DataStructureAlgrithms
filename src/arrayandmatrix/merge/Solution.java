package arrayandmatrix.merge;
/*
 * @description:合并区间
 * @author:liyang
 * @create:2020-07-03
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//给出一个区间的集合，请合并所有重叠的区间。
//输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }

        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(e -> e[1]));  //将区间按end从小到大排序

        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                int[] newInterval = new int[2];
                newInterval[0] = left;
                newInterval[1] = right;
                list.add(newInterval);
                //更新左右边界
                left = intervals[i][0];
            }else if (intervals[i][0] < left) {
                left = intervals[i][0];
            }

            right = intervals[i][1];  //更新右边界
        }

        int[] newInterval = new int[2];
        newInterval[0] = left;
        newInterval[1] = right;
        list.add(newInterval);

        int[][] res = new int[list.size()][2];
        int index = 0;
        for (int[] ints : list) {
            res[index++] = ints;
        }
        return res;
    }
}
