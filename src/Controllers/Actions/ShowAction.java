package first.Controllers.Actions;

import first.DBs.ITable;
import first.models.MyItem;

public class ShowAction implements IAction {
    private String name = "show";
    private String comment = "Press Enter";
    private ITable<? extends MyItem> table;

    public ShowAction(ITable<? extends MyItem> table) {
        this.table = table;
        setComment(String.format("Please enter: %s", "Any key"));
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
        return table.getTableOfItems();


    }
}
