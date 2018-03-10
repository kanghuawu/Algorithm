package org.khwu._621_task_scheduler;

public class LE632LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int nT = tasks.length;
        int[] count = new int[26];
        int max = 0;
        int maxL = 0;
        for (int i = 0; i < nT; i++) {
            count[tasks[i] - 'A']++;
            if (max < count[tasks[i] - 'A']) {
                maxL = 1;
                max = count[tasks[i] - 'A'];
            } else if (max == count[tasks[i] - 'A']) {
                maxL++;
            }
        }

        return Math.max(nT, (max - 1) * (n + 1) + maxL);
    }
}
