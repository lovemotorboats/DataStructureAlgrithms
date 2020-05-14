package other.gcd;

//一行代码求出两个不等于0的整数M和N的最大公约数
public class Solution {
    public static int getGCD(int m, int n){
        return n == 0 ? m : getGCD(n, m % n);
    }
}
