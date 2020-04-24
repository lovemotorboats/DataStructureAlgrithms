package other.quickpow;

//问题描述：求解一个整数a的整数n次方(a >= 0, n >= 0 且a和n不同时为0)
public class IntegerQuickPow {

    //常规方法
    public static long normalPow(int a, int n) {
        if (a == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }

    //快速幂递归版
    //                                = a * recursionPow(a, n - 1), (n % 2 == 1时)
    //根据二分思路，recursionPow(a, n) = recursionPow(a, n / 2) * recursionPow(a, n / 2), (n % 2 == 0 && n != 0)
    //                                = 1, (n == 0)
    public static long quickPowRecursion(int a, int n) {
        if (a == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return quickPowRecursion(a, n - 1) * a;
        } else {
            long temp = quickPowRecursion(a, n / 2);
            return temp * temp;  //此处temp必不可少，不然会重新退化成O(n)
        }
    }

    //快速幂非递归版
    public static long quickPowNon_recursion(int a, int n) {
        if (a == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long ans = 1;
        while (n != 0) {
            if ((n & 1) != 0)        //如果n的当前末位为1
                ans *= a;  //ans乘上当前的a
            a *= a;        //a自乘
            n >>= 1;       //n往右移一位
        }
        return ans;
    }
}
