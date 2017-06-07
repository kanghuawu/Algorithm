package leetcode;

import java.util.Arrays;

public class LE198rob {
//    public int rob(int[] nums) {
//    	if(nums.length == 3){
//    		return Math.max(nums[0] + nums[2], nums[1]);
//    	}else if(nums.length == 2){
//        	return Math.max(nums[0], nums[1]);
//        }else if(nums.length == 1){
//        	return nums[0];
//        }else if(nums.length == 0){
//        	return 0;
//        }else{
//        	int[] numR = new int[nums.length - 2];
//        	int[] numL = new int[nums.length - 2]; 
//        	System.arraycopy(nums, 2, numR, 0, nums.length - 2);
//        	System.arraycopy(nums, 3, numL, 0, nums.length - 3);
//        	int right = nums[0] + rob(numR);
//        	int left = nums[1] + rob(numL);
//        	return right > left ? right : left;
//        }
//    }
	
//    public int rob(int[] nums) {
//    	if(nums.length == 3){
//    		return Math.max(nums[0] + nums[2], nums[1]);
//    	}else if(nums.length == 2){
//        	return Math.max(nums[0], nums[1]);
//        }else if(nums.length == 1){
//        	return nums[0];
//        }else if(nums.length == 0){
//        	return 0;
//        }else{
//        	int[] numR = new int[nums.length - 2];
//        	int[] numL = new int[nums.length - 2]; 
//        	System.arraycopy(nums, 2, numR, 0, nums.length - 2);
//        	System.arraycopy(nums, 3, numL, 0, nums.length - 3);
//        	int right = nums[0] + rob(numR);
//        	int left = nums[1] + rob(numL);
//        	return right > left ? right : left;
//        }
//    }
	
	public int rob(int[] num) {
	    int rob = 0; //max monney can get if rob current house
	    int notrob = 0; //max money can get if not rob current house
	    for(int i=0; i<num.length; i++) {
	        int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
	        notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
	        rob = currob;
	    }
	    return Math.max(rob, notrob);
	}
	
    public static void main(String[] args){
		int[] num = {155,44,52,58,250,225,109,118,211,73,137,96,137,89,174,66,134,26,25,205,239,85,146,73,55,6,122,196,128,50,61,230,94,208,46,243,105,81,157,89,205,78,249,203,238,239,217,212,241,242,157,79,133,66,36,165};
		LE198rob test = new LE198rob();
		System.out.println(test.rob(num));
	}
}
