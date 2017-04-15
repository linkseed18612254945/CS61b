package lab.lab08;

/**
 * Created by 51694 on 2017/4/15.
 */
public class BST
{
    protected int label;
    protected BST left, right;

    public BST(int label)
    {
        this(label, null, null);
    }

    private BST(int label, BST left, BST right)
    {
        this.label = label;
        this.left = left;
        this.right = right;
    }

    /** Fetch the label of this node */
    public int getLabel()
    {
        return label;
    }

    /** Fetch the left subtree */
    public BST getLeftTree()
    {
        return left;
    }

    public BST getRightTree()
    {
        return right;
    }

    /** the highest node in T that contains the label L, or null if there is none. */
    public static BST find(BST T, int L)
    {

    }

    public static boolean isIn(BST T, int L)
    {
        return find(T, L) != null;
    }

    public static BST insert(BST T, int L)
    {

    }

    public static BST remove(BST T, int L)
    {

    }
}
