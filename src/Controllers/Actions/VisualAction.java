package first.Controllers.Actions;

import first.DBs.ITable;
import first.models.*;

public class VisualAction implements IAction {
    private String name = "Base";
    private String comment;
    private final ITable<Entry> entryITable;
    private final ITable<Comment> commentITable;
    private final ITable<Category> categoryITable;
    private final ITable<Client> clientITable;

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
    public void setName(String Name) {
        this.name = name;
    }

    public VisualAction(ITable<Entry> entryITable, ITable<Comment> commentITable, ITable<Category> categoryITable, ITable<Client> clientITable) {
        this.entryITable = entryITable;
        this.commentITable = commentITable;
        this.categoryITable = categoryITable;
        this.clientITable = clientITable;
    }

    @Override
    public String action(String str) throws Exception {
        String[] res = new String[entryITable.getLst().size()];
        int i = 0;
        for (Entry item : entryITable.getLst()) {
            res[i++] = formater(item, categoryITable.getElementByID(item.getIDCategory()), clientITable.getElementByID(item.getIDClient()), commentITable.getElementByID(item.getIDComment()));
        }
        return String.join("\n", res);
    }

    private String formater(Entry entry, Category category, Client client, Comment comment) {
        String[] arr = {String.valueOf(entry.getCost()), entry.getNormalTime(), (category == null) ? "" : category.getName(), (client == null) ? "" : client.getName(), (comment == null) ? "" : comment.getComment()};
        return String.join(", ", arr);
    }
}
