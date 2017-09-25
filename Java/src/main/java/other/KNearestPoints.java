package other;

import java.util.Arrays;

public class KNearestPoints {

    // ref: http://www.geeksforgeeks.org/find-k-closest-elements-given-value/
    // MY
    public int[] findKNearestPoints(int[] arr, int k, int x) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] < x)
                low = mid + 1;
            else if (arr[mid] > x)
                high = mid - 1;
            else
                break;
        }

        System.out.println(mid);
        System.out.println(Arrays.toString(arr));
        return helper(arr, mid, k, x);

    }

    private int[] helper(int[] arr, int i, int k, int x) {
        int lower = i;
        int upper = i;

        while (upper - lower < k - 1) {
            if (lower > 0 && (upper == arr.length - 1 || x - arr[lower - 1] < arr[upper + 1] - x))
                lower--;
            else
                upper++;
        }
        int[] res = new int[k];
        for (int j = lower, m = 0; j <= upper; j++, m++) {
            res[m] = arr[j];
        }

        return res;
    }
    public static void main(String[] args) {
        KNearestPoints kn = new KNearestPoints();
        int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        System.out.println(Arrays.toString(kn.findKNearestPoints(arr, 4, 42)));
    }
}
