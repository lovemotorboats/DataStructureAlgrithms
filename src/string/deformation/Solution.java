package string.deformation;

//给定两个字符串str1和str2，如果str1和str2中出现的字符串种类和每种字符出现的次数都是一样，那么称str1
//和str2互为变形词，请判断给定的str1和str2是否互为变形词
public class Solution {
    //分析：用一个数组记录str1中每个字符出现的次数，形成一个字符频数表，然后遍历str2，遍历到某个
    //字符时就将对应的频数减一，最终如果数组的每个元素的值都为0那么就为true，否则为false
    public static boolean isDeformation(String str1, String str2){
        if (str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];  //假设出现的字符的编码值在0~255之间
        for (int i = 0; i < chars1.length; i++){
            map[chars1[i]]++;
        }
        for (int i = 0; i < chars2.length; i++){
            if (map[chars2[i]]-- == 0){
                return false;
            }
        }
        return true;
    }
}
