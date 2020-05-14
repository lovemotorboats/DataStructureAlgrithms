package bit.oddtimesnum;

//在其它数都出现偶数次的数组中找到出现奇数次的数
public class Solution {
    //分析：整数n与0异或的结果为n，n与n异或的结果是0，而且异或运算满足交换律和结合律
    public static int getOddTimesNum(int[] a){
        int eO = 0;
        for (int cur : a){
            eO ^= cur;
        }
        return eO;
    }

    //进阶问题：有两个数出现了奇数次，其它数出现了偶数次，打印这两个数
    public static void printOddTimesNum(int[] a){
        int eO = 0, eOhasOne = 0;
        for (int cur : a){
            eO ^= cur;
        }
        int rightOne = eO & (~eO + 1);
        for (int cur : a){
            if ((cur & rightOne) != 0){
                eOhasOne ^= cur;
            }
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }
}
