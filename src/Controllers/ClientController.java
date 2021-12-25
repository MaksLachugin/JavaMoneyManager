package first.Controllers;

import first.Controllers.Actions.*;
import first.DBs.ITable;
import first.DBs.SQL.CategoriesSQLTable;
import first.DBs.SQL.ClientsSQLTable;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.array.ArrayTable;
import first.DBs.TearDropFactory;
import first.models.Category;
import first.models.Client;
import first.models.MyItem;

import java.util.ArrayList;
import java.util.List;

public class ClientController implements IController<Client> {
    private final String name = "Client";
    private ITable<Client> table;
    private List<IAction> actions;

    public ClientController(ITable<Client> table) {
        setTable(table);
        actions = new ArrayList<>();
        actions.add(new AddAction(table));
        actions.add(new EditAction(table));
        actions.add(new RemoveAction(table));
        actions.add(new ShowAction(table));
    }

    public ITable<Client> getTable() {
        return table;
    }

    @Override
    public void setTable(ITable<Client> table) {
        this.table = (ITable<Client>) table;
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
