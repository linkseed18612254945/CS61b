package lectureCode.lecture21;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by 51694 on 2017/4/20.
 */
public class Graph
{
    private final int verticeNumber;
    private String[] labels;
    private int[][] edges;
    private int[] marks;
    private int edgeNumber;
    private ArrayList<Integer>[] linkPresentEdge;

    public Graph(int V)
    {
        verticeNumber = V;
        edgeNumber = 0;
        labels = new String[V];
        edges = new int[V][V];
        linkPresentEdge = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i += 1)
        {
            linkPresentEdge[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w)
    {
        edges[v][w] = 1;
        linkPresentEdge[v].add(w);
        edgeNumber += 1;
    }

    public Iterable<Integer> adjByMatrix(int v)
    {
        Set<Integer> adjs = new HashSet<>();
        for(int i = 0; i < verticeNumber; i += 1)
        {
            if (edges[v][i] == 1)
            {
                adjs.add(i);
            }
        }
        return adjs;
    }

    public List<Integer> adjByLinkTable(int v)
    {
        return linkPresentEdge[v];
    }

    public boolean isConnected(int v, int w)
    {
        return adjByLinkTable(v).contains(w);
    }

    public int degree(int v)
    {
        int degree = 0;
        for (int w: adjByMatrix(v))
        {
            degree += 1;
        }
        return degree;
    }

    private boolean havePathHelper(int v, int w)
    {
        marks[v] = 1;
        if (isConnected(v, w))
        {
            return true;
        }
        for (int adj: adjByLinkTable(v))
        {

            if (marks[adj] != 1)
            {
                return havePathHelper(adj, w);
            }
        }
        return false;
    }

    public boolean havePath(int v, int w)
    {
        marks = new int[verticeNumber];
        return havePathHelper(v, w);
    }


    public int getVerticeNumber()
    {
        return verticeNumber;
    }

    public static void main(String[] args)
    {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        g.addEdge(4, 7);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 4);
        DepthFirstOrder p = new DepthFirstOrder(g);
        System.out.println(p.reversePostOrder());
    }

}
