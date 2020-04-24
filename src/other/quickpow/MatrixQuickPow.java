package other.quickpow;

import static other.quickpow.MatrixMultiply.matrixMultiply;

public class MatrixQuickPow {

    public static long[][] quickMatrixPowRecursion(long[][] a, long n) {  //矩阵快速幂乘法递归版 a必须是方阵
        if (n == 1) {
            return a;
        }
        if (n % 2 == 1) {
            return matrixMultiply(quickMatrixPowRecursion(a, n - 1),  a);
        } else {
            long[][] temp = quickMatrixPowRecursion(a, n / 2);
            return matrixMultiply(temp, temp);  //此处temp必不可少，不然会重新退化成O(n)
        }
    }

    public static long[][] quickMatrixPowNon_recursion(long[][] a, long n) {  //矩阵快速幂乘法非递归版 a必须是方阵
        if (n == 1) {
            return a;
        }
        long[][] ans = new long[a.length][a[0].length];
        long[][] temp = new long[a.length][a[0].length];
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[0].length; j++){
                ans[i][j] = i == j ? 1 : 0;
                temp[i][j] = a[i][j];
            }
        }
        while (n != 0) {
            if ((n & 1) != 0)        //如果n的当前末位为1
                ans = matrixMultiply(ans, temp);  //ans乘上当前的temp
            temp  =  matrixMultiply(temp, temp);        //temp自乘
            n >>= 1;       //n往右移一位
        }
        return ans;
    }
}
