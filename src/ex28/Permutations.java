package ex28;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, permutation, result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            permutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, permutation, result);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = generatePermutations(nums);
        System.out.println("Permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}