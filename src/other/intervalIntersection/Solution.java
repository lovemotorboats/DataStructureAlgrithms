package other.intervalIntersection;

/*
 * @description:区间交集
 * @author:liyang
 * @create:2020-06-23
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
    // 返回这两个区间列表的交集。
    //（形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，
    // 要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        int aLen = A.length, bLen = B.length;
        List<int[]> list = new ArrayList<>();
        while (i < aLen && j < bLen) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[i][0], b2 = B[i][1];
            //两个区间存在交集
            if (a1 <= b2 && b1 <= a2) {
                int[] newIntersection = new int[2];
                newIntersection[0] = Math.max(a1, b1);
                newIntersection[1] = Math.min(a2, b2);
                list.add(newIntersection);
            }
            if (b2 < a2) {
                j++;
            }else {
                i++;
            }
        }

        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        //[[0,2],[5,10],[13,23],[24,25]]
        //[[1,5],[8,12],[15,24],[25,26]]
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    }
}

