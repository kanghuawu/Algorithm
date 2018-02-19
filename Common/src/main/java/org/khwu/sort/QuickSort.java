package org.khwu.sort;

public class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] arr) {
//        System.out.println(partition(arr, 0, arr.length-1));
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(arr, lo, hi);
        sort(arr, lo, p-1);
        sort(arr, p+1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo;
        int j = hi+1;
        while (i < j) {
            for (i++; i < hi && arr[i] < pivot; i++);
            for (j--; j > lo && arr[j] > pivot; j--);
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, lo, j);
        return j;
    }
}
