package leetcode;

import java.util.HashMap;

public class LE013RomanToInt {
	//MYMY
	private static HashMap<Character, Integer> RomIntMap = new HashMap<Character, Integer>();
	static{
	    RomIntMap.put('I', 1);
	    RomIntMap.put('V', 5);
	    RomIntMap.put('X', 10);
	    RomIntMap.put('L', 50);
	    RomIntMap.put('C', 100);
	    RomIntMap.put('D', 500);
	    RomIntMap.put('M', 1000);
	}
    public int romanToInt(String s) {
        Integer result = 0;
        for(int i = 0; i < s.length(); i++){
            if(i + 1 != s.length() && RomIntMap.get(s.charAt(i)) < RomIntMap.get(s.charAt(i + 1))){
                result -= RomIntMap.get(s.charAt(i));
            }else{
                result += RomIntMap.get(s.charAt(i));
            }
        }
        return result;
    }
    
    
//    public int romanToInt(String s) {
//        int nums[]=new int[s.length()];
//        for(int i=0;i<s.length();i++){
//            switch (s.charAt(i)){
//                case 'M':
//                    nums[i]=1000;
//                    break;
//                case 'D':
//                    nums[i]=500;
//                    break;
//                case 'C':
//                    nums[i]=100;
//                    break;
//                case 'L':
//                    nums[i]=50;
//                    break;
//                case 'X' :
//                    nums[i]=10;
//                    break;
//                case 'V':
//                    nums[i]=5;
//                    break;
//                case 'I':
//                    nums[i]=1;
//                    break;
//            }
//        }
//        int sum=0;
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]<nums[i+1])
//                sum-=nums[i];
//            else
//                sum+=nums[i];
//        }
//        return sum+nums[nums.length-1];
//    }
}
