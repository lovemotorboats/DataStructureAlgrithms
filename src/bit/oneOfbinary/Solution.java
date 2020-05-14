package bit.oneOfbinary;

//整数的二进制表达中1的个数
public class Solution {
    //方法一：循环右移32次
    public static int count1(int n){
        int res = 0;
        while (n != 0){
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    //方法二：经过与1的个数有关次循环
    public static int count2(int n){
        int res = 0;
        while (n != 0){
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
