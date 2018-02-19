package org.khwu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LE015ThreeSum {
    // MY Incorrect
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        int i = 0;
//        int j = nums.length - 1;
//        int k;
//        Arrays.sort(nums);
//        while(i < j - 1) {
//            int twoSum = nums[i] + nums[j];
//            if (twoSum > 0) {
//                k = i + 1;
//                while (twoSum + nums[k] < 0 && k < j) k++;
//                if (twoSum + nums[k] == 0) res.add(Arrays.asList(nums[i], nums[k], nums[j]));
//                while (nums[j] == nums[--j] && i < j) ;
//            }
//            else {
//                k = j - 1;
//                while (twoSum + nums[k] > 0 && k > i) k--;
//                if (twoSum + nums[k] == 0) res.add(Arrays.asList(nums[i], nums[k], nums[j]));
//                while (nums[i] == nums[++i] && i < j) ;
//            }
//        }
//        return res;
//    }

    // ref: https://discuss.leetcode.com/topic/45491/share-my-simple-java-solution
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            int j = nums.length - 1;
            int k = i + 1;
            while (k < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[k], nums[j]));
                System.out.println("bf: " + i + " " + k + " " + j);
                /*
                if (sum >= 0 && k < j) {
                    j--;
                    while (k < j && nums[j] == nums[j-1]) j--;
                }
                if (sum <= 0 && k < j) {
                    k++;
                    while (k < j && nums[k] == nums[k+1] ) k++;
                }
                 */
                if (sum >= 0 && k < j) while (k < j && nums[j] == nums[--j]);
                if (sum <= 0 && k < j) while (k < j && nums[k] == nums[++k]);

                System.out.println("af: " + i + " " + k + " " + j);
                System.out.println("==========");
            }
            while (nums[i] == nums[i+1] && i < nums.length - 2) i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        LE015ThreeSum test = new LE015ThreeSum();
//        System.out.println(test.threeSum(nums));
        int i = 0;
        System.out.println(nums[++i] == 0);
    }
}
