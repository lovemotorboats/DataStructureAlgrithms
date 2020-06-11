package backtracing.restoreIp;

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> restoreIpAddresses(String s) {
        //回溯法
        List<String> ip = new ArrayList<>();
        if (s.length() <= 3 || s.length() >= 13) {
            return ip;
        }
        int[] point = new int[4];
        point[0] = -1;
        backTracing(point, 1, s, ip);
        return ip;
    }

    public static boolean isOk(int[] point, int now, int index, String s) {
        //point[i]表示第i个点放置在第几个空（字符串第一个字符后面的空的索引为0）
        //now表示当前是第几个点，index表示要放置的位置
        int len = index - point[now - 1];
        if (len > 3) {
            return false;
        } else if (len >= 2 && s.charAt(point[now - 1] + 1) == '0') {
            return false;
        }
        if (now == 3) {
            if (s.charAt(index + 1) == '0' && s.length() - 1 - index >= 2) {
                return false;
            }
            int last = Integer.valueOf(s.substring(index + 1));
            if (last > 255) {
                return false;
            }
        }
        Integer temp = Integer.valueOf(s.substring(point[now - 1] + 1, index + 1));
        if (temp > 255 || (4 - now) * 3 < s.length() - 1 - index) {
            return false;
        }
        return true;
    }

    public static void backTracing(int[] point, int now, String s, List<String> result) {
        if (now == 4) {
            StringBuilder newIp = new StringBuilder();
            for (int i = 0; i <= 2; i++) {
                newIp.append(s.substring(point[i] + 1, point[i + 1] + 1));
                newIp.append(".");
            }
            newIp.append(s.substring(point[3] + 1));
            result.add(newIp.toString());
            return;
        }

        for (int i = point[now - 1] + 1; i < s.length() - 1; i++) {
            if (isOk(point, now, i, s)) {
                point[now] = i;
                backTracing(point, now + 1, s, result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("172162541").toString());
    }
}
