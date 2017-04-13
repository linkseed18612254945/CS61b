package project.project2;

import project.project2.db.Database;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Parse {
    private Database db;

    // Various common constructs, simplifies parsing.
    private static final String REST  = "\\s*(.*)\\s*",
                                COMMA = "\\s*,\\s*",
                                AND   = "\\s+and\\s+";
    private static final String[] COMPARATOR = new String[] {"==", "!=", "<", ">", "<=", ">="};

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
        String[] colNames = exprs.split(",");
        String[] selectedTables = tables.split(",");
        String[] condition;
        if (conds == null)
        {
            condition = null;
        }
        else
        {
            condition = conds.split(" ");
        }
        db.createTableBySelect(name, colNames, selectedTables, condition);
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

    private void select(String expr)
    {
        Matcher m = SELECT_CLS.matcher(expr);
        if (!m.matches())
        {
            System.err.printf("Malformed select: %s\n", expr);
            return;
        }
        String[] colExpressions = m.group(1).trim().split(",");
        String[] joinTables = m.group(2).trim().split(",");
        String[] condition;
        if (m.group(3) == null)
        {
            condition = null;
        }
        else
        {
            condition = m.group(3).trim().split(" ");
        }
        db.selectTables("SelectTable", colExpressions, joinTables, condition);
    }
}
