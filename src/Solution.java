//public class Solution {
//    public static String ReverseSentence(String str) {
//        if(str == null || str.length() == 0){
//            return str;
//        }
//        char[] ch = str.toCharArray();
//        ch = reverseArray(ch, 0, str.length() - 1);
//        int i = 0, j = 0;
//        while(i < ch.length && j < ch.length){
//            if(ch[i] == ' '){
//                i++;
//            }else{
//                j = i;
//                while(j < ch.length && ch[j] != ' '){
//                    j++;
//                }
//                reverseArray(ch, i, j - 1);
//                i = j;
//            }
//        }
//        return String.valueOf(ch);
//    }
//
//    public static char[] reverseArray(char[] input, int left, int right){
//        //将输入数组从left位置到rigth位置翻转（包括端点）
//        for(int i = left, j = right; i < j; i++, j--){
//            char temp = input[i];
//            input[i] = input[j];
//            input[j] = temp;
//        }
//        return input;
//    }
//
//    public static void main(String[] args) {
//        ReverseSentence("I am a student.");
//    }
//}
