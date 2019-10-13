package binarytree.getmaxhappy;

//题目：有一棵树是结点类型为整型的n叉树，选取树中的某些结点，要让选中的
//结点的值的和最大，要求是如果一个结点被选中那么它的所有子节点都不允许被选中
public class Solution {
    //可以用递归思想来实现
    //一棵以X为结点的n叉树，只有两种情况，X被选中的情况和X没有被选中的情况
    //假设X被选中的情况下整棵树能达到的最大值为yes_X_max，X没有被选中的情况下
    //整棵树能达到的最大值为no_X_max。
    //假设X有a、b、c三个子节点，那么可以得出
    //yes_X_max = X.value + no_a_max + no_b_max + no_c_max
    //no_X_max = Max{no_a_max, yes_a_max} + Max{no_b_max, yes_b_max} + Max{no_c_max, yes_c_max}
    public static ReturnType process(Employee X){
        if (X == null)
            return new ReturnType(0, 0);
        int yesX = X.value;
        int noX = 0;
        if (X.subordinates.isEmpty())
            return new ReturnType(yesX, noX);
        for (Employee next : X.subordinates){
            ReturnType subTreeInfo = process(next);
            yesX += subTreeInfo.noHeadMax;
            noX += Math.max(subTreeInfo.yesHeadMax, subTreeInfo.noHeadMax);
        }
        return new ReturnType(yesX, noX);
    }

    public static int getMaxHappy(Employee boss){
        ReturnType allTreeInfo = process(boss);
        return Math.max(allTreeInfo.yesHeadMax, allTreeInfo.noHeadMax);
    }
}
