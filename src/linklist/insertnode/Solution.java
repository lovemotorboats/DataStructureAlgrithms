package linklist.insertnode;

import linklist.printcommonpart.Node;

//在有序的环形单链表中插入新的结点，仍然保证链表环形有序
public class Solution {
    public static Node insertNodeInCircleLinklist(Node head, int num){
        Node node = new Node(num);
        if (head == null){
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head){
            if (cur.value >= num && pre.value <= num)
                break;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value <= node.value ? head : node;
    }
}
