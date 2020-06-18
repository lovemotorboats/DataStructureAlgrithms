package unionfind.findCircleNum;
/*
 * @description:
 * @author:liyang
 * @create:2020-06-17
 */

import unionfind.UnionFind;

public class Solution {
    /*
     * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，
     * B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
     * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生
     * 互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
     * */
    public static int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int res = 0;
        //遍历unionFind，查找祖宗为自己的节点的个数，就是朋友圈个数
        for (int i = 0; i < len; i++) {
            if (unionFind.parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(M));
    }
}
