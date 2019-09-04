package linklist.reverselinklist;

import linklist.printcommonpart.Node;
import linklist.removelastkthnode.DoubleNode;

//逆序单链表和双链表，比较简单，直接采用头插法
public class Solution {
    public static Node reverseSingleLinklist(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }

    public static DoubleNode reverseDoubleLinklist(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
