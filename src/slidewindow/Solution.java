package slidewindow;

//滑动窗口的相关题目
public class Solution {

    //题目一：最小覆盖子串,返回s中包含t中所有字符的最小长度的子串，注意t可能有重复字符
    public static String minCoverageSubString(String s, String t) {
        char[] need = new char[128];  //char数组用来记录t中某个字符出现的次数
        char[] window = new char[128];  //window数组表示当前窗口中包含的某个字符的次数

        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        for (char c : t_array) {
            need[c]++;
        }
        int k = getNumsOfNotZero(need);

        int left = 0, right = 0;  //维护一个左闭右开的窗口[left, right)
        int valid = 0;  //valid表示当前窗口中满足need要求的字符种类个数
        int start = 0, len = Integer.MAX_VALUE;  //start表示返回结果中第一个字符在s中的索引位置，len表示该子串的长度

        while (right < s_array.length) {
            char temp1 = s_array[right];
            right++;

            //更新操作
            if (need[temp1] != 0) {
                window[temp1]++;
                if (window[temp1] == need[temp1]) {
                    valid++;
                }
            }

            //判断左窗口是否要收缩
            while (valid == k) {
                //更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char temp2 = s_array[left];
                left++;

                //更新操作
                if (need[temp2] != 0) {
                    if (window[temp2] == need[temp2]) {
                        valid--;
                    }
                    window[temp2]--;
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" :s.substring(start, start + len);
    }

    //返回input数组中不为零的元素个数
    public static int getNumsOfNotZero(char[] input) {
        int res = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCoverageSubString("ADOBECODEBANC", "ABC"));
    }
}
