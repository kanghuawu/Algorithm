package org.khwu._151_reverse_words_in_a_string;

import java.util.Arrays;

public class LE151ReverseWordsTwoPointer {
    public String reverseWords(String s) {
        char[] arr = s.trim().toCharArray();
        int n = arr.length;
        reverse(arr, 0, n - 1);
//        System.out.println(Arrays.toString(arr));
        reverseWord(arr, n);
//        System.out.println(Arrays.toString(arr));
        return cleanSpace(arr, n);
    }

    private String cleanSpace(char[] arr, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && arr[j] == ' ') j++;
            while (j < n && arr[j] != ' ') {
                arr[i++] = arr[j++];
            }
            if (j < n) arr[i++] = ' ';
        }
        System.out.println(i);
//        if (i < n && arr[i] == ' ') i--;
        return new String(arr).substring(0, i);
    }

    private void reverseWord(char[] arr, int n) {
        int i = 0;
        while (i < n) {
            while (i < n && arr[i] == ' ') i++;
            int j = i;
            while (j < n && arr[j] != ' ') j++;
            reverse(arr, i, j-1);
            i = j + 1;
        }
    }

    private void reverse(char[] arr, int i, int j) {
        for (; i < j; i++, j--) {
            swap(arr, i, j);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        LE151ReverseWordsTwoPointer test = new LE151ReverseWordsTwoPointer();
        System.out.println(test.reverseWords("the sky is blue"));
    }
}
