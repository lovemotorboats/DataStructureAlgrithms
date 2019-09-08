package linklist.listpartion;

import linklist.printcommonpart.Node;

//将单链表按某值划分成左边小，中间相等，右边大的形式
public class Solution {
    //方案一：借助一辅助数组，先将顺序排好再重新连接，空间复杂度为O(N)，这种方案
    //不能保证每一部分内部按原链表的顺序排列
    public static Node listPartition1(Node head, int pivot){
        if (head == null)
            return head;
        int len = 0;
        Node cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[len];
        cur = head;
        for (int i = 0; i < len; i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (int i = 0; i < len - 1; i++)
            nodeArr[i].next = nodeArr[i+1];
        nodeArr[len - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big){
            if (nodeArr[index].value < pivot)
                swap(nodeArr, ++small, index++);
            else if (nodeArr[index].value == pivot)
                index++;
            else swap(nodeArr, --big, index);
        }
    }

    public static void swap(Node[] nodeArr, int a, int b){
        Node temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }

    //方案二：将原链表中的所有结点依次划分成三个链表，三个链表分别为small代表左边部分，
    //equal代表中间部分，big代表右边部分，然后将small、equal和big依次连接起来即可。空间
    //复杂度为O(1)
    public static Node listPartition2(Node head, int pivot){
        Node sH = null;  //small的头
        Node sT = null;  //small的尾
        Node eH = null;  //equal的头
        Node eT = null;  //equal的尾
        Node bH = null;  //big的头
        Node bT = null;  //big的尾
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sT == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = sT.next;
                }
            }else if (head.value == pivot){
                if (eT == null){
                    eH = head;
                    eT = head;
                }else {
                    eH.next = head;
                    eH = eH.next;
                }
            }else {
                if (bT == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = next;
        }
        //small和equal重新连接
        if (sT != null){
            sT.next = eH;
            eT = eT == null? sT : eT;
        }
        //和big连接
        if (eT != null)
            eT.next = bH;
        return sH != null? sH : eH != null? eH : bH;
    }
}
