package org.khwu.sort;

public class ShellSort implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        int size = arr.length;

        int h = 0;
        while (h < size / 3) {
            h = 3*h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < size; i++) {
                int k = i;
                while(k-h >= 0 && arr[k] < arr[k-h]) {
                    swap(arr, k, k-h);
                    k -= h;
                }
            }
            h /= 3;
        }
    }
}
