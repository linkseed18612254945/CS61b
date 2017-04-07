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
    public void createNewTableTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, y int)");
        db.transact("print T1");
    }

    //@Test
    public void createSelectTableTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, y int, z string)");
        db.transact("insert into T1 values 2, 5, good ");
        db.transact("insert into T1 values 3, 1, nice ");
        db.transact("insert into T1 values 4, 0, great ");
        db.transact("create table T2 as select x,y from T1 where x >= y");
    }

    //@Test
    public void insertTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, y int)");
        db.transact("insert into T1 values 2, 5 ");
        db.transact("insert into T1 values 1, 3 ");
        db.transact("print T1");
    }

    //@Test
    public void storeTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, y int)");
        db.transact("insert into T1 values 1, 10 ");
        db.transact("insert into T1 values 1, 4 ");
        db.transact("create table T2 (x int, z string)");
        db.transact("insert into T2 values 2, beijing ");
        db.transact("store T1");
    }

    //@Test
    public void loadTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, z string)");
        db.transact("insert into T1 values 2, beijing ");
        db.transact("load T1");
        db.transact("print T1");
    }

    //@Test
    public void dropTest()
    {
        Database db = new Database();
        db.transact("create table T1 (x int, z string)");
        db.transact("insert into T1 values 2, beijing ");
        db.transact("print T1");
        db.transact("drop table T1 ");
        db.transact("print T1");
    }

    @Test
    public void selectTest()
    {
        Database db = new Database();
        db.transact("load fans");
        db.transact("select Firstname,Lastname,TeamName from fans where Lastname >= 'Lee'");
    }

    public static void main()
    {
        jh61b.junit.TestRunner.runTests("all", unitTest.class);
    }
}
