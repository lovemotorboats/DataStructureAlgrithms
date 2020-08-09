package string.atoi;

//实现一个将字符串转换成整型数字类型
public class Solution {
    public static int atoi(String str){
        if (str == null || str.trim().length() == 0)
            return 0;
        char[] arr = str.trim().toCharArray();
        int sign = 1;  //符号位
        int result = 0;
        int newsRes = 0;
        int index = 0;
        if (arr[0] == '-'){
            index++;
            sign = -1;
        }
        if (arr[0] == '+')
            index++;
        for (int i = index; i < arr.length; i++){
            if (arr[i] >= '0' && arr[i] <= '9'){
                if(newsRes > Integer.MAX_VALUE / 10){  //溢出返回0
                    return 0;
                }else if(newsRes == Integer.MAX_VALUE / 10 && arr[i] > '7' && sign == 1){
                    return 0;
                }else if (newsRes == Integer.MAX_VALUE / 10 && arr[i] > '8' && sign == -1){
                    return 0;
                }
                result = newsRes * 10 + arr[i] - '0';
                newsRes = result;
            }else {  //输入参数不合法返回0
                return 0;
            }
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }

    /*
    * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
    * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
    * 接下来的转化规则如下：
    *   如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，
    *   形成一个有符号整数。假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，
    *   形成一个整数。该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，
    *   它们对函数不应该造成影响。
    *   注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
    *   则你的函数不需要进行转换，即无法进行有效转换。
    *   在任何情况下，若函数不能进行有效的转换时，请返回 0 。
    *   提示：
    *   本题中的空白字符只包括空格字符 ' ' 。假设我们的环境只能存储 32 位大小的有符号整数，
    *   那么其数值范围为 [−231,  231 − 1]。
    *   如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
    * */
    public static int myAtoi(String str) {
        //1、丢弃str开头的空格
        //2、读取第一个字符，如果不是数字或者‘-’,直接返回0，否则进入3
        //3、尽可能多的读取连续数字字符，形成新的字符串，中间遇到空格跳过
        //4、对新字符串进行转换，注意整数溢出问题
        str = str.trim();
        if (str.length() == 0) {  //长度为0
            return 0;
        }

        //第一个字符不是负号或者1~9的数字
        if (str.charAt(0) != '-' && str.charAt(0) != '+' && !(str.charAt(0) >= '0' && str.charAt(0) <= '9')) {
            return 0;
        }
        char[] str_array = str.toCharArray();
        int len = str_array.length;
        StringBuilder sb =  new StringBuilder();
        sb.append(str_array[0]);
        for (int i = 1; i < len; i++) {
            if (str_array[i] == ' ') {  //空格跳过
                break;
            }
            if (str_array[i] >= '0' && str_array[i] <= '9') {
                sb.append(str_array[i]);
            }else {
                break;
            }
        }
        str = sb.toString();
        if (str.equals("-") || str.equals("+")) {
            return 0;
        }
        len = str.length();
        int index = str.charAt(0) == '-' || str.charAt(0) == '+' ? 1 : 0;
        int sign = str.charAt(0) == '-' ? -1 : 1;
        int result = 0;
        while (index < len) {
            if (result > Integer.MAX_VALUE / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }else if (result == Integer.MAX_VALUE / 10) {
                if (sign == 1 && str.charAt(index) > '7') {
                    return Integer.MAX_VALUE;
                }else if (sign == -1 && str.charAt(index) > '8') {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + str.charAt(index++) - '0';
            }else {
                result = result * 10 + str.charAt(index++) - '0';
            }
        }

        return result * sign;

    }
}
