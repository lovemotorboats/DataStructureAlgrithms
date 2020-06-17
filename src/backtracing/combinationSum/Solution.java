package backtracing.combinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 
//中所有可以使数字和为 target 的组合（重复组合只保留一个，比如[2, 3]和[3, 2]算重复）
public class Solution {

    //第一题:candidates中的数字不重复，但每个数字可以无限制重复被选取
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs1(0, target, candidates, new LinkedList<>(), result);
        return result;
    }

    public static void dfs1(int index, int target, int[] candidates, LinkedList<Integer> pre, List<List<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> list = new ArrayList<>(pre);
            result.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                pre.addLast(candidates[i]);
                dfs1(i, target - candidates[i], candidates, pre, result);
                //回溯到上一状态要将pre中最后的元素弹出
                pre.removeLast();
            }
        }
    }

    //第二题:candidates中的数字不重复，且每个数字不能重复被选取
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs2(0, target, candidates, new LinkedList<>(), result);
        return result;
    }

    public static void dfs2(int index, int target, int[] candidates, LinkedList<Integer> pre, List<List<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> list = new ArrayList<>(pre);
            result.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                pre.addLast(candidates[i]);
                dfs2(i + 1, target - candidates[i], candidates, pre, result);
                //回溯到上一状态要将pre中最后的元素弹出
                pre.removeLast();
            }
        }
    }
    //第三题：candidates可能有重复元素，一个元素可以最多被选中本身重复次数那么多次，
    //例如假设有两个1那么1可以被选择两次。

    public static void main(String[] args) {
        int[] candidates = {3, 5, 2, 6, 8};
        List<List<Integer>> lists1 = combinationSum1(candidates, 8);
        for (List<Integer> list : lists1) {
            System.out.println(list.toString());
        }
        System.out.println("===================================");
        List<List<Integer>> lists2 = combinationSum2(candidates, 8);
        for (List<Integer> list : lists2) {
            System.out.println(list.toString());
        }
    }
}
