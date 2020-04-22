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
        System.out.println(atoi("-21474836an"));
    }
}
