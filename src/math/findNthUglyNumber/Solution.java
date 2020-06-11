package math.findNthUglyNumber;

class Solution {
    public static int nthUglyNumber(int n, int a, int b, int c) {
        //丑数就是能被a, b, c任意一个整除的数
        //采用二分查找
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            //从[0...mid]有多少个丑数
            long num = mid / a + mid / b + mid / c - mid / lcm(a, b) - mid / lcm(b, c) - mid / lcm(a, c) + mid / lcm (a, b, c);
            if (num > n) {
                right = mid - 1;
            }else if (num < n) {
                left = mid + 1;
            }else if(num == n && ((mid % a) == 0 || (mid % b) == 0 || (mid % c) == 0)){
                return (int)mid;
            }else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static long gcd(long a, long b) {  //求a, b的最大公因数
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        //求a, b的最小公倍数
        return a * (b / gcd(a, b));
    }

    public static long lcm(int a, int b, int c) {
        //求a, b, c的最小公倍数
        return lcm(a, lcm(b, c));
    }


    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467));
//        System.out.println(gcd(217983653, 336916467));
    }
}
