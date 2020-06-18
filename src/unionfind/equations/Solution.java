package unionfind.equations;

import unionfind.UnionFind;

public class Solution {

    /*
     * @description:给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
     * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
     * @author:liyang
     * @create:2020-06-17
     */
    public static boolean equationsPossible(String[] equations){
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '=') {
                int index1 = chars[0] - 'a';
                int index2 = chars[3] - 'a';
                unionFind.union(index1, index2);
            }
        }

        for (String equation : equations) {
            char[] chars = equation.toCharArray();
            if (chars[1] == '!') {
                int index1 = chars[0] - 'a';
                int index2 = chars[3] - 'a';
                if (unionFind.isConnected(index1, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

}

