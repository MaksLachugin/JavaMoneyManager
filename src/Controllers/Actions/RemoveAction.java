package first.Controllers.Actions;

import first.DBs.ITable;
import first.models.MyItem;

public class RemoveAction implements IAction {
    private String name = "remove";
    private String comment = "Enter ID";
    private ITable<? extends MyItem> table;

    public RemoveAction(ITable<? extends MyItem> table) {
        this.table = table;
        setComment(String.format("Please enter: %s", table.getEntityFormat()));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String action(String str) throws Exception {
        if (str.length() > 0) {
            table.removeItemByID(Integer.parseInt(str));
            return "complete";
        } else {
            throw new Exception("Не правильный аргумент");
        }
    }
}
