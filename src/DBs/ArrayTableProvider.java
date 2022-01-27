package first.DBs;

import first.Controllers.IController;
import first.DBs.SQL.*;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.array.ArrayTable;
import first.models.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class ArrayTableProvider implements ITableProvider {
    public ArrayTableProvider() {
        categoriesTable = new ArrayTable<Category>(Category.tdf);
        TearDropFactory<Comment> tdf2 = new TearDropFactory<Comment>(new Comment(0, ""));
        commentsTable = new ArrayTable<Comment>(tdf2);
        TearDropFactory<Client> tdf3 = new TearDropFactory<Client>(new Client(0, ""));
        clientsTable = new ArrayTable<Client>(tdf3);
        TearDropFactory<Entry> tdf4 = new TearDropFactory<Entry>(new Entry(0, 0, 0L));
        entriesTable = new ArrayTable<Entry>(tdf4);
    }

    private final ArrayTable<Category> categoriesTable;
    private final ArrayTable<Comment> commentsTable;
    private final ArrayTable<Client> clientsTable;
    private final ArrayTable<Entry> entriesTable;

    @Override
    public ITable<Category> getCategoryTable() {
        return categoriesTable;
    }

    @Override
    public ITable<Comment> getCommentTable() {
        return commentsTable;
    }

    @Override
    public ITable<Entry> getEntryTable() {
        return entriesTable;
    }

    @Override
    public ITable<Client> getClientTable() {
        return clientsTable;
    }
}
