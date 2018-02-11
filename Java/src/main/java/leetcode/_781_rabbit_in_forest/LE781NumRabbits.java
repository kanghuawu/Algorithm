package leetcode._781_rabbit_in_forest;

import java.util.Arrays;

public class LE781NumRabbits {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int res = 0;
        int acc = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                res++;
            } else if (i > 0 && answers[i] == answers[i-1] && acc > 0) {
                acc--;
            } else {
                acc = answers[i];
                res += answers[i] + 1;
            }
        }
        return res;
    }
}
