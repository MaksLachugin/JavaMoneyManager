package first.Controllers;

import first.Controllers.Actions.*;
import first.DBs.ITable;
import first.DBs.SQL.CategoriesSQLTable;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.array.ArrayTable;
import first.DBs.TearDropFactory;
import first.models.Category;
import first.models.MyItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryController implements IController<Category> {
    private final String name = "Category";
    private ITable<Category> table;
    private List<IAction> actions;

    public CategoryController(ITable<Category> table) {
        setTable(table);
        actions = new ArrayList<>();
        actions.add(new AddAction(table));
        actions.add(new EditAction(table));
        actions.add(new RemoveAction(table));
        actions.add(new ShowAction(table));
    }

    public ITable<Category> getTable() {
        return table;
    }

    public void setTable(ITable<Category> table) {
        this.table = (ITable<Category>) table;
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
