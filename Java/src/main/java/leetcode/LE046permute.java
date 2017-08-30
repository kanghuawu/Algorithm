package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LE046Permute {
	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
	   if(tempList.size() == nums.length){
	      list.add(new ArrayList<>(tempList));
	   } else{
	      for(int i = 0; i < nums.length; i++){
	         if(tempList.contains(nums[i])) continue;
	         tempList.add(nums[i]);
	         System.out.print(nums[i]);
	         backtrack(list, tempList, nums);
	         System.out.println(tempList.get(tempList.size() - 1));
	         tempList.remove(tempList.size() - 1);
	      }
	   }
	}


	public static void main(String[] args){
		int[] arr = {1, 2, 3};
		LE046Permute test = new LE046Permute();
		System.out.println(test.permute(arr));
	}
}
