package backtracing.eightqueen;

import java.util.ArrayList;
import java.util.List;

//打印N皇后问题的方式
class PrintSolution {

    private static int sum = 0;

    public static List<List<String>> solveNQueens(int n) {
        //使用回溯法解决八皇后问题
        int[] queen = new int[n];  //queen[i]表示第i行中的皇后所在的列数（行数列数都从0开始计数）
        List<List<String>> result = new ArrayList<>();
        backTracing(0, n, queen, result);
        System.out.println("总共有" + sum + "种摆放方式");
        return result;
    }

    public static boolean isOk(int[] queen, int row, int col) {  //判断将第row行的皇后摆在第col列的位置，是否合法
        for (int i = 0; i < row; i++) {
            if (queen[i] == col || queen[i] - col == i - row || queen[i] - col == row - i) {
                //此位置的皇后与前面的皇后同列或者同斜线
                return false;
            }
        }
        return true;
    }

    public static void backTracing(int now, int n, int[] queen, List<List<String>> result) {
        if (now == n) {
            List<String> newResult = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (queen[i] == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                newResult.add(sb.toString());
            }
            result.add(newResult);
            sum++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int temp = i;
            if (isOk(queen, now, temp)) {
                queen[now] = temp;
                backTracing(now + 1, n, queen, result);
            }
        }
    }

    public static void printResult(List<List<String>> results) {
        int i = 1;
        for (List<String> result : results) {
            System.out.println("第" + i++ + "种方式为：");
            for (String s : result) {
                System.out.println(s);
            }
            System.out.println("========================");
        }
    }

    public static void main(String[] args) {
        printResult(solveNQueens(4));
    }
}
