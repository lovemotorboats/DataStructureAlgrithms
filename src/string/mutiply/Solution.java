package string.mutiply;
/*
 * @description:字符串乘法
 * @author:liyang
 * @create:2020-06-23
 */

//模拟乘法（输入两个字符串代表的整数，可能会特别大，计算这两个数的乘积）
public class Solution {

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        char[] num1_array = num1.toCharArray();
        char[] num2_array = num2.toCharArray();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1_array[i] - '0') * (num2_array[j] - '0');
                //乘积在res对应的索引位置
                int p1 = i + j, p2 = i + j + 1;
                //叠加到res上
                int sum = mul + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        //结果前缀可能存在0
        int index = 0;
        while (index < res.length && res[index] == 0) {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (; index < res.length; index++) {
            sb.append(res[index]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("1236351124545452212121552856894212125", "2342735121244525451221545451212154545"));
    }
}
