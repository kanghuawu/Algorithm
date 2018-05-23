package org.khwu._698_partition_to_k_equal_sum_subsets;

public class LE698CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, k, visited, 0, sum / k, 0);
    }

    private boolean dfs(int[] nums, int k, boolean[] visited, int idx, int tar, int curSum) {
        if (k == 0) return true;
        if (curSum > tar) return false;
        if (curSum == tar) return dfs(nums, k - 1, visited, 0, tar, 0);

        for (int i = idx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, k, visited, idx + 1, tar, curSum + nums[i])) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
