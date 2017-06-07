package leetcode;

import java.util.Arrays;

public class LE169majorityElement {
	public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }
    public static void main(String[] arg){
    	int[] nums = {2, 1, 1, 1, 2};
    	LE169majorityElement test = new LE169majorityElement();
    	System.out.println(test.majorityElement(nums));
    }
}
