package first;

import first.Apps.ConsoleApp;
import first.Apps.IApp;
import first.DBs.ArrayTableProvider;
import first.DBs.ITableProvider;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.SQLTableProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // "D:\\code\\IdeaProjects\\java1_1\\DB"
        ITableProvider tableProviderArray = new ArrayTableProvider();
        DBConnectionProvider provider = new SQLDBProvider("D:\\code\\IdeaProjects\\java1_1\\Java_Lachugin.db");
        ITableProvider tableProviderSQL = new SQLTableProvider(provider);
        ConsoleTest(new ConsoleApp(tableProviderSQL));
    }

    private static void ConsoleTest(IApp MyApp) throws Exception {

        MyApp.run();
    }
}
