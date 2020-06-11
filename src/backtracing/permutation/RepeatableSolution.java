package backtracing.permutation;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RepeatableSolution {
    public static String[] permutation(String s) {
        //先把每个字符当成不同字符，进行全排列，然后去重（set）
        char[] origin = s.toCharArray();
        int[] index = new int[s.length()];
        char[] chs = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            index[i] = -1;
        }
        Set<String> result = new HashSet<>();
        backTracing(result, 0, index, chs, origin);
//        for (String s1 : result){
//            System.out.println(s1);
//        }
        String[] arr = result.stream().toArray(String[]::new);
        return arr;
    }

    public static boolean isOk(int[] chs, int now, int index) {
        //chs[i]表示新排列的序列第i个字符是原始字符数组的第几个索引位置的元素（i从0开始）
        //查看chs[0...now-1]有没有哪个的值等于要尝试的index，如果有，就代表index位置的元素已被使用，不能再使用
        for (int i = 0; i < now; i++) {
            if (index == chs[i]) {
                return false;
            }
        }
        return true;
    }

    public static void backTracing(Set<String> result, int now, int[] index, char[] chs, char[] origin) {
        //result:结果集  now:尝试索引点  index:已经排好的元素在原字符串的索引位置  chs:排好的元素数组
        //origin:原字符串生成的字符数组
        if (now == chs.length) {
            StringBuilder sb = new StringBuilder();
            for (char ch : chs) {
                sb.append(ch);
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            int temp = i;
            if (isOk(index, now, temp)) {
                index[now] = temp;
                chs[now] = origin[temp];
                backTracing(result, now + 1, index, chs, origin);
            }
        }
    }

    //    public static void main(String[] args) {
//         permutation("qqe");
//    }
    public static void main(String[] args) {
//        String[] result = permutation("qqe");
//        for (String s : result) {
//            System.out.println(s);
//        }
        System.out.println(dayOfYear("2020-06-06"));
    }

    public static int dayOfYear(String date) {
        // Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        // Matcher matcher = pattern.matcher(date);
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8, 10));
        int[] plusNormalYear = {0, 1, -1, 0, 0, 1, 1, 2, 3, 3, 4, 4};  //平年每个月对应的需要增加的天数
        int[] plusLeapYear = {0, 1, 0, 1, 1, 2, 2, 3, 4, 4, 5, 5};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            //闰年
            return (month - 1) * 30 + day + plusLeapYear[month - 1];
        }else {
            return (month - 1) * 30 + day + plusNormalYear[month - 1];
        }
    }
}
