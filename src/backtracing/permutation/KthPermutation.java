package backtracing.permutation;
/*
 * @description:
 * @author:liyang
 * @create:2020-07-03
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class KthPermutation {
    private int seq = 0;  //seq : 当前的排列应属的序号

    private String res = "";

    public String getPermutation(int n, int k) {
        //回溯
        backTrace(new LinkedList<>(), n, k, new HashSet<>());
        return res;
    }

    public boolean backTrace(LinkedList<Integer> track, int n, int k, Set<Integer> set) {
        //track : 已选择的数
        //可供选择的范围【1， n】
        //k : 第k个排列
        //set : 和track元素相同，提高查找效率
        if (track.size() == n) {
            seq++;
            if (seq == k) {
                StringBuilder sb = new StringBuilder();
                for (Integer i : track) {
                    sb.append(i);
                }
                res = sb.toString();
                return true;
            }
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            track.add(i);
            set.add(i);
            if (backTrace(track, n, k, set)) {  //将回溯函数设置成有返回值可以在找到解后就退出搜索，不用做无谓的继续递归
                return true;
            }
            track.removeLast();
            set.remove(i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new KthPermutation().getPermutation(9, 101134));
    }
}
