package binarytree.postarray;

import binarytree.travel.Node;

//给定一个整型数组arr，没有重复值，判断arr有没有可能是某颗搜索二叉树后续遍历的结果
public class Solution {
    //根据二叉树后序遍历和搜索二叉树的性质可知，arr的最后一个元素一定是二叉树的根节点
    //并且，左子树的所有结点都在数组arr的左边部分，右子树的结点都在右边部分
    //所以数组一定会被分成两部分，左边部分都小于最后一个结点，右边部分都大于最后一个结点
    //并且递归满足此条件
    public static boolean isPostArray(int[] arr){
        if (arr == null || arr.length == 0)
            return false;
        return isPost(arr, 0, arr.length - 1);
    }

    public static boolean isPost(int[] arr, int start, int end){
        if (start == end)
            return true;
        int less = -1;  //在arr[start]至arr[end - 1]中最后一个大于arr[end]的结点索引
        int more = end;  //...........................第一个小于arr[end]的结点索引
        for (int i = start; i < end; i++){
            if (arr[end] > arr[i]){
                less = i;  //注意是最后一个大于
            }else {
                more = more == end ? i : more;  //注意是第一个小于
            }
        }
        if (less == -1 || more == end){
            //重要的一点
            //所有结点都比arr[end]小或者都比arr[end]大，说明没有左子树或者右子树
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1)
            return false;
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }

    //进阶问题：arr是一个没有重复值的数组，并且是一颗搜索二叉树的后序遍历结果，
    //请通过arr重构二叉树
    public static Node posArrayToBST(int[] posArr){
        if (posArr == null || posArr.length == 0)
            return null;
        return posToBST(posArr, 0, posArr.length - 1);
    }

    public static Node posToBST(int[] posArr, int start, int end){
        if (start > end)
            return null;
        Node head = new Node(posArr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++){
            if (posArr[end] > posArr[i]){
                less = i;
            }else {
                more = more == end ? i : more;
            }
        }
        head.left = posToBST(posArr, start, less);
        head.right = posToBST(posArr, more, end - 1);
        return head;
    }
}
