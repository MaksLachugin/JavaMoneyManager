package first;

import first.Apps.ConsoleApp;
import first.Apps.IApp;
import first.DBs.ITableProvider;
import first.DBs.SQLTableProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ITableProvider tp = new SQLTableProvider();
        ConsoleTest(new ConsoleApp(tp));
    }

    private static void ConsoleTest(IApp MyApp) throws Exception {

        MyApp.run();
    }
}
