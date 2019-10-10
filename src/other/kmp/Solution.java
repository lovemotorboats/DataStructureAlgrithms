package other.kmp;

//字符串匹配问题KMP算法
public class Solution {
    //给定两个字符串str和match，实现一个算法，如果字符串str中含有子串match，则返回match
    //在str中开始的位置，不含有则返回-1
    //1、获取match的next数组
    //next[i]表示match[0]到match[i-1]中最长前缀子串和后缀子串匹配长度（前缀子串不包括
    // match[i-1]，后缀子串不包括match[0]）
    public static int[] getNextArray(char[] ms){
        if (ms == null || ms.length  == 0)
            return null;
        if (ms.length == 1)
            return new int[] {-1};
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length){
            if (ms[pos - 1] == ms[cn]){
                next[pos++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static int getIndexOf(String str,  String ms){
        //利用KMP算法求解ms在str中第一次出现的索引位置
        if (str == null || ms == null || ms.length() < 1 || str.length() < ms.length())
            return -1;  //不存在的情况
        char[] s = str.toCharArray();
        char[] m = ms.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(m);
        while (si < s.length && mi < m.length){
            if (s[si] == m[mi]){
                si++;
                mi++;
            }else if (next[mi] == -1){
                si++;
            }else {
                mi = next[mi];
            }
        }
        return mi == ms.length() ? si - mi : -1;
    }
}
