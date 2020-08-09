package bit.diabolictricks;

//一些常用的位操作的奇技淫巧
public class Solution {

    //1、大写字母转小写 A | ' ' = a;
    //2、小写字母转大写 a & '_' = A;
    //3、大小写互换 a ^ ' ' = A; A ^ ' ' = a;
    //4、判断两数是否异号 a ^ b < 0
    //5、交换a和b  a = a ^ b; b = a ^ b; a = a ^ b
    //6、消除n的二进制表示中最后一个1  n & (n - 1)

    //计算一个数的二进制表示中含有1的个数
    public int hanmingWeight(int n) {  //用到第六条
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    //判断一个数是不是2的指数
    public boolean isPowerOfTow(int n) {  //用到第六条
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
