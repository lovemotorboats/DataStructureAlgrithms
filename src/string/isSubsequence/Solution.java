package string.isSubsequence;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
// 而 s 是个短字符串（长度 <=100）。字符串的一个子序列是原始字符串删除一些（也可以不删除）
// 字符而不改变剩余字符相对位置形成的新字符串。
// （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

class Solution {
    public boolean isSubsequence(String s, String t) {
        //遍历s的每一个字符，寻找在t中是否依次存在，如果都存在，就返回true，否则返回false
        if (s == null || t == null){
            return false;
        }
        if (s.length() == 0){
            return true;
        }
        int i = 0;
        for (char ch : s.toCharArray()){
            while(i < t.length() && ch != t.charAt(i))
                i++;
            i++;
            if (i > t.length()){
                return false;
            }
        }
        return true;
    }
}

class NumArray {

    private int[] nums;
    private int len;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i; k <= j && k < len; k++){
            sum += this.nums[k];
        }
        return sum;
    }
}

