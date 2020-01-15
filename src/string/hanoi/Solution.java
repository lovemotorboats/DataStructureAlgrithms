package string.hanoi;


//汉诺塔问题
public class Solution {
    //给定一个整数n，代表汉诺塔游戏从小到大放置的n个圆盘，假设刚开始时所有的圆盘都放在左边的柱子上
    //想按照汉诺塔游戏的要求把所有的圆盘都移到右边的柱子上，请实现函数打印最优的移动轨迹
    //经典的递归求解
    public static void hanoi(int n, String from, String mid, String to){
        if (n <= 0){
            return;
        }
        if (n == 1){
            System.out.println(from + " --> " + to);
        }else {
            hanoi(n-1, from, to, mid);
            hanoi(1, from, mid, to);
            hanoi(n-1, mid, from, to);
        }
    }

    public static void main(String[] args) {
        hanoi(6, "左", "中", "右");
    }
}
