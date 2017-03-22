package lectureCode.lecture15;


/**
 * Created by 51694 on 2017/3/22.
 */
public class Date
{
    private final int month;
    private final int day;
    private final int year;

    public  Date(int m, int d, int y)
    {
        year = y;
        month = m;
        day = d;
    }

    @Override
    public boolean equals(Object d)
    {
        if (d == this)
        {
            return true;
        }
        if (d == null)
        {
            return false;
        }
        if (this.getClass() != d.getClass())
        {
            return false;
        }
        Date uddaDate = (Date) d;
        return (month == uddaDate.month) && (day == uddaDate.day) && (year == uddaDate.year);
    }
}
