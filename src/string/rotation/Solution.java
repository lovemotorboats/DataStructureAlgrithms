package string.rotation;

//判断字符串a和b时候互为旋转词
public class Solution {
    public static boolean isRotation(String a, String b){
        if (a == null || b == null || a.length() != b.length())
            return false;
        String b2 = b + b;
        return other.kmp.Solution.getIndexOf(b2, a) == -1;
    }
}
