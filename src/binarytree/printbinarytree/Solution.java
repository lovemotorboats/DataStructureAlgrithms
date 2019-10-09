package binarytree.printbinarytree;

import binarytree.travel.Node;

import java.util.LinkedList;
import java.util.Queue;

//二叉树打印
public class Solution {
    //按二叉树的层序方式打印每个结点，每一层需要换行并打印出当前行号
    //需要用到两个变量last和nlast，其中last表示当前打印结点所在行的最右一个结点，nlast
    //表示下一行最右的结点。nlast等于目前加入到队列中的最新结点，当遍历到last结点时就
    //更新last使其等于nlast，并且换行打印即可
    public static void printByLevel(Node head){
        if (head == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        Node last = head;
        Node nlast = null;
        Node node = head;
        int level = 1;
        queue.offer(node);
        System.out.print("level_" + (level++) + " : ");
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null){
                queue.offer(node.left);
                nlast = node.left;
            }
            if (node.right != null){
                queue.offer(node.right);
                nlast = node.right;
            }
            if (node == last && !queue.isEmpty()){
                System.out.print("\nlevel_" + (level++) + " : ");
                last = nlast;
            }
        }
    }

    //按Zigzag方式打印二叉树

}
