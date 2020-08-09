package stackandqueue.calculator;

import java.util.LinkedList;

//实现一个只有加减乘除和空格数字的简易计算器
public class Solution {
    public static int calculate(String s) {
        //利用两个栈，一个用于存数字，另一个存运算符
        char[] s_arr = s.trim().toCharArray();  //去掉前后的空格
        int len = s_arr.length;
        LinkedList<Integer> digitQueue = new LinkedList<>();  //双端队列，存数
        LinkedList<Character> charQueue = new LinkedList<>();   //双端队列，存运算符

        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {  //最后一个字符，一定是数字
                cur = cur * 10 + s_arr[i] - '0';
                if (!charQueue.isEmpty()) {
                    if (charQueue.getLast() == '*') {
                        charQueue.removeLast();
                        int num1 = digitQueue.removeLast();
                        digitQueue.addLast(num1 * cur);
                        break;
                    } else if (charQueue.getLast() == '/') {
                        charQueue.removeLast();
                        int num1 = digitQueue.removeLast();
                        digitQueue.addLast(num1 / cur);
                        break;
                    }

                }
                digitQueue.addLast(cur);
            } else {  //不是最后一个字符，
                if (s_arr[i] < '0' || s_arr[i] > '9') {  //非数字
                    if (s_arr[i] == ' ') {
                        continue;
                    }
                    digitQueue.addLast(cur);
                    cur = 0;
                    if (!charQueue.isEmpty()) {
                        if (charQueue.getLast() == '*') {
                            charQueue.removeLast();
                            int num2 = digitQueue.removeLast();
                            int num1 = digitQueue.removeLast();
                            digitQueue.addLast(num1 * num2);
                        } else if (charQueue.getLast() == '/') {
                            charQueue.removeLast();
                            int num2 = digitQueue.removeLast();
                            int num1 = digitQueue.removeLast();
                            digitQueue.addLast(num1 / num2);
                        }
                    }
                    charQueue.addLast(s_arr[i]);
                } else {  //数字
                    cur = cur * 10 + s_arr[i] - '0';
                }
            }
        }

        while (!charQueue.isEmpty()) {  //后算加减
            char ch = charQueue.removeFirst();
            int num1 = digitQueue.removeFirst();
            int num2 = digitQueue.removeFirst();
            if (ch == '+') {  //先算乘除
                digitQueue.addFirst(num1 + num2);
            } else if (ch == '-') {
                digitQueue.addFirst(num1 - num2);
            }
        }

        return digitQueue.removeFirst();
    }
}
