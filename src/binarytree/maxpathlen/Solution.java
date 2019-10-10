package binarytree.maxpathlen;

import binarytree.travel.Node;

import java.util.HashMap;

//在二叉树中找到累加和为指定值的最长路径的长度
public class Solution {
    //给定一颗二叉树和一个整型数sum，求累加和为sum的最长路径的长度
    //本题可利用“在数组中找等于某个值的子数组中最长的子数组的长度”题目的思想
    //进行改写
    public static int getMaxLen(Node head, int sum){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        return preOrder(head, sum, 0, 1, 0, map);
    }

    public static int preOrder(Node head, int sum, int preSum, int level,
                               int maxLen, HashMap<Integer, Integer> map){
        //参数说明：
        //head：树的根节点
        //preSum：从head到cur的父节点的路径中所有结点的值的累加和
        //level：cur所在层数
        //maxLen：所求，需进行更新
        //map<key, value>：key代表从head到当前cur的路径中出现过的的所有累加和
        //value代表key在该路径中第一次出现的层数
        if (head == null)
            return maxLen;
        int curSum = preSum + head.value;
        if (!map.containsKey(curSum))
            map.put(curSum, level);
        if (map.containsKey(curSum - sum))
            maxLen = Math.max(maxLen, level - map.get(curSum - sum));
        maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, map);
        maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, map);
        if (level == map.get(curSum))
            map.remove(curSum);  //要切换到右边兄弟结点了，所以要把左边结点加入到map
        //的数据删除，因为左边兄弟不在head到右边兄弟的路径上
        return  maxLen;
    }
}
