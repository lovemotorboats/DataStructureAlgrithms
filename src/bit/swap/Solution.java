package bit.swap;

//不用额外变量交换两个整数得值
public class Solution {
    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
