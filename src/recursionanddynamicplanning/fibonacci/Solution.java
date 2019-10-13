package recursionanddynamicplanning.fibonacci;

//返回fibonacci数列的第N项，如果N小于1返回-1
public class Solution {
    //方法一：递归方式，其时间复杂度O(2^N)
    public static int getValueOfFibonacci1(int n){
        if (n < 1)
            return -1;
        if (n == 1 || n == 2)
            return 1;
        return getValueOfFibonacci1(n-1) + getValueOfFibonacci1(n-2);
    }
    //方法二：从左到右依次求出每一项的值，时间复杂度O(N)，空间复杂度O(1)
    public static int getValueOfFibonacci2(int n){
        if (n < 1)
            return -1;
        if (n == 1 || n == 2)
            return 1;
        int res = 1;
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
