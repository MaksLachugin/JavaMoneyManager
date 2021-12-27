package first.servlets;

import first.Controllers.Actions.AddAction;
import first.Controllers.Actions.ShowAction;
import first.Controllers.Actions.VisualAction;
import first.DBs.ITableProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.SQLTableProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ITableProvider tableProvider = new SQLTableProvider(new SQLDBProvider("D:\\code\\IdeaProjects\\java1_1\\Java_Lachugin.db"));
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String[] arr;
        try {
            arr = new ShowAction(tableProvider.getClientTable()).action("").split("\n");
            req.setAttribute("array", arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/Clients.jsp").forward(req, resp);

    }
}
