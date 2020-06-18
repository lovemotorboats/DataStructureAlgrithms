import java.util.*;

//1到n的全排列(0 <= n <= 9)
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> getPermutations(int[] nums) {
        backTrace(nums, new ArrayList<>());
        return res;
    }

    public void backTrace(int[] nums, List<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (Integer choice : nums) {
            //排除不合法的选择
            if (track.contains(choice)) {
                continue;
            }

            //做选择
            track.add(choice);

            //进入下一层决策树
            backTrace(nums, track);

            //取消选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s  = new Solution();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> permutations = s.getPermutations(nums);
        for (List<Integer> permutation : permutations) {
            for (Integer integer : permutation) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
