package org.khwu.sort;

public class InsertionSort implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
                j--;
            }
        }
    }
}
