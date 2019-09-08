package linklist.addlists;

import linklist.printcommonpart.Node;

import java.util.Stack;

//将两个链表代表的数相加形成新的链表
public class Solution {
    //方案一：利用两个栈作为辅助
    public static Node addLists1(Node head1, Node head2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Node cur1 = head1;
        Node cur2 = head1;
        while (cur1 != null){
            stack1.push(cur1.value);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            stack2.push(cur2.value);
            cur2 = cur2.next;
        }
        int ca = 0;  //表示进位
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node next = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            ca = n / 10;  //进位
            node = new Node(n % 10);
            node.next = next;
            next = node;
        }
        if (ca == 1){
            node = new Node(1);
            node.next = next;
        }
        return node;
    }

    //方法二：不用栈，直接将链表逆序，可以节省栈空间
}
