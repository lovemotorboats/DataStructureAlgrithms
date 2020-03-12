package recursionanddynamicplanning.envelop;

import java.util.Arrays;

//信封嵌套问题
//给定一个N行2列的二维数组，每一个一维数组的两个值分别代表一个信奉的长和宽。
//如果信封A的长和宽都小于信封B，那么信封A可以放到信封B里面，请返回信封最多
//可以嵌套多少层
public class Solution {
    //对长度从小到大排序，长度相等的按昭宽度从大到小排序
    //然后求出宽度序列的最长递增子序列的长度即为所求
    //分析：
    //1、如果X之前的信封长度小于Xlen，那么只要其宽度小于Xwidth就可以
    //2、如果X之前的信封长度等于Xlen，那么其宽度一定大于等于Xwidth，就不可能是
    //X作为最外层信封下包含的信封

    //先排序
    public static Envelop[] getSortedEnvelops(int[][] matrix){
        Envelop[] res = new Envelop[matrix.length];
        for (int i = 0; i < matrix.length; i++){
            res[i] = new Envelop(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(res, new EnvelopComparator());
        return res;
    }

    //主过程
    public int maxEnvelops(int[][] matrix){
        Envelop[] envelops = getSortedEnvelops(matrix);
        int[] ends = new int[matrix.length];
        ends[0] = envelops[0].wid;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < envelops.length; i++){
            l = 0;
            r = right;
            while (l <= r){
                m = (l + r) / 2;
                if (envelops[i].wid > ends[m]){
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[1] = envelops[i].wid;
        }
        return right + 1;
    }
}
