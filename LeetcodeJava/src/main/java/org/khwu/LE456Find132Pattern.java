package org.khwu;

public class LE456Find132Pattern {
	public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        int first = 0;
        int second = 1;
        int temp_min;
        if(nums[first] > nums[second]) temp_min = second;
        else temp_min = first;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] < nums[temp_min]) temp_min = i;
            
            if(nums[i] < nums[second] && nums[i] > nums[first]) return true;
            else if(nums[i] > nums[second]){
                 second = i;
                 if(first < temp_min) first = temp_min;
            }else if(nums[i] > nums[temp_min]){
                second = i;
                first = temp_min;
            }
            // System.out.println(first + " " + second + " " + temp_min);
        }
        return false;
    }
}
