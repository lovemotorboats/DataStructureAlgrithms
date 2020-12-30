package math.intPowOp;
import string.mutiply.Solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * @description:整底整幂运算
 * @author:liyang
 * @create:2020-12-30
 */

public class Operation {
    public static String method(String base, String index) {
        //base为底数，必须为整数，正负零都可
        //index为指数，必须为非负整数
        String newBase = base;  //除去前置正负号的底数
        String newIndex = index;  //除去前置正号的指数
        String sign = "";
        if (!check(base, index)) {
            return "参数不合法";
        }
        if (base.equals("+0") || base.equals("0") || base.equals("-0")) {
            if (index.equals("+0") || index.equals("-0") || index.equals("0")) {
                return "底数指数不能同时为零";
            }
            return "0";
        }else if (index.equals("+0") || index.equals("-0") || index.equals("0")) {
            return "1";
        }

        if (index.charAt(0) == '+') {
            newIndex = index.substring(1);
        }
        if (base.charAt(0) == '+' || base.charAt(0) == '-') {
            newBase = base.substring((1));
            sign = (newIndex.charAt(newIndex.length() - 1) - '0') % 2 == 1 && base.charAt(0) == '-' ? "-" : "";
        }
        String res = sign + getPow(newBase, newIndex);
        return res;
    }

    public static boolean check(String base, String index) {
        //检查参数是否合法
        String baseReg = "^[-+]*([0]|[1-9]\\d*$)";
        Pattern basePattern = Pattern.compile(baseReg);
        Matcher baseMatcher = basePattern.matcher(base);
        String indexReg = "^[+]*([0]|[1-9]\\d*$)";
        Pattern indexPattern = Pattern.compile(indexReg);
        Matcher indexMatcher = indexPattern.matcher(index);
        return baseMatcher.matches() && indexMatcher.matches();
    }

    public static String getPow(String base, String index) {
        int count = Integer.valueOf(index);
        String result = new String(base);
        for (int i = 1; i < count; i++) {
            result = Solution.multiply(result, base);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(method("64", "63"));
        System.out.println(method("63", "64"));
    }
}
