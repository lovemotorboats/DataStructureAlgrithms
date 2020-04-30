package arrayandmatrix.issquare;


//给定四个点的坐标，判断这四个点能否组成正方形
public class Solution {
    //思路：正方形的四条边长相等，两条对角线相等
    //总共有三种组合方式：1->2->3->4、1->2->4->3、1->3->2->4
    public static boolean judge(int[][] a){  //以a固定顺序能否组成正方形
        //a[i][0]代表第i个点的横坐标、a[i][1]代表第i个点的纵坐标，i从0到3
        //组合方式1：
        for (int i = 0; i <= 3; i++){
            if ((int)Math.pow(a[i%4][0] - a[(i+1)%4][0], 2) + (int)Math.pow(a[i%4][1] - a[(i+1)%4][1], 2)
            != (int)Math.pow(a[(i+1)%4][0] - a[(i+2)%4][0], 2) + (int)Math.pow(a[(i+1)%4][1] - a[(i+2)%4][1], 2)
            || (int)Math.pow(a[i%4][0] - a[(i+2)%4][0], 2) + (int)Math.pow(a[i%4][1] - a[(i+2)%4][1], 2)
                    != (int)Math.pow(a[(i+1)%4][0] - a[(i+3)%4][0], 2) + (int)Math.pow(a[(i+1)%4][1] - a[(i+3)%4][1], 2)){
                return false;
            }
        }
        return true;
    }

    public static boolean isSquare(int[][] a){
        int[][] a1 = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++){
            a1[i][0] = a[i][0];
            a1[i][1] = a[i][0];
        }
        a1[2][0] = a[3][0];
        a1[2][1] = a[3][1];
        a1[3][0] = a[2][0];
        a1[3][1] = a[2][1];
        int[][] a2 = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++){
            a1[i][0] = a[i][0];
            a1[i][1] = a[i][0];
        }
        a2[1][0] = a[3][0];
        a2[1][1] = a[3][1];
        a2[3][0] = a[1][0];
        a2[3][1] = a[1][1];
        return judge(a) || judge(a1) || judge(a2);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1}, {-2, 1}, {-1, 1}, {1, -1}};
        System.out.println(isSquare(a));
    }
}
