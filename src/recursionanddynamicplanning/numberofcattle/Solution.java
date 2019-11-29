package recursionanddynamicplanning.numberofcattle;

import java.util.Scanner;

//问题描述：假设农场中成熟的母牛每年只会生一头小牛，并且所有的牛都不会死。第一年农场
//有一头成熟的母牛，从第二年开始母牛每年开始生小母牛。每只小母牛三年后成熟又可以生小母牛
//那么，第N年农场有多少头牛？
public class Solution {
    public static void main(String[] args) {
        do {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if (n <= 0){
                return;
            }
            System.out.println(getNumberOfCattle2(n));
        }while (true);
    }
    //分析：第N年的牛的数量应该等于第N-1年的牛的数量加上第N年新出生的牛的数量
    //而第N年出生的牛有多少呢？那就要看第N-3年的牛有多少啦。因为第N-3年就存在的牛
    //在第N年的时候一定是成熟的，每头牛都会生一头小母牛，第N-2、第N-1年出生的小牛在
    //第N年的时候才2岁还不会生小牛。
    //所以：C(N) = C(N-1) + C(N-3),C(1)=1,C(2)=2,C(3)=3
    //方法一：
    public static int getNumberOfCattle1(int n){
        if (n < 1)
            return -1;
        if (n ==1 || n == 2 || n == 3)
            return n;
        return getNumberOfCattle1(n-1) + getNumberOfCattle1(n-3);
    }
    //方法二：
    public static int getNumberOfCattle2(int n){
        if (n < 1)
            return -1;
        if (n == 1 || n == 2 || n == 3)
            return n;
        int res = 3;
        int pre = 2;
        int prePre = 1;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 4; i <= n; i++){
            temp1 = res;
            temp2 = pre;
            res += prePre;
            pre = temp1;
            prePre = temp2;
        }
        return res;
    }
}
