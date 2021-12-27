package first.servlets;

import first.Controllers.Actions.VisualAction;
import first.DBs.ITableProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.SQLTableProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ITableProvider tableProvider = new SQLTableProvider(new SQLDBProvider("D:\\code\\IdeaProjects\\java1_1\\Java_Lachugin.db"));
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*
        try {
            req.setAttribute("Entries", new ShowAction(tableProvider.getEntryTable()).action("").split("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            req.setAttribute("array", new VisualAction(tableProvider.getEntryTable(), tableProvider.getCommentTable(), tableProvider.getCategoryTable(), tableProvider.getClientTable()).action("").split("\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);

    }
}
