package math.gcdOrGcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//最小公倍数和最大公因数
public class Solution{

    //判断一个数n是不是质数
    public static boolean isPrime(int n){
        //大于等于5的质数必定位于6的倍数的两侧
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        int temp = (int)Math.sqrt(n);
        for (int i = 5; i <= temp; i += 6){
            if (n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }

    //两个数的最大公因数
    public static int gcd(int a, int b) {
        return b == 0 ? a :gcd(b, a % b);
    }

    //两个数的最小公倍数
    public static int lcm(int a, int b) {
        int maxDivider = gcd(a, b);
        return a * b / maxDivider;
    }

    //求n的质因数组
    public static ArrayList<Integer> getDividers(int n) { //n >= 2
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                while (n % i == 0) {
                    list.add(i);
                    n = n / i;
                    if (n == 1) {
                        break;
                    }
                }
            }
            if (n == 1){
                break;
            }
        }
        return list;
    }

    //求n个数的最大公因数
    public static int gcd(int[] arr) {  //arr.length >= 2 && arr[i] >= 2
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        int greatestCommonDivider = 1;
        for (int i = 2; i <= min; i++) {
            if (isPrime(i)) {
                boolean flag = true;
                while (flag) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] % i != 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int j = 0; j < arr.length; j++) {
                            arr[j] = arr[j] / i;
                        }
                        min /= i;
                        greatestCommonDivider *= i;
                    }
                }

            }
        }
        return greatestCommonDivider;
    }

    //求n个数的最小公倍数(不考虑溢出)
    public static int lcm(int[] arr) {
        int result = 1;
        for (int i = 0; i < arr.length; i++){
            result = lcm(result, arr[i]);
        }
        return result;
    }

    //测试
    public static void main(String[] args) {
        int[] input1 = {278, 100, 56, 98, 984};
        int[] input2 = {2, 6, 27, 3, 39};
        for (int x : input1) {
            System.out.println(getDividers(x).toString());
        }
        System.out.println(gcd(input1));
        System.out.println(lcm(input2));
    }
}