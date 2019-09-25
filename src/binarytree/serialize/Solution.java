package binarytree.serialize;

import binarytree.travel.Node;

import java.util.LinkedList;
import java.util.Queue;

//对二叉树进行序列化和反序列化
public class Solution {
    //方法一、利用先序遍历对二叉树进行序列化和反序列化
    //通过先序遍历来序列化二叉树，首先初始化序列化结果为str=""，先序遍历二叉树，如果遇到
    //null结点，就在str的末尾加上#!，#表示这个结点为空，！表示一个值的结束；如果遇到不为null
    //的结点，假设结点值为3，就在str后面加上3！
    public String serialByPre(Node head){
        if (head == null)
            return "#!";
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    //对先序遍历生成的序列化字符串进行反序列化
    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++)
            queue.offer(values[i]);
        return reconPreOrder(queue);
    }

    public static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#"))
            return null;
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    //方法二、利用层序遍历对二叉树进行序列化和反序列化
    public static String serialByLevel(Node head){
        if (head == null)
            return "#!";
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();  //层序遍历需要用到队列
        Node cur = head;
        queue.offer(cur);
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur.left != null){
                res += cur.left.value + "!";
                queue.offer(cur.left);
            }else
                res += "#!";
            if (cur.right != null){
                res += cur.right.value + "!";
                queue.offer(cur.right);
            }else
                res += "#!";
        }
        return res;
    }

    //层序遍历结果反序列化
    public static Node reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            if (node.left != null)
                queue.offer(node.left);
            node.right = generateNodeByString(values[index++]);
            if (node.right != null)
                queue.offer(node.right);
        }
        return head;
    }

    public static Node generateNodeByString(String val){
        if (val.equals("#"))
            return null;
        return new Node(Integer.valueOf(val));
    }
}
