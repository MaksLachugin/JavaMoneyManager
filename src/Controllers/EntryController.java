package first.Controllers;
import first.Controllers.Actions.*;
import first.DBs.ITable;
import first.models.Entry;
import java.util.ArrayList;
import java.util.List;

public class EntryController implements IController<Entry> {
    private final String name = "Entry";
    private ITable<Entry> table;
    private List<IAction> actions;

    public List<IAction> getActions() {
        return actions;
    }

    public void setActions(List<IAction> actions) {
        this.actions = actions;
    }

    public EntryController(ITable<Entry> table) {
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

    public void setTable(ITable<Entry> table) {
        this.table = table;
    }

    @Override
    public String getName() {
        return name;
    }


}
