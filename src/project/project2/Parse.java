package project.project2;

import project.project2.db.Database;
import project.project2.db.Table;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.StringJoiner;

public class Parse {
    private Database db;

    // Various common constructs, simplifies parsing.
    private static final String REST  = "\\s*(.*)\\s*",
                                COMMA = "\\s*,\\s*",
                                AND   = "\\s+and\\s+";

    // Stage 1 syntax, contains the command name.
    private static final Pattern CREATE_CMD = Pattern.compile("create table " + REST),
                                 LOAD_CMD   = Pattern.compile("load " + REST),
                                 STORE_CMD  = Pattern.compile("store " + REST),
                                 DROP_CMD   = Pattern.compile("drop table " + REST),
                                 INSERT_CMD = Pattern.compile("insert into " + REST),
                                 PRINT_CMD  = Pattern.compile("print " + REST),
                                 SELECT_CMD = Pattern.compile("select " + REST);

    // Stage 2 syntax, contains the clauses of commands.
    private static final Pattern CREATE_NEW  = Pattern.compile("(\\S+)\\s+\\(\\s*(\\S+\\s+\\S+\\s*" +
                                               "(?:,\\s*\\S+\\s+\\S+\\s*)*)\\)"),
                                 SELECT_CLS  = Pattern.compile("([^,]+?(?:,[^,]+?)*)\\s+from\\s+" +
                                               "(\\S+\\s*(?:,\\s*\\S+\\s*)*)(?:\\s+where\\s+" +
                                               "([\\w\\s+\\-*/'<>=!.]+?(?:\\s+and\\s+" +
                                               "[\\w\\s+\\-*/'<>=!.]+?)*))?"),
                                 CREATE_SEL  = Pattern.compile("(\\S+)\\s+as select\\s+" +
                                                   SELECT_CLS.pattern()),
                                 INSERT_CLS  = Pattern.compile("(\\S+)\\s+values\\s+(.+?" +
                                               "\\s*(?:,\\s*.+?\\s*)*)");

    public Parse(Database db)
    {
        this.db = db;
    }

    public void eval(String query)
    {
        Matcher m;
        if ((m = CREATE_CMD.matcher(query)).matches())
        {
            createTable(m.group(1));
        }
        else if ((m = LOAD_CMD.matcher(query)).matches())
        {
            loadTable(m.group(1));
        }
        else if ((m = STORE_CMD.matcher(query)).matches())
        {
            storeTable(m.group(1));
        }
        else if ((m = DROP_CMD.matcher(query)).matches())
        {
            dropTable(m.group(1));
        }
        else if ((m = INSERT_CMD.matcher(query)).matches())
        {
            insertRow(m.group(1));
        }
        else if ((m = PRINT_CMD.matcher(query)).matches())
        {
            printTable(m.group(1));
        }
        else if ((m = SELECT_CMD.matcher(query)).matches())
        {
            select(m.group(1));
        }
        else
        {
            System.err.printf("Malformed query: %s\n", query);
        }
    }


    private void createTable(String expr)
    {
        Matcher m;
        if ((m = CREATE_NEW.matcher(expr)).matches())
        {
            createNewTable(m.group(1), m.group(2).split(COMMA));
        }
        else if ((m = CREATE_SEL.matcher(expr)).matches())
        {
            createSelectedTable(m.group(1), m.group(2), m.group(3), m.group(4));
        }
        else
        {
            System.err.printf("Malformed create: %s\n", expr);
        }
    }

    private void createNewTable(String name, String[] cols)
    {
        String[] colNames = new String[cols.length];
        String[] colTypes = new String[cols.length];
        for (int i = 0; i < cols.length; i++)
        {
            colNames[i] = cols[i].split(" ")[0];
            colTypes[i] = cols[i].split(" ")[1];
        }
        db.createTable(name, colNames, colTypes);
    }

    private void createSelectedTable(String name, String exprs, String tables, String conds)
    {
        System.out.printf("You are trying to create a table named %s by selecting these expressions:" +
                " '%s' from the join of these tables: '%s', filtered by these conditions: '%s'\n", name, exprs, tables, conds);
    }

    private void loadTable(String name)
    {
        db.loadTable(name);
    }

    private void storeTable(String name)
    {
        db.storeTable(name);
    }

    private void dropTable(String name)
    {
        db.dropTable(name.trim());
    }

    private void insertRow(String expr)
    {
        Matcher m = INSERT_CLS.matcher(expr);
        if (!m.matches())
        {
            System.err.printf("Malformed insert: %s\n", expr);
            return;
        }
        String[] values = m.group(2).split(COMMA);
        String tableName = m.group(1);
        db.insertTable(tableName, values);
    }

    private void printTable(String name)
    {
        db.printTable(name);
    }

    private void select(String expr) {
        Matcher m = SELECT_CLS.matcher(expr);
        if (!m.matches()) {
            System.err.printf("Malformed select: %s\n", expr);
            return;
        }

        select(m.group(1), m.group(2), m.group(3));
    }

    private void select(String exprs, String tables, String conds) {
        System.out.printf("You are trying to select these expressions:" +
                " '%s' from the join of these tables: '%s', filtered by these conditions: '%s'\n", exprs, tables, conds);
    }
}
