package stackandqueue.getnearless;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个数组arr，找到每一个i位置前面和后面距离i位置最近且小于arr[i]的位置
//当不存在这样的元素时，就返回-1
//分别分为arr元素可重复和不可重复两种情况讨论
public class Solution {
    //1、arr不允许出现重复元素的情况
    //维护一个从栈顶到栈底严格单调递减的单调栈，弹出x元素时，x元素下面的位置就是左边
    //所求，当前遍历位置就是右边所求
    public static int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int popIndex = stack.pop();  //取出栈顶元素
                int leftLessIndex = stack.isEmpty()? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        //处理栈中剩下的元素
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty()? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;  //右边不存在比它小的元素
        }
        return res;
    }

    //2、arr中可以有重复元素时，处理变成了对list的处理，相等的元素被放进同一个
    //list中再被压入到栈中
    public static int[][] getNearLess(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]){
                List<Integer> popIs = stack.pop();
                //取出位于下面位置的列表中，最晚加入的那个元素的位置
                int leftLessIndex =  stack.isEmpty()? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : popIs){
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i])
                stack.peek().add(Integer.valueOf(i));
            else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()){
            List<Integer> popIs = stack.pop();
            int leftLessIndex = stack.isEmpty()? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popi : popIs){
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }
}
