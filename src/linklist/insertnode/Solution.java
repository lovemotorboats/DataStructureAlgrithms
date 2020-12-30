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


    public static String minWindow(String s, String p) {
        //最小覆盖子串
        char[] need = new char[128];
        char[] window = new char[128];
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        for (int i = 0; i < p_arr.length; i++) {
            need[p_arr[i]]++;
        }
        int k = get(need);
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int left = 0, right = 0;  //左开右闭区间
        while (right < s_arr.length) {
            char rTemp = s_arr[right++];

            if (need[rTemp] != 0) {
                window[rTemp]++;
                if (window[rTemp] == need[rTemp]) {
                    valid++;
                }
            }

            //缩小区间
            while (valid == k) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }

                char lTemp = s_arr[left++];
                if (need[lTemp] != 0) {
                    if (window[lTemp] == need[lTemp]) {
                        valid--;
                    }
                    window[lTemp]--;
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static int get(char[] need) {
        int res = 0;
        for (int i = 0; i < need.length; i++) {
            if (need[i] != 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
