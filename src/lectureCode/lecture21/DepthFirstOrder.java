package lectureCode.lecture21;

import java.util.Stack;

/**
 * Created by 51694 on 2017/4/24.
 */
public class DepthFirstOrder
{
    private boolean[] marked;
    private Stack<Integer> reverserPostOrder;

    public DepthFirstOrder(Graph g)
    {
        reverserPostOrder = new Stack<>();
        marked = new boolean[g.getVerticeNumber()];
        for (int v = 0; v < marked.length; v += 1)
        {
            if (!marked[v])
            {
                dfs(g, v);
            }
        }
    }

    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        for (int w: g.adjByLinkTable(v))
        {
            if (!marked[w])
            {
                dfs(g, w);
            }
        }
        reverserPostOrder.push(v);
    }

    public Iterable<Integer> reversePostOrder()
    {
        return reverserPostOrder;
    }
}
