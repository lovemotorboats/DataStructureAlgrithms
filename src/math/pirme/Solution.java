package math.pirme;

//质数相关操作
public class Solution {

    /*
    * n >= 2
    * */
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

    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++){
            if (isPrime(i)){
                System.out.print(i + ",");
            }
        }

    }
}
