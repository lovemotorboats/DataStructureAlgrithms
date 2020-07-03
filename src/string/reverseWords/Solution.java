package string.reverseWords;
/*
 * @description:给定一个字符串，逐个翻转字符串中的每个单词。
 * @author:liyang
 * @create:2020-07-03
 */


//无空格字符构成一个单词。
//输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
public class Solution {

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "";
        }
        char[] s_array = s.toCharArray();
        int len = s.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {  //先将整个字符串反转
            char temp = s_array[i];
            s_array[i] = s_array[j];
            s_array[j] = temp;
        }

        //然后依次反转单词
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < len && s_array[i] == ' ') {  //找到第一个非空格字符的位置
            i++;
        }
        if (i == len) {
            return "";  //全部都是空格
        }
        j = i;
        while (i < len && j < len) {
            while (j < len && s_array[j] != ' ') {  //找到第一个空格
                j++;
            }
            sb.append(" "); //只在单词之间添加一个空格
            for (int index = j - 1; index >= i; index--) {
                sb.append(s_array[index]);
            }
            i = j + 1;
            while (i < len && s_array[i] == ' ') { //找到第一个非空格
                i++;
            }
            j = i;
        }

        sb.deleteCharAt(0);  //删除最前面的空格
        return sb.toString();

    }
}
