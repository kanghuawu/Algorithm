package leetcode;

import java.util.List;

public class LE136singleNumber {
    public int singleNumber(int[] nums) {
    	int re = 0;
        for(int num : nums){
        	re ^= num;
        }
        return re;
    }
    public static void main(String[] args){
//    	int[] nums = {2, 2, 7, 3, 3};
//    	LE136singleNumber test = new LE136singleNumber();
//    	System.out.println(test.singleNumber(nums));
//    	List<String> l = {"abc", "cde"};
//    	System.out.println(l.contains("abc"));
    	String s = "abc";
    	System.out.println(s.substring(1, 2));
    }
}
