package leetcode;

public class LE033Search {
    // MY
    // ref: https://discuss.leetcode.com/topic/16580/java-ac-solution-using-once-binary-search
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && target < nums[mid])
                    j = mid - 1;
                else
                    i = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[j])
                    i = mid + 1;
                else
                    j = mid - 1;
            }
            // System.out.println(i + " " + j);
        }
        return -1;
    }

    // ref: https://discuss.leetcode.com/topic/3538/concise-o-log-n-binary-search-solution
//    public int search(int[] nums, int target) {
//        int minIdx = findMinIdx(nums);
//        if (target == nums[minIdx]) return minIdx;
//        int m = nums.length;
//        int start = (target <= nums[m - 1]) ? minIdx : 0;
//        int end = (target > nums[m - 1]) ? minIdx : m - 1;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) return mid;
//            else if (target > nums[mid]) start = mid + 1;
//            else end = mid - 1;
//        }
//        return -1;
//    }
//
//    public int findMinIdx(int[] nums) {
//        int start = 0, end = nums.length - 1;
//        while (start < end) {
//            int mid = start + (end -  start) / 2;
//            if (nums[mid] > nums[end]) start = mid + 1;
//            else end = mid;
//        }
//        return start;
//    }
}
