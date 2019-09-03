package stackandqueue.getmaxwindow;

import java.util.LinkedList;

//求出给定数组arr和滑动窗口w的每个w长的窗口内的最大值
//方案：维护一个双端递减队列，队列中存放数组的index，队头存放滑动窗口
//的最大值，当当前遍历到的索引减去窗口长度w等于队首索引时，此队首索引已经过期
//需要弹出队首元素
public class Solution {
    public static int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1 || arr.length < w)
            return null;
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollFirst();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w)
                qmax.pollFirst();  //队首元素过期，需要弹出
            if (i >= w - 1)
                res[index++] = arr[qmax.peekFirst()];
        }
        return res;
    }
}
