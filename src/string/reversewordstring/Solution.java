package string.reversewordstring;

public class Solution {
    //给定一个字符串，在单词层面上反转字符串（单词就是一串连续的非空字符）
    //思想：先反转整个字符串，再依次对每个单词进行二次反转
    public static void rotateWord(char[] chas){
        if (chas == null || chas.length == 0)
            return;
        reverse(chas, 0, chas.length - 1);
        int left = -1;
        int right = -1;
        for (int i = 0; i < chas.length; i++){
            if (chas[i] != ' '){
                if (i == 0 || chas[i - 1] == ' ')
                    left = i;
                if (i == chas.length - 1 || chas[i + 1] == ' ')
                    right = i;
            }
            if (left != -1 && right != -1){
                reverse(chas, left, right);
                left = -1;
                right = -1;
            }
        }
    }

    public static void reverse(char[] chas, int start, int end){
        char tem = ' ';
        while (start < end){
            tem = chas[start];
            chas[start] = chas[end];
            chas[end] = tem;
            start++;
            end--;
        }
    }

    //给定一个字符类型数组chas和一个整数size，把大小为size的左半区整体移动到右边
    //把右半区移动到左边
    public static void rotate(char[] chas, int size){
        if (chas == null || size <= 0 || size >= chas.length)
            return;
        reverse(chas, 0, size - 1);
        reverse(chas, size, chas.length - 1);
        reverse(chas, 0, chas.length - 1);
    }
}
