package discussion.discussion09;

/**
 * Created by 51694 on 2017/4/17.
 */
public class Piece
{
    private String type;
    public boolean equals(Object o)
    {
        Piece otherPiece = (Piece) o;
        return this.type.equals(otherPiece.type);
    }

    public int hashCode()
    {
        if (type.equals("X"))
        {
            return 2;
        }
        else if (type.equals("O"))
        {
            return 1;
        }
        return 0;
    }

}
