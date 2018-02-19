package org.khwu;

public class LE418WordsTyping {
    // MY Time Limit Exceeded
//    public int wordsTyping(String[] sentence, int rows, int cols) {
//        int selectWord = 0;
//        int count = 0;
//        for (int i = 0; i < rows; i++) {
//            int remain = cols;
//            while (remain >= sentence[selectWord].length()) {
//                remain -= sentence[selectWord].length();
//                remain--;
//                selectWord++;
//                if (selectWord == sentence.length) count++;
//                selectWord %= sentence.length;
//            }
//        }
//        return count;
//    }

    public int wordsTyping(String[] sentence, int rows, int cols) {

        int[] jump = new int[sentence.length];
        int n = sentence.length;
        for (int i = 0, j = 0, len = 0; i < n; i++) {

            if (i != 0 && len > 0) len -= sentence[i - 1].length() + 1;

            while (len + sentence[j % sentence.length].length() <= cols) {
                len += sentence[j % sentence.length].length() + 1;
                j++;
            }
            jump[i] = j;
        }
        //System.out.println(Arrays.toString(jump));
        int count = 0;
        for (int i = 0, k = 0; i < rows; i++) {
            count += jump[k] - k;
            k = jump[k] % n;
        }
        return count / n;
    }
}
