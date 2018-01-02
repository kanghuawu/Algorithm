package leetcode._070_climb_stairs;

public class LE070ClimbStairs {
    public int climbStairs(int n) {
        int dpEven = 1;
        int dpOdd = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dpEven += dpOdd;
            } else {
                dpOdd += dpEven;
            }
        }
        if (n % 2 == 0) {
            return dpEven;
        }
        return dpOdd;
    }
}
