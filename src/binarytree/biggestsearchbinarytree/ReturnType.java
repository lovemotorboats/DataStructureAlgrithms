package binarytree.biggestsearchbinarytree;

import binarytree.travel.Node;

//根据树形dp套路的第三步合并第二步的信息，创建新的数据结构
public class ReturnType {
    public Node maxBSTHead;  //最大搜索二叉树的头节点
    public int maxBSTSize;  //最大搜索二叉树的节点数
    public int min;  //如果是右边子树，需要知道其最小结点的值
    public int max;  //如果是左边子树，需要知道其最大结点的值

    public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max){
        this.maxBSTHead = maxBSTHead;
        this.maxBSTSize = maxBSTSize;
        this.max = max;
        this.min = min;
    }
}
