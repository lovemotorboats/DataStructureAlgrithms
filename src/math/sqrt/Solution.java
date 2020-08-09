package math.sqrt;

public class Solution {
    //求开根号
    public static int mySqrt(int x) {
        //采用二分法进行试探
        String s = String.valueOf(x);
        int x_len = s.length();  //获取x的位数
        int len = (x_len + 1) / 2;  //x的平方根位数
        int max = (int)Math.pow(10, len) - 1;  //最大的len位数
        int min = (int)Math.pow(10, len - 1);  //最小的len位数
        int mid = (min + max) / 2;
        while (!(mid <= x / mid && (mid + 1) > x / (mid + 1))) {
            if (mid < x / mid) {
                min = mid + 1;
            }else if (mid > x / mid) {
                max = mid - 1;
            }else {
                return mid;
            }
            mid = (min + max) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2000));
    }
}
