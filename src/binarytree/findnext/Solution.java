package binarytree.findnext;

//parent指针都指向父节点，根节点的parent指针指向null
public class Solution {
    //在这样结点类型的二叉树中找某个结点的中序遍历下的后继节点
    //情况1：如果node有右子树，那么后继结点就是右子树中最左边的结点
    //情况2：如果node没有右子树，若node没有父节点，那么没有后继结点，
    // 若node是其父的左孩子，那么后继结点就是其父，若node是其父的右孩子，那么一直往
    //上找，假设移动到的结点为s，s的父节点为p，如果s是p的左节点，那就返回p，否则一直往上
    //找
    //情况3：在情况2中一直往上找到为空了还是没找到就返回空
    public Node getNextNode(Node node){
        if (node == null)
            return node;
        if (node.right != null)
            return getLeftMost(node.right);
        else {
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                //从下往上找，相当于找到直系祖先中，第一个为别人左儿子结点的父节点
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node){
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }
}
