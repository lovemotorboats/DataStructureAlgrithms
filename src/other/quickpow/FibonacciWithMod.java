package other.quickpow;

import static other.quickpow.MatrixMultiply.matrixMultiply;

//求Fibonacci数列的n项的值对MOD取余， （1 <= n <= 10 ^ 18）
//我们利用矩阵的快速幂运算优化计算速度
//要先求矩阵A的n-1次方，注意要步步取mod
public class FibonacciWithMod {

    public static final long MOD = (long)Math.pow(10, 9) + 7;  //取mod

    public static long fibonacciWithMod_1(long n){  //普通方法求mod
        if (n == 1 || n == 2){
            return 1;
        }
        long n_2 = 1, n_1 = 1;
        long result = n_2 + n_1;
        for (int i = 3; i <= n; i++){
            result = ((n_2 % MOD) + (n_1 % MOD)) % MOD;
            n_1 = n_2;
            n_2 = result;
        }
        return result % MOD;
    }

    public static long[][] matrixMultiplyWithMod(long[][] A, long[][] B){
        //求AB  步步取模
        long[][] result = new long[A.length][B[0].length];
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++){
                long temp = 0;
                for (int k = 0; k < A[0].length; k++){
                    temp += ((A[i][k] % MOD) * (B[k][j] % MOD)) % MOD;
                }
                result[i][j] = temp % MOD;
            }
        }
        return result;
    }

    public static long[][] quickMatrixPowWithMod(long[][] a, long n) {
        //矩阵快速幂非递归版
        if (n == 1) {
            return a;
        }
        long[][] ans = new long[a.length][a[0].length];  //单位阵
        long[][] temp = new long[a.length][a[0].length];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++){
                ans[i][j] = i == j ? 1 : 0;
                temp[i][j] = a[i][j];
            }
        }
        while (n != 0) {
            if ((n & 1) != 0)        //如果n的当前末位为1
                ans = matrixMultiplyWithMod(ans, temp);  //ans乘上当前的temp
            temp  =  matrixMultiplyWithMod(temp, temp);        //temp自乘
            n >>= 1;       //n往右移一位
        }
        return ans;
    }

    public static long fibonacciWithMod_2(long n){  //快速幂方法求mod
        if (n == 1 || n == 2){
            return 1;
        }
        long[][] A = {{0, 1}, {1, 1}};
        long[][] B = {{1}, {1}};
        long[][] result = matrixMultiply(quickMatrixPowWithMod(A, n - 1), B);
        return result[0][0] % MOD;
    }

    public static void main(String[] args) {  //测试
        long n = 300000000l;
//        long start = System.currentTimeMillis();
//        System.out.println(fibonacciWithMod_1(n));
//        long end = System.currentTimeMillis();
//        System.out.println("普通方法求斐波那契数列的第" + n + "项对" + MOD +"取模共耗时"+(end-start)+"毫秒");
        long start = System.currentTimeMillis();
        System.out.println(fibonacciWithMod_2(n));
        long end = System.currentTimeMillis();
        System.out.println("快速幂方法求斐波那契数列的第" + n + "项对" + MOD +"取模共耗时"+(end-start)+"毫秒");
    }
}
