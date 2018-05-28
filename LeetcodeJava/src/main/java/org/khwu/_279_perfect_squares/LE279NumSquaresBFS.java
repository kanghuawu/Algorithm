package org.khwu._279_perfect_squares;

import java.util.ArrayDeque;
import java.util.Deque;

public class LE279NumSquaresBFS {
    public int numSquares(int n) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        int count = 1;
        while (true) {
            Deque<Integer> tmp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int num = q.removeFirst();
                for (int i = 1; i * i <= n; i++) {
                    if (num + i * i == n) return count;
                    tmp.addLast(num + i * i);
                }
            }
            q = tmp;
            count++;
        }
    }

    public static void main(String[] args) {
        LE279NumSquaresBFS test = new LE279NumSquaresBFS();
        System.out.println(test.numSquares(7168));
    }
}
