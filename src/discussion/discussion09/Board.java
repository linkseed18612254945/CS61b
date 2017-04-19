package discussion.discussion09;

/**
 * Created by 51694 on 2017/4/17.
 */
public class Board
{
    public static final int SIZE = 3;

    private Piece[][] pieces;
    private boolean isXTurn;

    public int hashCode()
    {
        int code = 0;
        if (isXTurn)
        {
            code = 1;
        }

        for (int i = 0; i < SIZE; i += 1)
        {
            for (int j = 0; j < SIZE; j += 1)
            {
                Piece currenPiece = pieces[i][j];
                code *= 3;
                if (currenPiece != null)
                {
                    code += currenPiece.hashCode();
                }
            }
        }
        return code;
    }

}
