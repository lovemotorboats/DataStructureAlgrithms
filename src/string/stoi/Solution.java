package string.stoi;

//给定一个字符串str，如果str符合日常书写的整数形式，并且属于32位整数范围，则返回str所代表的整数值，否则返回0
public class Solution {
    //1、首先检查str是否符合日常书写的整数形式
    //  （1）如果str不以“-”开头，也不以数字开头。直接返回false
    //  （2）如果str以“-”开头，但是长度为1，返回false；如果长度大于1且后面紧跟0，返回false；
    //  （3）如果str以“0”开头，但是长度大于1，返回false；
    //  （4）如果（1）~（3）都没有返回false，就检查str[1...N-1]是否都是数字，如果都是则返回true，否则返回false。
    public static boolean isValid(char[] chars) {
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return false;
        }
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')) {
            return false;
        }
        if (chars[0] == '0' && chars.length > 1) {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    //2、正式转换
    public static int convert(String str){
        if (str == null || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        if (!isValid(chars)){
            return 0;
        }
        boolean posi = chars[0] == '-' ? false : true;
        int minQ = Integer.MIN_VALUE / 10;
        int minR = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i < chars.length; i++){
            cur = '0' - chars[i];
            if ((res < minQ) || (res == minQ && cur < minR)){
                return 0;
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE){
            return 0;
        }
        return posi ? -res : res;
    }
}
