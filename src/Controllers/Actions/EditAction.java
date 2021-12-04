package first.Controllers.Actions;

import first.DBs.ITable;
import first.models.MyItem;

public class EditAction implements IAction {
    private String name = "edit";
    private String comment;
    private ITable<? extends MyItem> table;

    public EditAction(ITable<? extends MyItem> table) {
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
            table.editElement(str);
            return "complete";
        } else {
            throw new Exception("Не правильный аргумент");
        }
    }
}
