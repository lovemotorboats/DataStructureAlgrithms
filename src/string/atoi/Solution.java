package string.atoi;

//实现一个将字符串转换成整型数字
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
                result = newsRes * 10 + arr[i] - '0';
                if (result - arr[i] + '0' != newsRes * 10){
                    //说明溢出了
                    if (sign == 1)
                        return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
                newsRes = result;
            }else break;
        }
        return result * sign;
    }
}
