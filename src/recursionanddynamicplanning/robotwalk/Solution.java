package recursionanddynamicplanning.robotwalk;

//有1到N这N个位置，N大于等于2，开始时机器人位于M位置，机器人可以往左走或者往
//右走，规定机器人必须走K步，求最终可以走到P位置的方法数
public class Solution {
    //方法一：暴力递归
    //需要传入四个参数，分别是
    // N： 1到N，固定参数；
    //cur：当前机器人所处位置，可变参数
    //rest：剩余步数，可变参数
    //P：最终目标位置，固定参数
    //由于每次只能往左边或者右边走一步，那么就只有两种可能
    public static int walk(int N, int cur, int rest, int P){
        if (rest == 0){
            return cur == P ? 1 : 0;
        }
        if (cur == 1){
            return walk(N, 2, rest -1, P);
        }
        if (cur == N){
            return walk(N, N - 1, rest - 1, P);
        }
        return walk(N, cur - 1, rest - 1, P) + walk(N, cur + 1, rest - 1, P);
    }
    public static int ways1(int N, int M, int K, int P){
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N)
            return 0;
        return walk(N, M, K, P);
    }

    //暴力递归优化为动态规划的套路

}
