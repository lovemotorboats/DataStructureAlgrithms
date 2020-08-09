package bfs.slidingpuzzle;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
//一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
//最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
//给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
public class Solution {

    public static int slidingPuzzle(int[][] board) {
        //将二维数组预处理成一维字符数组,利用bfs套路，
        //直到将一维数组转换成{1, 2, 3, 4, 5, 0}这个目标数组就可以了

        //neighbor[i]表示与索引i相邻的索引位置有哪些
        int[][] neighbor = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }

        int step = 0;
        queue.offer(sb.toString());
        visited.add(sb.toString());

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String pop = queue.pop();

                if (pop.equals(target)) {
                    return step;
                }

                //先找到'0'的位置
                int index_0 = 0;
                for (; index_0 < pop.length(); index_0++) {
                    if (pop.charAt(index_0) == '0') {
                        break;
                    }
                }
                //'0'与周围的数字交换
                for (int i1 : neighbor[index_0]) {
                    String temp = swap(pop, index_0, i1);
                    if (!visited.contains(temp)) {
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    //不改变source，交换source中索引i和j的位置，返回一个新的数组
    public static String swap(String source, int i, int j) {
        char[] chars = source.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(slidingPuzzle(board));
    }
}
