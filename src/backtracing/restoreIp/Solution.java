package backtracing.restoreIp;

//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        //回溯法，依次在数字之间的空隙中摆放“.”，当不满足要求时就回溯，直到将三个“.”都放置成功说明是一个合法的解决方案
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {  //长度不合适，没有一个解决方案
            return res;
        }
        int[] points = new int[4];
        backTrace(points, 1, s, res);
        return res;
    }

    public void backTrace(int[] points, int now, String s, List<String> result) {
        //points : 已经摆放的“.”在字符串中的间隙中的索引位置（定义第一个字符后面的那个间隙索引为1，以此类推）,point[i]表示第i个点的位置（i从1开始）
        //now : 当前需要摆放的是第几个点
        //s : 输入的原始字符串
        //result : 已经找到的解决方案

        if (now == 4) {  //说明已经摆放了三个点
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 3; i++) {
                sb.append(s, points[i - 1], points[i]);
                sb.append(".");
            }
            sb.append(s.substring(points[3]));
            result.add(sb.toString());
            return;
        }
        for (int i = points[now - 1] + 1; i < s.length(); i++) {
            //开始尝试
            if (isOk(points, now, i, s)) {
                points[now] = i;
                backTrace(points, now + 1, s, result);
            }
        }

    }

    //判断将第now个“.”放置在s中的第index个间隙位置是否合法
    public boolean isOk(int[] points, int now, int index, String s) {
        int len = index - points[now - 1];  //与前一个点的距离
        if (len > 3) {  //超过3位数，直接不合法
            return false;
        }else if (len >= 2 && s.charAt(points[now - 1]) == '0') {  //距离大于2并且以0开头，也不合法
            return false;
        }

        if (now == 3) {  //最后一个点，特殊处理
            if (s.length() - index >= 2 && s.charAt(index) == '0') {
                return false;
            }
            int last = Integer.valueOf(s.substring(index));
            if (last > 255) {
                return false;
            }
        }

        Integer temp = Integer.valueOf(s.substring(points[now - 1], index));
        if (temp > 255) {
            return false;
        }

        if ((4 - now) * 3 < s.length() - index) {
            return false;
        }
        return true;
    }
}
