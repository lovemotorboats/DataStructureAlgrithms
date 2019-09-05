package linklist.ispalindrome;

import linklist.printcommonpart.Node;

import java.util.Stack;

//判断一个单链表是否为回文结构
public class Solution {
    //方法一：使用一个栈，将链表中的元素依次压入栈中，然后依次弹出与链表中的每个元素对比。
    // 该方法的时间复杂度为O(N)，空间复杂度为O(N)
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if (cur.value != stack.pop().value)
                return false;
            cur = cur.next;
        }
        return true;
    }

    //方法二：对方法一的改进，只压入整个链表的后半部分即可
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null)
            return true;
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null){
            cur = cur.next.next;
            right = right.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if (cur.value != stack.pop().value)
                return false;
            cur = cur.next;
        }
        return true;
    }
    //方法三：进阶方法，将空间复杂度缩减为O(1)，将链表右半区反转
}
