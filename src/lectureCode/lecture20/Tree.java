package lectureCode.lecture20;

/**
 * Created by 51694 on 2017/4/19.
 */
public class Tree<Label>
{
    Label item;
    Tree left;
    Tree right;

    Tree(Label item, Tree left, Tree right)
    {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf()
    {
        return left == null && right == null;
    }

    private static int heightHelp(Tree t)
    {
        if(t.isLeaf())
        {
            return 1;
        }
        return 1 + heightHelp(t.left);
    }
    public int height()
    {
        return heightHelp(this);
    }

   public  void preOrder(Tree<Label> x, Action<Label> whatToDo)
    {
        if (x == null) return;
        whatToDo.visit(x);
        preOrder(x.left, whatToDo);
        preOrder(x.right, whatToDo);
    }

    public  void inOrder(Tree x, Action<Label> whatToDo)
    {
        if (x == null) return;
        inOrder(x.left, whatToDo);
        System.out.print(x.item + " ");
        inOrder(x.right, whatToDo);
    }

    public static void postOrder(Tree x)
    {
        if (x == null) return;
        postOrder(x.left);
        postOrder(x.right);
        System.out.print(x.item + " ");
    }

    public static void levelOrder(Tree x)
    {
        for (int i = 0; i < x.height(); i += 1)
        {
           printLevel(x, i);
        }
    }

    public static void printLevel(Tree T, int level)
    {
        if (T == null)
        {
            return;
        }
        if (level == 0)
        {
            System.out.print(T.item + " ");
        }
        else
        {
            printLevel(T.left, level - 1);
            printLevel(T.right, level - 1);
        }
    }

    public static void main(String[] args)
    {
        Tree<String> t1 = new Tree<>("A", null, null);
        Tree t2 = new Tree("C", null, null);
        Tree t3 = new Tree("B", t1, t2);
        Tree t4 = new Tree("E", null, null);
        Tree t5 = new Tree("G", null, null);
        Tree t6 = new Tree("F", t4, t5);
        Tree the = new Tree("D", t3, t6);
        FindPig x = new FindPig();
        PrintAct y = new PrintAct();
        t1.preOrder(the, y);
        t1.inOrder(the, y);
    }
}
