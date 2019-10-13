package binarytree.getmaxhappy;

//每棵树处理完之后返回值的类型
public class ReturnType {
    public int yesHeadMax;  //树的头节点来的情况下整棵树的最大收益
    public int noHeadMax;  //树的头节点不来的情况下，整棵树的最大收益

    public ReturnType(int yesHeadHappy, int noHeadHappy) {
        this.yesHeadMax= yesHeadHappy;
        this.noHeadMax = noHeadHappy;
    }
}
