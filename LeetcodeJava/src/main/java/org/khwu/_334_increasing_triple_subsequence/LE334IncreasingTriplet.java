package org.khwu._334_increasing_triple_subsequence;

public class LE334IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first) first = n;
            else if (n <= second) second = n;
            else return true;
        }
        return false;
    }
}
