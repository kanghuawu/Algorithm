package notebook.sort;


public class Inversions {
    private int inversions;
    public int countInversions(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return inversions;
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi)/2;
        sort(arr, lo, mid);
        sort(arr,mid+1, hi);
        merge(arr, new int[arr.length], lo, mid, hi);
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
                inversions += mid - j + 1;
                arr[i] = aux[k++];
            }
        }
    }

    public static void main(String[] args) {
        Inversions inversions = new Inversions();
        int[] arr = new int[]{5, 4, 3, 2, 1, 0};
        System.out.println(inversions.countInversions(arr));
    }
}
