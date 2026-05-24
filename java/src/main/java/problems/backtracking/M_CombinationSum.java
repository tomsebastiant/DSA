package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: 39
 * Tags: Array
 * Tags: DFS
 * https://leetcode.com/problems/combination-sum/
 * Given an array of distinct integers candidates and a target integer target, return all unique
 * combinations of candidates where the chosen numbers sum to target. The same number may be
 * chosen from candidates an unlimited number of times. The combinations may be returned in
 * any order.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Approach: Backtracking with a start index to build combinations (order doesn't matter, so
 * loop from start each time). Recurse with the same index i to allow reuse of the same element.
 * Prune early when candidates[i] exceeds the remaining target (array is sorted).
 */
public class M_CombinationSum {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target,0, new ArrayList<>(),result);
        return result;
    }

    public void backtrack(int[] candidates, int remain, int start, List<Integer> curr,List<List<Integer>> result){
        if(remain==0){
            result.add(new ArrayList(curr));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>remain) return;
            curr.add(candidates[i]);
            backtrack(candidates,remain-candidates[i],i,curr,result);
            curr.remove(curr.size()-1);
        }
    }
}
