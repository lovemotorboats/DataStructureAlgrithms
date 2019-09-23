package linklist.selectionsort;

import linklist.printcommonpart.Node;

//对单链表进行选择排序
public class Solution {
    public static Node getSmallestPreNode(Node head){
        //返回链表中最小结点的前驱节点，没有则返回null
        if (head == null || head.next == null)
            return null;
        Node smallestPre = null;
        Node smallest = head;
        Node cur = head.next;
        Node pre = head;
        while (cur != null){
            if (cur.value < smallest.value){
                smallest = cur;
                smallestPre = pre;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return smallestPre;
    }

    //对单链表进行选择排序
    public static Node selectionSort(Node head){
        if (head == null || head.next == null)
            return head;
        Node tail = null;  //已经排好序部分的末尾结点
        Node cur = head;  //未排好序部分的头节点
        Node smallest = null;
        Node smallestPre = null;
        while (cur != null){
            smallest = cur;
            smallestPre = getSmallestPreNode(cur);
            if (smallestPre != null){
                smallest = smallestPre.next;
                smallestPre.next = smallest.next;
            }
            cur = cur == smallest ? cur.next : cur;
            if (tail == null)
                head = smallest;
            else tail.next = smallest;
            tail = smallest;
        }
        return head;
    }
}
