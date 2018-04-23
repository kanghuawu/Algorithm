package org.khwu._286_walls_and_gates;

import java.util.Deque;
import java.util.LinkedList;

public class LE286WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.addLast(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.removeFirst();
            int x = tmp[0];
            int y = tmp[1];
            if (x - 1 >= 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
                rooms[x - 1][y] = rooms[x][y] + 1;
                q.addLast(new int[]{x - 1, y});
            }
            if (x + 1 < m && rooms[x + 1][y] == Integer.MAX_VALUE) {
                rooms[x + 1][y] = rooms[x][y] + 1;
                q.addLast(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && rooms[x][y - 1] == Integer.MAX_VALUE) {
                rooms[x][y - 1] = rooms[x][y] + 1;
                q.addLast(new int[]{x, y - 1});
            }
            if (y + 1 < n && rooms[x][y + 1] == Integer.MAX_VALUE) {
                rooms[x][y + 1] = rooms[x][y] + 1;
                q.addLast(new int[]{x, y + 1});
            }
        }
    }
}
