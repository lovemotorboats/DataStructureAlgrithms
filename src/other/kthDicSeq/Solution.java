package other.kthDicSeq;
/* 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * @description:
 * @author:liyang
 * @create:2020-07-10
 */

public class Solution {
    public static int findKthNumber(int n, int k) {
        int cur = 1;
        // k = k - 1;//扣除掉第一个0节点
        while(k > 0){
            int num = getNode(n, cur, cur + 1);
            if(num < k){//第k个数不在以cur为根节点的树上
                cur += 1;//cur在字典序数组中从左往右移动
                k -= num;
            }else{//在子树中
                cur *= 10;//cur在字典序数组中从上往下移动
                k -= 2;//刨除根节点
            }
        }
        return cur;
    }
    public static int getNode(int n, long first, long last){
        int num = 0;
        while(first <= n){
            num += Math.min(n+1, last) - first;//比如n是195的情况195到100有96个数
            first *= 10;
            last *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));
    }
}
