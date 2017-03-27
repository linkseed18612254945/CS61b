package project.project2;

import project.project2.db.Database;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by 51694 on 2017/3/27.
 */
public class unitTest
{
    //@Test
    public void createTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, y int)");
        db.tables.get("T1");
        db.printTable("T1");
    }

    @Test
    public void insertTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, y int)");
        db.transact("insert into T1 values 2, 5 ");
    }

    public static void main()
    {
        jh61b.junit.TestRunner.runTests("all", unitTest.class);
    }
}
