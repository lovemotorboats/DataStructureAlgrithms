package arrayandmatrix.reversePair;
/*
 * @description:
 * @author:liyang
 * @create:2020-07-07
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    private int[] aux;

    private int res = 0;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        aux = new int[len];
        sort(nums, 0, len - 1);
        return res;
    }

    public void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid  = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high) {
        //将nums数组的nums[low, mid]和nums[mid+1, high]两个部分按顺序合并，并返回逆序对个数
        aux = new int[nums.length];
        for (int i = low; i <= high; i++) {
            aux[i] = nums[i];  //复制一份副本，用以辅助
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            }else if (j > high) {
                nums[k] = aux[i++];
            }else if (aux[i] > aux[j]) {
                res += mid - i + 1;
                nums[k] = aux[j++];
            }else {
                nums[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        String res = Arrays.stream(input).mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());
        System.out.println(res);
    }
}
