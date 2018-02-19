package p11_percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;
import java.lang.Math;

public class PercolationStats {
    // perform trials independent experiments on an n-by-n grid

    private final double mean;
    private final double stddev;
    private final double confidenceHi;
    private final double confidenceLo;
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("Invalid number n: " + Integer.toString(n) 
                + " trial: " + Integer.toString(trials));

        double[] result = new double[trials];

        int[] randomPosition = new int[n*n];
            
        for (int i=0; i<n*n; i++) {
            randomPosition[i] = i;
        }

        int row;
        int col;

        for (int i=0; i<trials; i++) {
            Percolation p = new Percolation(n);
            
            StdRandom.shuffle(randomPosition);
            
            for (int j=0; j<randomPosition.length && !p.percolates(); j++) {
                row = randomPosition[j]/n+1;
                col = randomPosition[j]%n+1;
                p.open(row, col);
            }

            result[i] = (double) p.numberOfOpenSites()/(double)(n*n);
        }

        mean = StdStats.mean(result);
        stddev = StdStats.stddev(result);
        confidenceHi = mean + 1.96*stddev/Math.sqrt(trials);
        confidenceLo = mean - 1.96*stddev/Math.sqrt(trials);
    }

    // sample mean of percolation threshold
    public double mean(){
        return mean;
    }
    
    // sample standard deviation of percolation threshold
    public double stddev(){
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo(){
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return confidenceHi;
    }

    // test client (described below)
    public static void main(String[] args){
        if (args.length != 2)
            throw new IllegalArgumentException("Need exactly 2 arguments, given " 
                + String.valueOf(args.length));
        
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, trials);
        
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" 
            + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
