package first.Controllers;

import first.Controllers.Actions.IAction;
import first.DBs.ITable;
import first.models.MyItem;

import java.util.List;

public interface IController<T extends MyItem> {
    public ITable<T> getTable();

    public void setTable(ITable<T> table);

    String getName();

    default String Actions() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (IAction action : getActions()
        ) {
            sb.append(String.format("%d. %s", i++, action.getName()));
            sb.append('\n');
        }
        return sb.toString();
    }

    default String changeAction(int choice, String params) throws Exception{
        return getActions().get(choice).action(params);
    }// да
    default String forAction(int choice){
        return getActions().get(choice).getComment();
    }

    default void load(String path) throws Exception {
        getTable().load(path);
    }

    default void save(String path) throws Exception {
        getTable().save(path);
    }

    public List<IAction> getActions();

    public void setActions(List<IAction> actions);
}
