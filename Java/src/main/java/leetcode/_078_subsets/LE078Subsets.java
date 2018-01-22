package leetcode._078_subsets;

import java.util.ArrayList;
import java.util.List;

public class LE078Subsets {
    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        result = new ArrayList<List<Integer>>();
        subsetsHelper(0, new ArrayList<Integer>());
        return result;
    }

    private void subsetsHelper(int curr, List<Integer> arr){
    	System.out.println(arr);
		result.add(new ArrayList<Integer>(arr));
		
		for(int i=curr; i<nums.length; i++) {
			
			arr.add(nums[i]);
	        subsetsHelper(curr+1, arr);
	        
	        arr.remove(arr.size()-1);
	        
		}
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        LE078Subsets sb = new LE078Subsets();
        System.out.println(sb.subsets(nums));
    }
}
