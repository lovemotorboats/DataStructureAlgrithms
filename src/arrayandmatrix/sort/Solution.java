package arrayandmatrix.sort;

//排序
public class Solution {

    //交换位置
    public static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    //冒泡排序
    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 0; j < a.length - 1 - i; j++){
                if (a[j] > a[j + 1]){
                    swap(a, j, j + 1);
                }
            }
        }
    }

    //选择排序
    public static void selectSort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[min] > a[j]){
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }

    //插入排序
    public static void insertSort(int[] a){
        for (int i = 1; i < a.length; i++){
            int in = i;
            int temp = a[i];
            while (in > 0 && a[in - 1] >= temp){
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }
    }

    //快速排序
    public static void quickSort(int[] a, int low, int high){
        if (low < high){
            int index = getIndex(a, low, high);
            quickSort(a, 0, index - 1);
            quickSort(a, index + 1, high);
        }
    }

    //快排核心算法
    public static int getIndex(int[] a, int low, int high){
        int temp = a[low];
        while (low < high){
            while (low < high && a[high] >= temp){
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    //堆排序
    // 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
    // 将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
    // 这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
    public static void adjustHeap(int[] a, int i, int len){
        //在大根堆的基础上调整堆
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1){  //从i的左子节点开始
            if (k + 1 < len && a[k] < a[k + 1]){
                //左子节点小于右子节点
                k++;
            }
            if (a[i] < a[k]){
                swap(a, i, k);
                i = k;
            }else {
                break;
            }
        }
    }

    //堆排序
    //1、先建大根堆（从第一个非叶子节点往前调整）
    //2、交换首尾元素后调整堆
    public static void heapSort(int[] a){
        for (int i = a.length / 2 - 1; i >= 0; i--){
            adjustHeap(a, i, a.length);
        }
        for (int j = a.length - 1; j > 0 ; j--){
            swap(a, 0, j);
            adjustHeap(a, 0, j);
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 6, 8, 1, -2, 7, -4};
//        heapSort(input);
//        quickSort(input, 0, input.length - 1);
//        insertSort(input);
//        selectSort(input);
        bubbleSort(input);
        for (int n : input){
            System.out.print(n + " ");
        }
    }
}
