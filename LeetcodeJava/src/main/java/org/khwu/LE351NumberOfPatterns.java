package org.khwu;

public class LE351NumberOfPatterns {
    // MY
    private int count;
    private boolean[] visited;
    private int min;
    private int max;
    public int numberOfPatterns(int m, int n) {
        count = 0;
        visited = new boolean[10];
        min = m;
        max = n;
        for (int i = 1; i < 10; i++) {
            dfs(i, 1);
        }
        return count;
        /*
        dfs(1, 1);
        int prevCount = 0;
        int count1379 = (count - prevCount) * 4;
        prevCount = count;
        dfs(2, 1);
        int count2468 = (count - prevCount) * 4;
        prevCount = count;
        dfs(5, 1);
        int count5 = count - prevCount;
        return count1379 + count2468 + count5;
         */
    }

    private void dfs(int curr, int idx) {
        if (idx > max)
            return;
        if (idx >= min)
            count++;

        visited[curr] = true;
        for (int i = 1; i < 10; i++) {
            if (isValid(curr, i)) {
                dfs(i, idx + 1);
            }
        }
        visited[curr] = false;
    }

    private boolean isValid(int curr, int next) {
        if (visited[next])
            return false;
        int rowDelta = Math.abs((curr - 1) / 3 - (next - 1) / 3);
        int colDelta = Math.abs((curr - 1) % 3 - (next - 1) % 3);
        if ((rowDelta == 0 && colDelta == 2) || (rowDelta == 2 && colDelta == 0) || (rowDelta == 2 && colDelta == 2))
            return visited[(next + curr) / 2];
        return true;
    }
}
