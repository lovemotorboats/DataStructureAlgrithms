package linklist.printcommonpart;

//给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
//由于是有序的，所以对head1和head2开始进行向后遍历，谁小就谁就往后移动，相等就打印出来
public class Solution {
    public static void printCommonPart(Node head1, Node head2){
        while (head1 != null && head2 !=null){
            if (head1.value < head2.value)
                head1 = head1.next;
            else if (head1.value > head2.value)
                head2 = head2.next;
            else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
