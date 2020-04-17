package arrayandmatrix.rotatearray;

//旋转矩阵
public class Solution {

    //顺时针旋转
    public static int[][] clockWiseRotate(int[][] input){
        int[][] output = new int[input[0].length][input.length];
        for (int  i = 0; i < output.length; i++){
            for (int j = 0; j < output[0].length; j++){
                output[i][j] = input[input.length - 1 - j][i];
            }
        }
        return output;
    }

    //逆时针旋转
    public static int[][] anticlockWiseRotate(int[][] input){
        int[][] output = new int[input[0].length][input.length];
        for (int i = 0; i < output.length; i++){
            for (int j = 0; j < output[0].length; j++){
                output[i][j] = input[j][input[0].length - 1 - i];
            }
        }
        return output;
    }

    //旋转180
    public static int[][] rotate180(int[][] input){
        int[][] output = new int[input.length][input[0].length];
        for (int i = 0; i < output.length; i++){
            for (int j = 0; j < output[0].length; j++){
                output[i][j] = input[input.length - 1 - i][input[0].length - 1 -j];
            }
        }
        return output;
    }

    //测试
    public static void main(String[] args) {
//        int[][] input = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//                {17, 18, 19, 20},
//        };

//        int[][] input = {
//                {1, 2, 3, 4, 9, 10},
//                {5, 6, 7, 8, 19, 23},
//                {9, 10, 11, 12, 31, 9},
//                {13, 14, 15, 16, 13, 12},
//                {17, 18, 19, 20, 8, 9},
//        };
//
//        int[][] input = {{1}};
//        int[][] input = {{1, 3, 4, 6}};
        int[][] input = {{1}, {2}, {3}, {4}};
        System.out.println("原矩阵:");
        print(input);
        System.out.println("顺时针旋转90度:");
        print(clockWiseRotate(input));
        System.out.println("逆时针旋转90度:");
        print(anticlockWiseRotate(input));
        System.out.println("旋转180度:");
        print(rotate180(input));
    }

    public static void print(int[][] input){
        for (int i = 0; i < input.length; i++){
            for (int j = 0; j < input[0].length; j++){
                System.out.print(input[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
