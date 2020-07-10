package arrayandmatrix.maximumSwap;
/* 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * @description:
 * @author:liyang
 * @create:2020-07-09
 */

public class Solution {


    //思路错误
    public static int maximumSwap(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return num;
        }
        char[] s_array = s.toCharArray();
        int[] indexOfleftMaxFrom = new int[len];  //indexOfleftMaxFrom[i]表示从s_array[i]开始到末尾的最大值位置的索引
        indexOfleftMaxFrom[len - 1] = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            indexOfleftMaxFrom[i] = s_array[indexOfleftMaxFrom[i + 1]] < s_array[i] ? i : indexOfleftMaxFrom[i + 1];
        }

        for (int i = 0; i < len; i++) {
            if (s_array[indexOfleftMaxFrom[i]] != s_array[i]) {
                char temp = s_array[i];
                s_array[i] = s_array[indexOfleftMaxFrom[i]];
                s_array[indexOfleftMaxFrom[i]] = temp;
                break;
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = res * 10 + s_array[i] - '0';
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
        System.out.println(maximumSwap(1993));
    }
}
