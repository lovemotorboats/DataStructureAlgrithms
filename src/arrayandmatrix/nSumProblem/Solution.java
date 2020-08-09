package arrayandmatrix.nSumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// N_sum问题，在一个数组中找出所有n个数的组合，使得这n个数的和等于target。（返回结果集中不可含有重复答案）
public class Solution {

    //1、tow_sum问题：如果假设输入一个数组 nums 和一个目标和 target，
    //请你返回 nums 中能够凑出 target 的两个元素的值
    public static List<int[]> towSum(int[] arr, int target) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(arr);  //先排序
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            int left = arr[low], right = arr[high];
            if (sum < target) {
                while (low < high && arr[low] == left) {
                    low++;
                }
            } else if (sum > target) {
                while (low < high && arr[high] == right) {
                    high--;
                }
            } else {
                res.add(new int[]{arr[low], arr[high]});
                while (low < high && arr[low] == left) {
                    left++;
                }
                while (low < high && arr[high] == right) {
                    high--;
                }
            }
        }
        return res;
    }

    //2、n_sum问题（启发于towSumw问题，递归）
    public static List<List<Integer>> nSum(int[] arr, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = arr.length;
        if (n < 2 || len < n) {
            return res;  //至少是2_sum问题，且n不能超过nums的长度
        }
        if (n == 2) {  //base case
            int low = start, high = len - 1;
            while (low < high) {
                int sum = arr[low] + arr[high];
                int left = arr[low], right = arr[high];
                if (sum > target) {
                    while (low < high && arr[high] == right) {
                        high--;
                    }
                }else if (sum < target) {
                    while (low < high && arr[low] == left) {
                        low++;
                    }
                }else {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(arr[high]);
                    list.add(arr[low]);
                    res.add(list);
                    while (low < high && arr[high] == right) {
                        high--;
                    }
                    while (low < high && arr[low] == left) {
                        low++;
                    }
                }
            }
        }else {
            for (int i = start; i < len; i++) {
                List<List<Integer>> lists = nSum(arr, n - 1, i + 1, target - arr[i]);
                for (List<Integer> list : lists) {
                    list.add(arr[i]);
                    res.add(list);
                }
                while (i < len - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
//        List<int[]> ints = towSum(arr, 1);
//        for (int[] anInt : ints) {
//            System.out.println(anInt[0] + " " + anInt[1]);
//        }
        Arrays.sort(arr);
        List<List<Integer>> lists = nSum(arr, 4, 0, -1);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
