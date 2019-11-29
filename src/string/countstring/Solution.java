package string.countstring;

import java.util.Scanner;

//给定一个字符串str，返回str的统计字符串。例如aaabbaadddc，返回a_3_b_2_a_2_d_3_c_1
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入csrt：");
            String cstr = scanner.nextLine();
            if (cstr.equals("exit")){
                return;
            }
            System.out.println("请输入index：");
            int index = scanner.nextInt();
            System.out.println(cstr + "对应的原字符串中索引值为" + index + "的字符是：" + getCharAt(cstr, index));
        }
    }

    public static String getCountString(String str){
        if (str == null || str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        String res = String.valueOf(chars[0]);
        int num = 1;
        for (int i = 1; i < chars.length; i++){
            if (chars[i] != chars[i-1]){
                res = concat(res, String.valueOf(num), String.valueOf(chars[i]));
            }else {
                num++;
            }
        }
        return concat(res, String.valueOf(num), "");
    }

    public static String concat(String s1, String s2, String s3){
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }

    //补充问题：给定一个统计字符串cstr，再给定一个整数index，返回cstr所代表的原始字符串上索引为index的字符。
    //例如"a_1_b_100"所代表的原始字符串上第0个字符是'a',第29个字符是'b'

    //分析：将cstr按"_"进行切分然后处理
    public static char getCharAt(String str, int index){
        //默认参数str和index合法
        String[] strings = str.split("_");  //偶数索引为字符，奇数索引为次数
        int sum = 0;
        int i = -1;
        while (sum - 1 < index){
            i += 2;
            if (i < strings.length) {
                sum += Integer.parseInt(strings[i]);
            }else {
                return '!';  //表示index过大，不存在
            }
        }
        return strings[i-1].charAt(0);
    }
}
