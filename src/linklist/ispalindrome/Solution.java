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
    public static boolean isPalindrome3(Node head){
        //2019.9.5 22:11 代码未检验
        if (head == null || head.next == null)
            return true;
        Node cur = head;
        Node right = head.next;  //right指向的是要反转部分的第一个节点
        Node rightPre = head;  //rightPre指向的是right的前一个结点
        Node head1 = null;
        Node cur1 = null;
        while (cur.next != null && cur.next.next != null){
            cur = cur.next.next;
            right = right.next;
            rightPre = rightPre.next;
        }
        rightPre.next = null;  //斩断前后两段
        //反转right及后面的节点
        head1 = linklist.reverselinklist.Solution.reverseSingleLinklist(right);
        cur1 = head1;
        cur = head;
        while (cur1 != null){
            if (cur1.value != cur.value){
                //需要将链表还原
                head1 = linklist.reverselinklist.Solution.reverseSingleLinklist(head1);
                rightPre.next = head1;
                return false;
            }
            cur = cur.next;
            cur1 = cur1.next;
        }
        //也需要将链表还原
        head1 = linklist.reverselinklist.Solution.reverseSingleLinklist(head1);
        rightPre.next = head1;
        return true;
    }
}
