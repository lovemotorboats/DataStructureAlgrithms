package linklist.reverseKNode;

import linklist.printcommonpart.Node;

import java.util.Stack;

//将单链表每k个结点一组进行逆序
public class Solution {
    public static Node reverseKNode1(Node head, int k){
        //方法一：利用栈结构
        if (k < 2 || head == null || head.next == null)
            return head;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node newHead = null;
        Node pre = null;
        Node node = null;
        int n = 0;
        while (cur != null){
            if (n++ != k){
                stack.push(cur);
                cur = cur.next;
            }else {
                if (newHead == null){
                    newHead = stack.pop();
                    pre = newHead;
                }
                while (!stack.isEmpty()){
                    node = stack.pop();
                    pre.next = node;
                    pre = node;
                }
                n = 0;
            }
        }
        if (newHead != null){
            while (!stack.isEmpty()){
                node = stack.pop();
                pre.next = node;
                pre = node;
            }
        }else {
            newHead = stack.pop();
            pre = newHead;
            while (!stack.isEmpty()){
                node = stack.pop();
                pre.next = node;
                pre = node;
            }
        }
        pre.next = null;
        return newHead;
    }

    //方法二：不利用栈，直接在链表中调整
    public static Node reverseKNode(Node head, int k){
        if (k < 2 || head == null || head.next == null){
            return head;
        }
        Node cur = head;
        Node pre = null;
        Node next = cur.next;
        Node last1 = null;
        Node last = head;
        int n = 0;
        Node newHead = null;
        while (cur != null){
            if (n++ != k) {
                cur.next = pre;
                pre = cur;
                if (pre.next == null)
                    last1 = pre;
                cur = next;
                if (cur != null)
                    next = cur.next;
            }else {
                if (newHead == null)
                    newHead = pre;
                if (pre != newHead)
                    last.next = pre;
                last = last1;
                n = 0;
                pre = null;
            }
        }
        if (n != 0){
            if (newHead != null)
                last.next = pre;
            else newHead = pre;
        }
        return newHead;
    }
}
