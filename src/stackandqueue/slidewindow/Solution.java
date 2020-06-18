package stackandqueue.slidewindow;
/*
 * @description:主要利用滑动窗口、栈和队列思想来解决一些问题
 * @author:liyang
 * @create:2020-06-17
 */

import java.util.*;

public class Solution {

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        queue.offer(chars[0]);
        set.add(chars[0]);
        int res = 1;
        boolean flag = false;
        for (int i = 1; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                queue.offer(chars[i]);
                set.add(chars[i]);
                if (!flag) {
                    res++;
                }
            } else {
                flag = true;
                int currentLen = queue.size();
                while (queue.peek() != chars[i]) {
                    char ch = queue.poll();
                    set.remove(ch);
                }
                queue.poll();
                queue.offer(chars[i]);
                res = res < currentLen ? currentLen : res;
            }
        }
        res = res < queue.size() ? queue.size() : res;
        return res;
    }
}
