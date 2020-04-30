package other.binarysearch;

import java.util.Scanner;

//而二分查找
public class Solution {
    //返回位置索引
    public static int getEqualsIndex(int[] a, int input){
        int left = 0, right = a.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (a[mid] > input){
                right = mid - 1;
            }else if (a[mid] == input){
                return mid;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //数组中有相同的元素，返回第一个key的索引位置
    public static int getFirstIndex(int[] a, int key){
        int left = 0, right = a.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (a[mid] >= key){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (left <= a.length - 1 && a[left] == key){
            return left;
        }
        return -1;
    }

    //数组中有相同的元素，返回最后一个key的索引位置
    public static int getLastIndex(int[] a, int key){
        int left = 0, right = a.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (a[mid] <= key){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        if (right <= a.length - 1 && a[right] == key){
            return right;
        }
        return -1;
    }

    //返回第一个大于等于key的元素的索引
    public static int getFirstGEIndex(int[] a, int key){
        int left = 0, right = a.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (a[mid] >= key){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    //返回最后一个小于等于key的元素的索引
    public static int getLastLEIndex(int[] a, int key){
        int left = 0, right = a.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (a[mid] <= key){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {155, 926, 296, 237, 24, 546, 271, 726, 274, 802};
        int[] sum = new int[a.length];
        for (int i = 0; i < a.length; i++){
            sum[i] = i == 0 ? a[i] : sum[i - 1] + a[i];
        }
        for (int i = 0; i < 7; i++){
            int temp = scanner.nextInt();
            System.out.println(getFirstGEIndex(sum, temp));
        }
    }
}
