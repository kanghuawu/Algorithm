package org.khwu.sort;

public class MergeSort implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        sort(arr, new int[arr.length],0, arr.length-1);
    }

    private void sort(int[] arr, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int j = lo;
        int k = mid+1;
        for (int i = lo; i <= hi; i++) {
            if (j > mid) {
                arr[i] = aux[k++];
            } else if (k > hi) {
                arr[i] = aux[j++];
            } else if (aux[j] < aux[k]) {
                arr[i] = aux[j++];
            } else {
                arr[i] = aux[k++];
            }
        }
    }
}
