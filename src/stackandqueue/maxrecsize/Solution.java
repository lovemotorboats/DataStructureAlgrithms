package stackandqueue.maxrecsize;

import java.util.Stack;

//给定一个整型矩阵map，它的值只有0和1两种，求其中全是1的矩行区域中，最大矩形区域的1的数量
//思想：1、以矩阵每一行做切割，统计以当前行为底的情况下，每个位置往上的连续1的数量，用高度数组height存储
//2、对于每一次切割，都利用更新后的height数组求出以当前行为底的最大矩形是什么
public class Solution {
    public static int maxRecFromBottom(int[] height){
        //统计以height为底的最大矩形的面积
        if (height == null || height.length == 0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]){
                int j = stack.pop();
                int k = stack.isEmpty()? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(curArea, maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(curArea, maxArea);
        }
        return maxArea;
    }

    public static int maxRecSize(int[][] map){
        if (map == null || map.length == 0 || map[0].length == 0)
            return 0;
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++)
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            maxArea = Math.max(maxArea, maxRecFromBottom(height));
        }
        return maxArea;
    }
}
