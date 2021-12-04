package first.Controllers;

import first.Controllers.Actions.*;
import first.DBs.ITable;
import first.DBs.SQL.CommentsSQLTable;
import first.DBs.SQL.EntriesSQLTable;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.array.ArrayTable;
import first.DBs.TearDropFactory;
import first.models.Comment;
import first.models.Entry;
import first.models.MyItem;

import java.util.ArrayList;
import java.util.List;

public class EntryController implements IController {
    private final String name = "Entry";
    private ITable<Entry> table;
    private List<IAction> actions;

    public List<IAction> getActions() {
        return actions;
    }

    public void setActions(List<IAction> actions) {
        this.actions = actions;
    }

    public EntryController(ITable<? extends MyItem> table) {
        setTable(table);
        actions = new ArrayList<>();
        actions.add(new AddAction(table));
        actions.add(new EditAction(table));
        actions.add(new RemoveAction(table));
        actions.add(new ShowAction(table));
    }

    public ITable<Entry> getTable() {
        return table;
    }

    public void setTable(ITable<? extends MyItem> table) {
        this.table = (ITable<Entry>) table;
    }

    @Override
    public String getName() {
        return name;
    }


}
