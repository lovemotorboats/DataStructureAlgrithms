package linklist.removelastkthnode;

import linklist.printcommonpart.Node;

//删除单链表和双链表的倒数第k个节点
//方案：从头节点开始，每移动一步就将k值减一，移动到链表末尾，如果k的值大于0说明k值大太，不存在倒数第k个节点；
//如果k的值等于0那么就头节点就是倒数第k个节点；如果k的值小于0，再从表头开始遍历，每移动一次k值加一，直到k等于0时的节点
//就是倒数第k个节点的前驱节点，进行删除操作即可
public class Solution {
    public static Node removeLastKthNodeOfSingleLinklist(Node head, int lastKth){
        if (head == null || lastKth < 1)
            return head;
        Node cur = head;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0)
            head = head.next;
        else if (lastKth <= 0){
            cur = head;
            while (++lastKth != 0)
                cur = cur.next;
            cur .next = cur.next.next;
        }
        return head;
    }

    //双链表的处理几乎和单链表一样，只是需要在删除节点时注意
    public static DoubleNode removeLastKthNodeOfDoubleLinklist(DoubleNode head, int lastKth){
        if (head == null || lastKth < 1)
            return head;
        DoubleNode cur = head;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0)
            return head.next;
        else if (lastKth < 0){
            cur = head;
            while (++lastKth != 0)
                cur = cur.next;
            cur.next = cur.next.next;
            if (cur.next != null)
                cur.next.last = cur;
        }
        return head;
    }
}
