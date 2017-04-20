package homework.hw02;

import jh61b.junit.TestRunner;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * Created by 51694 on 2017/4/20.
 */
public class PercolateTest
{
    @Test
    public void PercolateStatsTest()
    {
        PercolationStats test = new PercolationStats(45, 300);
        test.MonteCarloSim();
        test.printThreshold();
        System.out.println(test.mean());
        System.out.println(test.vacancyProb());
        System.out.println(test.stddev());
        System.out.println("[" + test.confidenceLow() + ", " + test.confidenceHigh() + "]");
    }

    public static void main(String[] args)
    {
        TestRunner.runTests("all", PercolateTest.class);
    }
}
