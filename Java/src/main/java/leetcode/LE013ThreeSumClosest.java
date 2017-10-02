package leetcode;

import java.util.Arrays;

public class LE013ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = 0;
        int closest = nums[0] + nums[1] + nums[nums.length - 1];
        int min = 0;
        for (int i = 0, j = 0, k = nums.length - 1; i < k - 1; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j != k) {
                temp = nums[i] + nums[j] + nums[k];
                if (Math.abs(temp - target) < Math.abs(closest - target))
                    closest = temp;
                if (temp > target)
                    k--;
                else if(temp < target)
                    j++;
                else
                    break;
            }
        }
        return closest;
    }
}
