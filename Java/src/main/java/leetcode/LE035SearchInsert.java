package leetcode;

public class LE035SearchInsert {
    // MY
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (nums[mid] > target)
                j = mid;
            else if (nums[mid] < target)
                i = mid + 1;
            else
                return mid;
        }
        if (nums[i] < target)
            return i + 1;
        return i;
    }

    // ref: https://discuss.leetcode.com/topic/7874/my-8-line-java-solution
//    public int searchInsert(int[] A, int target) {
//        int low = 0, high = A.length-1;
//        while(low<=high){
//            int mid = (low+high)/2;
//            if(A[mid] == target) return mid;
//            else if(A[mid] > target) high = mid-1;
//            else low = mid+1;
//        }
//        return low;
//    }
}
