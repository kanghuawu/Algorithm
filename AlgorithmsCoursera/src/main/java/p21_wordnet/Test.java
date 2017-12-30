package p21_wordnet;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Test {
    public static void main(String[] args) {
        In in = new In(args[0]);
        while (in.hasNextLine()) {
            String[] nums = in.readLine().split(",");
            StdOut.println(Arrays.toString(nums));
            // if (nums.length > 1)
            //     StdOut.println(nums[0] + " " + nums[1]);
            // else
            //     StdOut.println(nums[0]);
        }
    }
}