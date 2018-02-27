package org.khwu._042_trapping_rain_water;

public class LE042Trap {
    // two pointer
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int le = 0;
        int ri = height.length - 1;
        int leMax = height[le];
        int riMax = height[ri];
        int sum = 0;
        while (le <= ri) {
            if (leMax < riMax) {
                leMax = Math.max(height[le], leMax);
                sum += leMax - height[le++];
            } else {
                riMax = Math.max(height[ri], riMax);
                sum += riMax - height[ri--];
            }
        }
        return sum;
    }

    // MY two pointer
    public int trapMy(int[] height) {
        if (height.length == 0) return 0;
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= max) {
                max = height[i];
                maxIdx = i;
            }
        }
        int sum = 0;
        int leftMax = height[0];
        for (int i = 1; i < maxIdx; i++) {
            if (leftMax < height[i]) {
                leftMax = height[i];
            } else {
                sum += leftMax - height[i];
            }
        }

        int rightMax = height[height.length-1];
        for (int i = height.length - 1; i > maxIdx; i--) {
            if (rightMax < height[i]) {
                rightMax = height[i];
            } else {
                sum += rightMax - height[i];
            }
        }
        return sum;
    }
}
