package org.khwu._477_total_hamming_distance;

public class LE477TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += (nums[j] >> i) & 1;
            }
            total += count * (n - count);
        }
        return total;
    }
}
