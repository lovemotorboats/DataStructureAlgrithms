package string.calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//层层递进，实现一个简易计算器功能
public class Solution {

    //普通没有
    private static int calculate(String s){
        LinkedList<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        boolean hasAsign = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' '){
                continue;
            }
            if (!('0' <= c && c <= '9') && c != '+' && c != '-' && c != '*' && c != '/'){
                throw new IllegalArgumentException();
            }
            // 如果是数字，连续读取到 num
            if ('0' <= c && c <= '9'){
                num = 10 * num + (c - '0');
                hasAsign = false;
            }
            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if (!('0' <= c && c <= '9') || i == chars.length - 1) {
                if (!('0' <= c && c <= '9') && i == chars.length - 1) {
                    throw new IllegalArgumentException();
                }
                if (hasAsign) {
                    throw new IllegalArgumentException();
                }
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                hasAsign = true;
                num = 0;
            }
        }
        // 将栈中所有结果求和就是答案
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    //判断一个加减乘除带括号的表达式是不是一个合法的算数表达式
    private static boolean isValid(String s) {
        String replace = s.replace(" ", "");//去掉所有空格
        System.out.println(replace);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("1 - 2 * 3 -"));
    }
}
