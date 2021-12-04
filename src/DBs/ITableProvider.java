package first.DBs;

import first.models.Category;
import first.models.Client;
import first.models.Comment;
import first.models.Entry;

public interface ITableProvider {
    public ITable<Category> getCategoryTable();

    public ITable<Comment> getCommentTable();

    public ITable<Entry> getEntryTable();

    public ITable<Client> getClientTable();

}
