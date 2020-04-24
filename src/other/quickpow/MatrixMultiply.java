package other.quickpow;

public class MatrixMultiply {

    public static long[][] matrixMultiply(long[][] A, long[][] B){  //A的列数等于B的行数
        //求AB
        long[][] result = new long[A.length][B[0].length];
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++){
                long temp = 0;
                for (int k = 0; k < A[0].length; k++){
                    temp += A[i][k] * B[k][j];
                }
                result[i][j] = temp;
            }
        }
        return result;
    }
}
