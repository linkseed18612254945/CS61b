package lectureCode.lecture15;

/**
 * Created by 51694 on 2017/3/22.
 */

import org.junit.Test;
import static org.junit.Assert.*;


public class DateEqualTest
{
    @Test
    public void testEquals()
    {
        Date d1a = new Date(5, 10, 2010);
        Date d1b = new Date(5, 10, 2010);
        Date d2 = new Date(5, 11, 2012);

        assertEquals(d1a, d1b);
        assertEquals(d1a, d1a);
        assertNotEquals(d1a, d2);
        assertNotEquals(d1a, "horse");
        assertNotEquals(d1a, null);
    }
}
