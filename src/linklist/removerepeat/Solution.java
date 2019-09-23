package linklist.removerepeat;

import linklist.printcommonpart.Node;

import java.util.HashSet;

//删除单链表中重复的结点，每种重复的值只留一个
public class Solution {
    //方法一：使用hash表，时间复杂度O(N)，空间复杂度O(N)
    public static void removeRepeatNode1(Node head){
        if (head == null || head.next == null)
            return;
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null){
            if (set.contains(cur.value))
                pre.next = cur;
            else set.add(cur.value);
            cur = cur.next;
        }
    }

    //方法二：利用选择排序的思想，时间复杂度为O(N)，空间复杂度为O(1)
    public static void removeRepeatNode2(Node head){
        if (head == null || head.next == null)
            return;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            pre = cur;
            next = cur.next;
            while (next != null){
                if (cur.value == next.value)
                    pre.next = cur;
                else pre = next;
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
