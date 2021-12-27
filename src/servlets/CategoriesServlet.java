package first.servlets;

import first.Controllers.Actions.AddAction;
import first.Controllers.Actions.RemoveAction;
import first.Controllers.Actions.ShowAction;
import first.DBs.ITableProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.SQLTableProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoriesServlet extends HttpServlet {
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
            arr = new ShowAction(tableProvider.getCategoryTable()).action("").split("\n");
            req.setAttribute("array", arr);
            req.setAttribute("form", tableProvider.getCategoryTable().getEntityFormat());
        } catch (Exception e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/Categories.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ITableProvider tableProvider = new SQLTableProvider(new SQLDBProvider("D:\\code\\IdeaProjects\\java1_1\\Java_Lachugin.db"));
        req.setCharacterEncoding("UTF-8");
        Map<String, String[]> map = req.getParameterMap();

        for (String str : map.keySet()) {
            if (str.equals("remove")) {
                try {
                    new RemoveAction(tableProvider.getCategoryTable()).action(map.get(str)[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (str.equals("create")) {
                try {
                    new AddAction(tableProvider.getCategoryTable()).action(map.get(str)[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        doGet(req, resp);
    }
}
