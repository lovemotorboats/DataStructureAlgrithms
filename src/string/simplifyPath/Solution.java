package string.simplifyPath;
/* 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * @description:
 * @author:liyang
 * @create:2020-07-03
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
//最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<>();
        String[] temp = path.split("/");
        List<String> res = new ArrayList<>();
        for (String s : temp) {
            if (s.length() != 0) {
                res.add(s);
            }
        }
        for (String s : res) {
            if (s.equals(".")) {  //当前目录，直接跳过
                continue;
            }else if (s.equals("..")) {  //上级目录，弹出队尾元素
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            }else {
                queue.addLast(s);
            }

        }
        if (queue.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder("/");
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            sb.append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/../"));
        System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
    }
}
