package leetcode;

public class LE043Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int L1 = num1.length();
        int L2 = num2.length();
        int[] arr = new int[L1 + L2];
        for (int i = 0, k = 1; i < L1; i++) {
            for (int j = 0; j < L2; j++) {
                arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int m = arr.length - 1; m > 0; m--) {
            arr[m - 1] += arr[m] / 10;
            arr[m] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < arr.length; n++) {
            if (n == 0 && arr[n] == 0) continue;
            sb.append(arr[n]);
        }
        return sb.toString();
    }
}
