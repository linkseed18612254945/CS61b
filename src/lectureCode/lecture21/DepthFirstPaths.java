package lectureCode.lecture21;

import java.util.*;

/**
 * Created by 51694 on 2017/4/24.
 */
public class DepthFirstPaths implements GraphPath
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph G, int s)
    {
        this.s = s;
        marked = new boolean[G.getVerticeNumber()];
        edgeTo = new int[G.getVerticeNumber()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v)
    {
        marked[v] = true;
        for (int w : G.adjByLinkTable(v))
        {
            if (!marked[w])
            {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v)
    {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v)
    {
        Stack<Integer> path = new Stack<>();
        int current = v;
        while (current != s)
        {
            path.push(current);
            current = edgeTo[current];
        }
        path.push(s);
        return path;
    }

    @Override
    public void printPaths()
    {
        System.out.println(Arrays.toString(edgeTo));
    }

}
