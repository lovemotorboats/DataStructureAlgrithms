package recursionanddynamicplanning.crossstep;

//有N台阶，每次可以跨一级或者两级，那么跨N级台阶总共有多少种跨法
public class Solution {
    //策略：由于每次只能跨一级或者两级，那么要跨到N级台阶，只有两种可能性，即从
    //第N-1级台阶跨一级，或者从第N-2级台阶跨两级；也就是跨到第N-1的台阶种数加上
    //跨到第N-2的台阶种树
    //方法一：时间复杂度为O(2^N)
    public static int s1(int n){
        if (n < 1)
            return -1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return s1(n-1) + s1(n-2);
    }
    //方法二：时间复杂度为O(N)
    public static int s2(int n){
        if (n < 1)
            return -1;
        if (n == 1 || n == 2)
            return n;
        int res = 2;
        int pre = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++){
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }
    //方法三：时间复杂度为O(logN)的方法
}
