package string.isunique;

//判断字符数组中是否所有字符都只是出现过一次
public class Solution {
    //1、实现时间复杂度为O(N)的方法
    //用map存储即可
    public static boolean isUnique1(char[] chars){
        if (chars == null){
            return true;
        }
        boolean[] map = new boolean[256];
        for (int i = 0; i < chars.length; i++){
            if (map[chars[i]]){
                return false;
            }
            map[chars[i]] = true;
        }
        return true;
    }

    //2、实现空间复杂度为O(1)并且时间复杂度尽量低的算法
    //分析：整体思路是对chars先排序。由于四大经典的排序算法中快速排序、希尔排序、
    // 归并排序的空间复杂度都不能达到O(1)，所以只能考虑堆排序
    public static void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

    public static void heapInsert(char[] chars, int i){
        int parent = 0;
        while (i != 0){
            parent = (i - 1) / 2;  //找第i个节点的父节点
            if (chars[i] > chars[parent]){
                swap(chars, parent, i);
                i = parent;
            }else {
                break;
            }
        }
    }

    public static void heapify(char[] chars, int i, int size){
        int left = 2 * i + 1;  //左节点
        int right = 2 * i + 2;  //右节点
        int largest = i;
        while (left < size){
            if (chars[i] < chars[left]){
                largest = left;
            }
            if (right < size && chars[largest] < chars[right]){
                largest = right;
            }
            if (largest != i){
                swap(chars, largest, i);
            }else {
                break;
            }
            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
    }

    public static void heapSort(char[] chars){
        for (int i = 0; i < chars.length; i++){
            heapInsert(chars, i);
        }
        for (int i = chars.length - 1; i > 0; i--){
            swap(chars, 0, i);
            heapify(chars, 0, i);
        }
    }

    public static boolean isUnique2(char[] chars){
        if (chars == null){
            return true;
        }
        heapSort(chars);
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == chars[i - 1]){
                return false;
            }
        }
        return true;
    }
}
