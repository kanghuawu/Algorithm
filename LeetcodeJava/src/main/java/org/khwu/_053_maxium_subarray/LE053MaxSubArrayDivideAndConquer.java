package org.khwu._053_maxium_subarray;

public class LE053MaxSubArrayDivideAndConquer {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (left + right)/2;
        int leftMax = divideAndConquer(nums, left, mid);
        int rightMax = divideAndConquer(nums, mid + 1, right);
        int sum = 0;
        int leftTemp = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftTemp = Math.max(leftTemp, sum);
        }
        sum = 0;
        int rightTemp = Integer.MIN_VALUE;
        for (int i = mid; i <= right; i++) {
            sum += nums[i];
            rightTemp = Math.max(rightTemp, sum);
        }
        return Math.max(Math.max(rightTemp + leftTemp - nums[mid], leftMax), rightMax);
    }

    public static void main(String[] args) {
        LE053MaxSubArrayDivideAndConquer le053MaxSubArray = new LE053MaxSubArrayDivideAndConquer();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(le053MaxSubArray.maxSubArray(arr));
        System.out.println((char) 2);
    }
}
