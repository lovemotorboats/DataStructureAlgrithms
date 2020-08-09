package backtracing.generateParentThesis;


import java.util.ArrayList;
import java.util.List;

//括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class Solution {
    public static List<String> generateParenthesis(int n) {
        //回溯法：相当于在2n个位置放字符'('和')',不合法的时候就回溯
        //括号合法的两个性质:1、左括号数量等于右括号数量,等于n
        //2、任何0 <= i <= 2n，0到i的左括号数量大于等于右括号数量
        List<String> res = new ArrayList<>();
        backTrace(2 * n, 0, 0, 0, new StringBuilder(), res);
        return res;
    }

    public static void backTrace(int len, int left, int right, int now, StringBuilder sb, List<String> result) {
        //left表示已经使用的左括号数量，right表示已经使用的右括号数量
        if (left + right == len && left == right) {
            result.add(sb.toString());
            return;
        }
        if (left < right) {
            return;
        }
        if (now == len) {
            return;
        }
        //尝试左括号
        sb.append("(");
        now++;
        backTrace(len, left + 1, right, now, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        now--;

        //尝试右括号
        sb.append(")");
        now++;
        backTrace(len, left, right + 1, now, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        now--;

    }

    public static void main(String[] args) {
//        List<String> strings = generateParenthesis(4);
//        for (String string : strings) {
//            System.out.println(string);
//        }
//        System.out.println();
        String s = "AhndNJMNDhdhbaNDMh";
        char[] chars = s.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (char aChar : chars) {
            sb1.append((char)(aChar | ' '));
            sb2.append((char)(aChar & '_'));
            sb3.append((char)(aChar ^ ' '));
        }
        System.out.println("原：" + s);
        System.out.println("大写转小写" + sb1.toString());
        System.out.println("小写转大写" + sb2.toString());
        System.out.println("大小写互相转换" + sb3.toString());
    }
}
