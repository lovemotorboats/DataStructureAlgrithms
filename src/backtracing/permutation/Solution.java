package backtracing.permutation;


//给出一个集合的全排列
public class Solution {
    //还是使用回溯的方法

    private static char[] output = new char[10];

    private static final char[] chars = {'A', 'B', 'C', 'D', 'E'};

    private static int num = 0;

    public static boolean check(char des, int now){
        for (int i = 0; i < now; i++){
            if (output[i] == des){
                return false;
            }
        }
        return true;
    }

    public static void backTracing(int now){
        for (int i = 0; i < chars.length; i++){
            output[now] = chars[i];
            if (check(chars[i], now)){
                if (now == chars.length - 1){
                    print(output);
                    num++;
                    return;
                }else {
                    backTracing(now + 1);
                }
            }
        }
    }

    public static void print(char[] output){
        for (char ch : output){
            System.out.print(ch);
        }
        System.out.print(" ");
    }

    public static void main(String[] args) {
        backTracing(0);
        System.out.println("全排列总数为" + num);
    }
}
