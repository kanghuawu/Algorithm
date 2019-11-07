package org.khwu.search;

public class BinarySearch {

    public static int search(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int len = arr.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < num) i = mid + 1;
            else if (arr[mid] > num) j = mid - 1;
            else return mid;
        }
        return i;
    }

    public static int searchDefer(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int len = arr.length;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < num) i = mid + 1;
            else j = mid;
        }
        return i;
    }

    public static int searchArithmeticProgression(int[] nums) {
        int n = nums.length;
        int le = 0, ri = n - 1;
        int start = nums[le], diff = (nums[ri] - nums[le]) / n;
        while (le < ri) {
            int mid = le + (ri - le) / 2;
            if (start + diff * mid < nums[mid]) {
                ri = mid;
            } else {
                le = mid + 1;
            }
        }
        return nums[le] - diff;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 2, 2, 2, 6, 7, 8, 10, 15, 25, 34};
//        int num = 2;
//        System.out.println(search(arr, num)); // 2
//        System.out.println(searchDefer(arr, num)); // 1
//        System.out.println((char)('a' - 32));
        System.out.println(searchArithmeticProgression(new int[]{1, 3, 5, 7, 9, 11}));
    }
}
