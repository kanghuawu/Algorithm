package org.khwu.search;

public class BinarySearch {

    public static int search(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int len = arr.length;
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] < num) i = mid + 1;
            else if (arr[mid] > num) j = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 6, 7, 8, 10, 15, 25, 34};
        System.out.println(search(arr, 6));
    }
}
