package notebook.sort;

import java.util.Random;

public class Test {
    private static void setUpArray(int[] arr) {
        Random random = new Random(1000);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%2d ", arr[i]);
        }
        System.out.println();
    }

    private static boolean checkSorted(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                isSorted = false;
            }
        }
        if (isSorted) {
            System.out.println("Array sorted");

        } else {
            System.out.println("Array NOT sorted");
        }
        return isSorted;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        setUpArray(arr);
        assert checkSorted(arr) == false;
        SortStrategy ss = new QuickSort();
        System.out.println("Before sort");
        printArray(arr);
        ss.sort(arr);
        System.out.println("After sort");
        printArray(arr);
        assert checkSorted(arr);
    }
}
