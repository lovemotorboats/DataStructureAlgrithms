package bit.oncenum;

//在其它数都出现k次的数组中找到只出现一次的数
public class Solution {
    //结论：k个相同的k进制数进行无进位相加，结果一定是每一位都是0的k进制数
    //步骤：首先设置一个变量eO，他是一个32位的k进制数，而且每个位置上都是0，
    //然后遍历arr，把遍历到的每一个整数都转化成k进制数，然后与eO进行无进位相加。
    public static int[] getKSysNumFromNum(int value, int k){
        //将十进制数转为k进制数
        int[] res = new int[32];
        int index = 0;
        while (value != 0){
            res[index++] = value % k;
            value /= k;
        }
        return res;
    }

    public static int getNumFromKSysNum(int[] eO, int k){
        //将k进制数转为十进制数
        int res = 0;
        for (int i = eO.length - 1; i >= 0; i--){
            res = res * k + eO[i];
        }
        return res;
    }

    public static void setExclusiveOr(int[] eO, int value, int k){
        //进行异或
        int[] curKSysNum = getKSysNumFromNum(value, k);
        for (int i = 0; i < eO.length; i++){
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }

    public static int onceNum(int[] a, int k){
        //找出落单的数
        int[] eO = new int[32];
        for (int i = 0; i < a.length; i++){
            setExclusiveOr(eO, a[i], k);
        }
        int res = getNumFromKSysNum(eO, k);
        return res;
    }
}
