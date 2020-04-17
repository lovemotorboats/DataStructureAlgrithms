package backtracing.eightqueen;

//经典的八皇后问题
//在8*8的棋盘上放置8位皇后，各个皇后不能在同一行、同一列和同一条斜线上，总共有多少种放法

public class Solution {
    //思路：使用回溯的方法进行试探
    //依次从在每一行放置皇后，试探放置皇后是否合法，如果不合法就回到上一个回溯点重新试探，直到试探
    //到每一行都有一个皇后就能将种数累加1。相当于图的深度优先和树的后序遍历

    //判断当前行的皇后位置是否合法
    public static int result = 0;

    public static boolean isOk(int row, int[] queen){  //row代表当前放置的皇后行数，queen[i]代表第i行皇后所在
        //的列数
        boolean flag = true;
        for (int i = 0; i < row; i++){
            if (queen[row] == queen[i] || queen[row] - row == queen[i] - i || queen[row] + row == queen[i] + i){
                //当前行的皇后与之前放置的皇后在同一列或者同一斜线
                flag = false;
                break;
            }
        }
        return flag;
    }

    //核心方法，递归
    public static void backTracing(int row, int max, int[] queen){
        if (row == max){
            result++;
            return;
        }
        for (int col = 0; col < max; col++){
            queen[row] = col;
            if (isOk(row, queen)){
                backTracing(row + 1, max, queen);
            }
        }
    }

    public static void main(String[] args) {
        //主方法测试
        for (int i = 1; i < 10; i++){
            int[] queen = new int[i];
            backTracing(0,  i, queen);
            System.out.println(i + "皇后问题的解法" + result + "种");
            result = 0;
        }
    }
}
