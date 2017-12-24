package leetcode;

public class LE374GuessNumber {
    private int guess(int num){
        return 1;
    }

    public int guessNumber(int n) {
        int low = 1;
        int hi = n;

        while (low <= hi) {
            int mid = low+(hi-low)/2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            }
            if (guess < 0) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
