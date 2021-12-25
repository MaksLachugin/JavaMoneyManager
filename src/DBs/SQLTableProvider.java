package first.DBs;

import first.DBs.SQL.CategoriesSQLTable;
import first.DBs.SQL.ClientsSQLTable;
import first.DBs.SQL.CommentsSQLTable;
import first.DBs.SQL.EntriesSQLTable;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.models.Category;
import first.models.Client;
import first.models.Comment;
import first.models.Entry;

public class SQLTableProvider implements ITableProvider {
    private DBConnectionProvider provider;
    private final CategoriesSQLTable categoriesSQLTable;
    private final CommentsSQLTable commentsSQLTable;
    private final ClientsSQLTable clientsSQLTable;
    private final EntriesSQLTable entriesSQLTable;

    public SQLTableProvider(DBConnectionProvider pr) {
        provider = pr;
        TearDropFactory<Category> tdf1 = new TearDropFactory<Category>(new Category(0, ""));
        categoriesSQLTable = new CategoriesSQLTable(tdf1, provider);
        TearDropFactory<Comment> tdf2 = new TearDropFactory<Comment>(new Comment(0, ""));
        commentsSQLTable = new CommentsSQLTable(tdf2, provider);
        TearDropFactory<Client> tdf3 = new TearDropFactory<Client>(new Client(0, ""));
        clientsSQLTable = new ClientsSQLTable(tdf3, provider);
        TearDropFactory<Entry> tdf4 = new TearDropFactory<Entry>(new Entry(0, 0, 0L));
        entriesSQLTable = new EntriesSQLTable(tdf4, provider);
    }

    @Override
    public ITable<Category> getCategoryTable() {
        return categoriesSQLTable;

    }

    @Override
    public ITable<Comment> getCommentTable() {
        return commentsSQLTable;
    }

    @Override
    public ITable<Entry> getEntryTable() {
        return entriesSQLTable;
    }

    @Override
    public ITable<Client> getClientTable() {
        return clientsSQLTable;
    }
}
