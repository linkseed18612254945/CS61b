package project.project2.db;

import project.project2.Parse;

import java.util.HashMap;
import java.util.Map;

public class Database {
    public Map<String, Table> tables;

    public Database()
    {
        tables = new HashMap<>();
    }

    public void addTable(String tableName, Table t)
    {
        tables.put(tableName, t);
    }

    public void printTable(String name)
    {
        String tableString = "";
        Table pt = tables.get(name);
        String colNames = pt.getColNames();
        System.out.println(colNames);
    }


    public String transact(String query)
    {
        Parse dbParser = new Parse(this);
        dbParser.eval(query);
        return "";
    }
}
