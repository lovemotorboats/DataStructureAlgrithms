package other.zeronum;

//有关阶乘的两个问题
public class Solution {
    //问题1：给定一个非负整数N，返回N！结果的末尾0的数量，比如3！=6，末尾0的数量为0；
    //5！=120，末尾0的数量为1.
    //分析：末尾有多少个0就要看有多少个10相乘，10又相当于2和5相乘，又因为N！中因子2比5多，
    //那么原问题就变成了N！中有多少个因子5。
    //方法一：
    public static int zeroNum1(int n){
        if (n < 0){
            return 0;
        }
        int res = 0, cur = 0;
        for (int i = 5; i < n + 1; i += 5){
            cur = i;
            while (cur % 5 == 0){
                res++;
                cur /= 5;
            }
        }
        return res;
    }

    //方法二：
    public static int zeroNum2(int n){
        if (n < 0){
            return 0;
        }
        int res = 0;
        while (n != 0){
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    //问题2：给定一个非负整数n，如果用二进制表达n！的结果，返回最低位的1在哪个位置上(最右为0)
    //分析：最低位的1在哪个位置上，完全取决于1到N的数中因子2有多少个，因为只要出现一个因子2，最低位
    //的1就会左移一位
    public static int rightOne(int n){
        if (n < 1){
            return -1;
        }
        int res = 0;
        while (n != 0){
            n >>>= 1;
            res += n;
        }
        return res;
    }
}
