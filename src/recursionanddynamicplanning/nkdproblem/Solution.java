package recursionanddynamicplanning.nkdproblem;

import java.util.ArrayList;
import java.util.Scanner;

//从大小为N的整型数组中，选取K个数，每个数之间的索引不能超过D，怎样选择能让选出来的数乘积最大？
public class Solution {
    //dp[i][k][0]表示前i个元素中选择k+1个数，且元素之间索引不超过d，并且第i个元素必选的情况下，能获取到的最大正值
    //dp[i][k][1]表示前i个元素中选择k+1个数，且元素之间索引不超过d，并且第i个元素必选的情况下，能获取到的最小负值

    //假设给出的数组为a，那么递推关系如下：
    //1、若a[i] > 0: dp[i][k][0] = max{dp[i-1][k-1][0], dp[i-2][k-1][0], ..., dp[i-d][k-1][0]} * a[i]，(i-d >= 0);
    //               dp[i][k][1] = min{dp[i-1][k-1][1], dp[i-2][k-1][1], ..., dp[i-d][k-1][1]} * a[i]，(i-d >= 0);
    //2、若a[i] < 0: dp[i][k][1] = max{dp[i-1][k-1][0], dp[i-2][k-1][0], ..., dp[i-d][k-1][0]} * a[i]，(i-d >= 0);
    //               dp[i][k][0] = min{dp[i-1][k-1][1], dp[i-2][k-1][1], ..., dp[i-d][k-1][1]} * a[i]，(i-d >= 0);
    //3、若a[i] == 0: dp[i][k][0] = 0;
    //               dp[i][k][1] = 0;
    //先算dp[i][1][0]和dp[i][1][1]
    public static long getMax(int[] a, int k, int d, ArrayList<Integer> result) {  //result返回结果中选取元素的索引
        if (a == null || a.length == 0 || k > a.length || k <= 0 || d < 0) {
            return 0;
        }
        if(d == 0){
            if(k > 1){
                return 0;
            }else if (k == 1){
                int max = a[0];
                for(int i = 0; i < a.length; i++){
                    max = max < a[i] ? a[i] : max;
                }
                return max;
            }
        }
        int len = a.length;
        long[][][] dp = new long[len][k][2];
        for (int i = 0; i < len; i++) {  //第一列初始化
            dp[i][0][0] = a[i] > 0 ? a[i] : 0;
            dp[i][0][1] = a[i] < 0 ? a[i] : 0;
        }
        for (int i = 1; i < k; i++) {  //从第二列开始递推
            for (int j = i; j < len; j++) {
                long min = dp[j - 1][i - 1][1];
                long max = dp[j - 1][i - 1][0];
                for (int m = j - 1; m >= j - d && m >= 0; m--) {  //找出前d个元素的最小负值
                    min = Math.min(min, dp[m][i - 1][1]);
                    max = Math.max(max, dp[m][i - 1][0]);
                }
                if (a[j] < 0) {  //负数
                    dp[j][i][0] = min * a[j];
                    dp[j][i][1] = max * a[j];
                } else if (a[j] == 0) {
                    dp[j][i][0] = 0;
                    dp[j][i][1] = 0;
                } else {  //正数
                    dp[j][i][0] = max * a[j];
                    dp[j][i][1] = min * a[j];
                }
            }
        }
        long val = dp[len - 1][k - 1][0];
        int lastIndex = len - 1;
        for (int i = k - 1; i < len; i++) {
            if(val < dp[i][k - 1][0]){
                val = dp[i][k - 1][0];
                lastIndex = i;
            }
        }
        long max = val;  //临时变量
        result.add(lastIndex);
        int col = k - 2;
        while (result.size() != k){
            if (a[lastIndex] > 0){
                for(int j = lastIndex - 1; j >= lastIndex - d && j >= 0; j--){
                    if (dp[j][col][0] == max / a[lastIndex] || dp[j][col][1] == max / a[lastIndex]){
                        max = max / a[lastIndex];
                        lastIndex = j;
                        col--;
                        result.add(lastIndex);
                        break;
                    }
                }
            }else if (a[lastIndex] < 0){
                for(int j = lastIndex - 1; j >= lastIndex - d && j >= 0; j--){
                    if (dp[j][col][1] == max / a[lastIndex] || dp[j][col][0] == max / a[lastIndex]){
                        max = max / a[lastIndex];
                        lastIndex = j;
                        col--;
                        result.add(lastIndex);
                        break;
                    }
                }
            }
        }
        return val;
    }

    public static void main(String[] args) {
//        int[] input = {3, 7, -2, 4, 6, 1, -7, -5, 3, 9};
//        int m = getMax(input, 3, 3, new ArrayList<Integer>());
//        System.out.println(m);
            Scanner input = new Scanner(System.in);
            int numOfStudents = input.nextInt();
            int[] a = new int[numOfStudents];
            for(int i = 0; i < numOfStudents; i++){
                a[i] = input.nextInt();
            }
            int k = input.nextInt();
            int d = input.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            System.out.println(getMax(a, k, d, list));
            for (int index : list){
                System.out.println(index + " " + a[index]);
            }
    }
}
