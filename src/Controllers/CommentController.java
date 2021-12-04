package first.Controllers;

import first.Controllers.Actions.*;
import first.DBs.ITable;
import first.DBs.SQL.ClientsSQLTable;
import first.DBs.SQL.CommentsSQLTable;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.array.ArrayTable;
import first.DBs.TearDropFactory;
import first.models.Client;
import first.models.Comment;
import first.models.MyItem;

import java.util.ArrayList;
import java.util.List;

public class CommentController implements IController {
    private final String name = "Comment";
    private ITable<Comment> table;
    private List<IAction> actions;

    public CommentController(ITable<? extends MyItem> table) {
        setTable(table);
        actions = new ArrayList<>();
        actions.add(new AddAction(table));
        actions.add(new EditAction(table));
        actions.add(new RemoveAction(table));
        actions.add(new ShowAction(table));
    }

    public ITable<Comment> getTable() {
        return table;
    }

    public void setTable(ITable<? extends MyItem> table) {
        this.table = (ITable<Comment>) table;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<IAction> getActions() {
        return actions;
    }

    @Override
    public void setActions(List<IAction> actions) {
        this.actions = actions;
    }
}
