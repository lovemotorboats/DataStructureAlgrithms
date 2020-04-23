package linklist.copylistwithrand;

import java.util.HashMap;

//完全复制一个每个结点都带有rand指针的链表
public class Solution {
    //方案一:使用哈希表的结构，这种方法的时间复杂度为O(N)，空间复杂度也为O(N)
    //1、遍历链表，复制每个结点生成副本结点，然后将对应关系放入到map中；
    //2、再次遍历链表，设置每一个副本结点的next、指针和rand指针
    public static NodeWithRand copyListWithRand1(NodeWithRand head){
        if (head == null)
            return head;
        HashMap<NodeWithRand, NodeWithRand> map =new HashMap<>();
        NodeWithRand cur = head;
        while (cur != null){
            map.put(cur, new NodeWithRand(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //方案二:遍历每个结点，生成其副本结点，并将副本结点放在其后面，然后再回来遍历链表
    //生成每个结点的next指针和rand指针，最后将副本结点分离出来即可，时间复杂度O（N），
    //空间复杂度O（1）
    public static NodeWithRand copyListWithRand2(NodeWithRand head){
        if (head == null)
            return head;
        NodeWithRand cur = head;
        NodeWithRand newNode = null;
        NodeWithRand cur1 = null;
        //NodeWithRand head1 = null;
        while (cur != null){
            newNode = new NodeWithRand(cur.value);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        //设置rand指针
        cur = head;
        while (cur != null){
            cur.next.rand = cur.rand.next;
            cur = cur.next.next;
        }
        //分离两个链表
        cur = head;
        cur1 = newNode = head.next;
        while (cur != null){
            cur.next = cur1.next;
            cur1.next = cur.next != null ? cur.next.next : null;
            cur = cur1.next;
            cur1 = cur1.next;
        }
        return newNode;
    }
}
