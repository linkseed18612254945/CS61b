package homework.hw02;

import java.util.ArrayList;
import java.util.Arrays;

public class PercolationStats
{
    private Percolation ExperimentPercolation;
    private int T;
    private int N;
    private int[] thresholds;

    public PercolationStats(int N, int T)
    {
        if (N <= 0 || T <= 0)
        {
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.T = T;
        thresholds = new int[T];
    }

    /** simulate once process, return the threshold */
    private int simulation()
    {
        ExperimentPercolation = new Percolation(N);
        int threshold = 0;
        while (!ExperimentPercolation.percolates())
        {
            ExperimentPercolation.randomOpen();
            threshold += 1;
        }
        return threshold;
    }

    public void MonteCarloSim()
    {
        for (int i = 0; i < T; i += 1)
        {
            thresholds[i] = simulation();
        }
    }

    /** sample mean of percolation threshold */
    public double mean()
    {
        int tempSum = 0;
        for (int threshold: thresholds)
        {
            tempSum += threshold;
        }
        return tempSum / T;
    }

    /** sample standard deviation of percolation threshold */
    public double stddev()
    {
        if (T == 1)
        {
            return Double.NaN;
        }
        double mean = mean();
        int tempSum = 0;
        for (int threshold: thresholds)
        {
            tempSum += (threshold - mean) * (threshold - mean);
        }
        return Math.sqrt(tempSum / (T - 1));
    }

    /** low endpoint of 95% confidence interval */
    public double confidenceLow()
    {
        return mean() - (1.96 * stddev() / Math.sqrt(T));
    }

    /** high endpoint of 95% confidence interval */
    public double confidenceHigh()
    {
        return mean() + (1.96 * stddev() / Math.sqrt(T));
    }

    public double vacancyProb()
    {
       return mean() / (N * N);
    }

    public void printThreshold()
    {
        System.out.println(Arrays.toString(thresholds));
    }


}                       
