package recursionanddynamicplanning.numsOfBinarySortTree;

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
public class Solution {
    //思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
    //当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，
    //其左子树节点个数为1，右子树节点为n-2，所以可得
    //G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
    public int numTrees(int n) {
        //dp[i]表示i个节点的二叉排序树的种数
        //dp[0] = 1, dp[1] = 1;  (为了计算方便，令dp[0] = 1)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 0; j <= i - 1; j++){
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}