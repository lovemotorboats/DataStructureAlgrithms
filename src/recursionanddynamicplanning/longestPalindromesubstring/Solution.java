package recursionanddynamicplanning.longestPalindromesubstring;


//最长回文子串
public class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            String s1 = getPalindrome(s, i, i);
            String s2 = getPalindrome(s, i, i+1);
            if (s1.length() > res.length()) {
                res = s1;
            }
            if (s2.length() > res.length()) {
                res = s2;
            }
        }
        return res;
    }

    public static String getPalindrome(String s, int l, int r) {
        int len = s.length();
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        String res = longestPalindrome("babad");
    }
}
