package org.khwu._046_permutations;

import java.util.ArrayList;
import java.util.List;

public class LE046PermuteDFS {
	// ref: https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
//	public List<List<Integer>> permute(int[] nums) {
//		   List<List<Integer>> list = new ArrayList<>();
//		   backtrack(list, new ArrayList<>(), nums);
//		   return list;
//	}
//
//	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
//	   if(tempList.size() == nums.length){
//	      list.add(new ArrayList<>(tempList));
//	   } else{
//	      for(int i = 0; i < nums.length; i++){
//	         if(tempList.contains(nums[i])) continue;
//	         tempList.add(nums[i]);
//	         System.out.print(nums[i]);
//	         backtrack(list, tempList, nums);
//	         System.out.println(tempList.get(tempList.size() - 1));
//	         tempList.remove(tempList.size() - 1);
//	      }
//	   }
//	}

    // MY 2017-1-3
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> per, List<List<Integer>> res) {
        if (per.size() == nums.length) {
            res.add(new ArrayList<>(per));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            per.add(nums[i]);
            dfs(nums, used, per, res);
            used[i] = false;
            per.remove(per.size() - 1);
        }
    }

	// MY
//	private List<List<Integer>> res;
//	public List<List<Integer>> permute(int[] nums) {
//		res = new ArrayList<>();
//
//		permuteHelper(nums, new ArrayList<Integer>());
//
//		return res;
//	}
//	private void permuteHelper(int[] nums, List<Integer> arr) {
//		if (nums.length == arr.size())
//			res.add(new ArrayList<Integer>(arr));
//		for (int i = 0; i < nums.length; i++) {
//			if (!arr.contains(nums[i])) {
//				arr.add(nums[i]);
//				permuteHelper(nums, arr);
//				arr.remove(arr.size() - 1);
//			}
//		}
//	}

	// ref: https://discuss.leetcode.com/topic/10812/share-my-short-iterative-java-solution
//	public List<List<Integer>> permute(int[] num) {
//		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
//		res.add(new ArrayList<Integer>());
//		for (int n : num) {
//			int size = res.size();
//			for (; size > 0; size--) {
//				List<Integer> r = res.pollFirst();
//				for (int i = 0; i <= r.size(); i++) {
//					List<Integer> t = new ArrayList<Integer>(r);
//					t.add(i, n);
//					res.add(t);
//				}
//			}
//		}
//		return res;
//	}

	public static void main(String[] args){
//		int[] arr = {1, 2, 3};
//		LE046PermuteDFS test = new LE046PermuteDFS();
//		System.out.println(test.permute(arr));
        System.out.println(3%1);
	}
}
