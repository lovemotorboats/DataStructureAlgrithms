package string.getindexnull;

//给定一个字符串数组strs，在strs中有些位置为null，并且不为null的字符串之间按照字典序从小到大进行
//排列，给定一个字符串str，在strs中找出其出现最左边的位置，注意是最左边的位置。如果str等于null
//或者不存在，就返回-1
public class Solution {
    //分析：既然是有序数组，那么尽可能使用二分查找。本题需要变形
    public static int getIndex(String[] strs, String str){
        if (strs == null || strs.length == 0 || str == null){
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)){
                res = mid;
                right = mid - 1;
            }else if (strs[mid] != null){
                if (strs[mid].compareTo(str) < 0){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                i = mid;
                while (strs[i] == null && --i >= left);
                if (i < left || strs[i].compareTo(str) < 0){
                    left = mid + 1;
                }else {
                    res = strs[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }
}
