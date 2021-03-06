package project.project2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import project.project2.db.Database;


public class Main
{
    private static final String EXIT   = "exit";
    private static final String PROMPT = "> ";

    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Database db = new Database();
        System.out.print(PROMPT);

        String line = "";
        while ((line = in.readLine()) != null)
        {
            if (EXIT.equals(line))
            {
                break;
            }

            if (!line.trim().isEmpty())
            {
                db.transact(line);
            }
            System.out.print(PROMPT);
        }

        in.close();
    }
}
