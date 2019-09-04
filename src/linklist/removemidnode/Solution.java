package linklist.removemidnode;

import linklist.printcommonpart.Node;

//删除一个单链表的中间节点，当链表长度为1时不删除，链表长度不为1时，删除第(length+1)/2个节点
public class Solution {
    //每增加两个节点就往后移动一个
    public static Node removeMidNode(Node head){
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null)
            //链表长度为2时删除第一个节点
            return head.next;
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    //删除链表的第a/b处的节点（如果不为整数就向上取整）
    public static Node removeByRatio(Node head, int a, int b){
        if (a < 1 || a > b)
            return head;
        int n = 0;
        Node cur = head;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil((double)(a * n) / (double)b);
        if (n == 1)
            head = head.next;
        if (n > 1){
            cur = head;
            while (--n != 1)
                cur = cur.next;
            cur.next = cur.next.next;
        }
        return head;
    }
}
