package linklist.removeallvalue;

import linklist.printcommonpart.Node;

import java.util.Stack;

//删除单链表中所有值为num的结点
public class Solution {
    //方法一：利用栈结构
    public static Node removeAllValue1(Node head, int num){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        //将所有值不等于num的结点全部压入栈中
        while (cur != null){
            if (cur.value != num)
                stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next = cur;
            cur = stack.pop();
        }
        return cur;
    }

    //方法二：不利用栈结构，直接在链表中进行删除
    public static Node removeAllValue2(Node head, int num){
        Node cur = head;
        while (cur != null){
            //找到第一个值不等于num的结点
            if (cur.value == num)
                break;
            cur = cur.next;
        }
        Node pre = cur;
        Node newHead = cur;
        while (cur != null){
            if (cur.value == num)
                pre.next = cur;
            else pre = cur;
            cur = cur.next;
        }
        return newHead;
    }
}
