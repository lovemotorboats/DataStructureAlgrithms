package unionfind;
/*
 * @description:并查集数据结构
 * @author:liyang
 * @create:2020-06-17
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UnionFind{
    public int[] parent;

    public UnionFind(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  //初始化并查集（每个元素的父节点初始为他自己）
        }
    }

    //查找x的祖宗节点
    public int find(int x) {
        while (x != parent[x]) {  //隔代压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //合并两个节点对应的连通分量
    public void union(int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        parent[x_root] = y_root;

    }

    //判断两个节点是否连通
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

}
