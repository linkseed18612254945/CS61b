package homework.hw02;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
    private class Site
    {
        int rowPos, colPos;
        boolean isOpen;


        Site(int row, int col)
        {
            rowPos = row;
            colPos = col;
            isOpen = false;
        }
    }

    private int  N;
    private int openSites;
    private int virtualTopIndex, virtualBottomIndex;
    private Site[] sites;
    private WeightedQuickUnionUF unionSites;

    public Percolation(int N)
    {
        int count = 0;

        this.N = N;
        openSites = 0;
        sites = new Site[N * N];
        unionSites = new WeightedQuickUnionUF(N * N + 2);
        virtualTopIndex = N * N;
        virtualBottomIndex = N * N + 1;
        for(int i = 0; i < N; i += 1)
        {
            for(int j = 0; j < N; j += 1)
            {
                sites[count] = new Site(i, j);
                count += 1;
            }
        }
    }

    private int indexOf(int row, int col)
    {
        return row * N + col;
    }

    private void unionAround(int row, int col)
    {
        int index = indexOf(row, col);

        if (row == 0)
        {
            unionSites.union(index, virtualTopIndex);
        }
        if (row == N - 1)
        {
            unionSites.union(index, virtualBottomIndex);
        }

        if (col != 0 && sites[indexOf(row, col - 1)].isOpen)
        {
            unionSites.union(index, index - 1);
        }
        if (col != N - 1 && sites[indexOf(row, col + 1)].isOpen)
        {
            unionSites.union(index, index + 1);
        }
        if (row != 0 && sites[indexOf(row - 1, col)].isOpen)
        {
            unionSites.union(index, index - N);
        }
        if (row != N - 1 && sites[indexOf(row + 1, col)].isOpen)
        {
            unionSites.union(index, index + N);
        }
    }

    /** open the site in row, col if it is not open already*/
    public void open(int row, int col)
    {
        if (row < 0 || row >= N || col < 0 || col >= N)
        {
            throw new IllegalArgumentException();
        }
        sites[indexOf(row, col)].isOpen = true;
        unionAround(row, col);
        openSites += 1;
    }

    public void randomOpen()
    {
        int randomRow, randomCol;
        randomRow = StdRandom.uniform(0, N);
        randomCol = StdRandom.uniform(0, N);
        while(isOpen(randomRow, randomCol))
        {
            randomRow = StdRandom.uniform(0, N);
            randomCol = StdRandom.uniform(0, N);
        }
        open(randomRow, randomCol);
    }

    /** is the site in row, col open? */
    public boolean isOpen(int row, int col)
    {
        return sites[indexOf(row, col)].isOpen;
    }

    /** is the site in row, col full? */
    public boolean isFull(int row, int col)
    {
        return unionSites.connected(indexOf(row, col), virtualTopIndex) ||
                unionSites.connected(indexOf(row, col), virtualBottomIndex);
    }

    /** number of the open sites */
    public int numberOfOpenSites()
    {
        return openSites;
    }

    /** dose the system percolate? */
    public boolean percolates()
    {
        return unionSites.connected(virtualBottomIndex, virtualTopIndex);
    }
}                       
