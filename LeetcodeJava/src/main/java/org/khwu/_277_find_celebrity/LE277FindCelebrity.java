package org.khwu._277_find_celebrity;

public class LE277FindCelebrity {
    public int findCelebrity(int n) {
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (knows(c, i)) c = i;
        }

        for (int i = 0; i < n; i++) {
            if (i == c) continue;
            if (!knows(i, c) || knows(c, i)) return -1;
        }
        return c;
    }

//    public int findCelebrity(int n) {
//        int i = 0;
//        int j = n - 1;
//        int c = i;
//        int non = j;
//        while (i < j) {
//            if (knows(non, c)) {
//                if (non == j) {
//                    j--;
//                    non = j;
//                } else {
//                    i++;
//                    non = i;
//                }
//            } else {
//                if (c == i) {
//                    i++;
//                    c = non;
//                    non = i;
//                } else {
//                    j--;
//                    c = non;
//                    non = j;
//                }
//            }
//        }
//
//        for (int k = 0; k < n; k++) {
//            if (k == c) continue;
//            if (!knows(k, c) || knows(c, k)) return -1;
//        }
//        return c;
//    }

    private boolean knows(int a, int b) {
        return true;
    }
}
