package lectureCode.lecture21;

import java.util.*;

/**
 * Created by 51694 on 2017/4/24.
 */
public class BreadthFirstPaths implements GraphPath
{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph g, int s)
    {
        marked = new boolean[g.getVerticeNumber()];
        edgeTo = new int[g.getVerticeNumber()];
        this.s = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int s)
    {
        Queue<Integer> fringe = new PriorityQueue<>();
        fringe.add(s);
        marked[s] = true;
        while (!fringe.isEmpty())
        {
            int v = fringe.remove();
            for (int w: g.adjByLinkTable(v))
            {
                if (!marked[w])
                {
                    fringe.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
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
        List<Integer> path = new ArrayList<>();
        int current = v;
        while (current != s)
        {
            path.add(current);
            current = edgeTo[current];
        }
        path.add(s);
        return path;
    }

    @Override
    public void printPaths()
    {
        System.out.println(Arrays.toString(edgeTo));
    }
}
