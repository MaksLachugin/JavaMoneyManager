package first.DBs;

import first.DBs.SQL.CategoriesSQLTable;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.models.Category;
import first.models.Client;
import first.models.Comment;
import first.models.Entry;

public class SQLTableProvider implements ITableProvider{
    private DBConnectionProvider provider;
    private final CategoriesSQLTable categoriesSQLTable;
    public SQLTableProvider(DBConnectionProvider pr) {
        provider =pr;
        TearDropFactory<Category> tdf = new TearDropFactory<Category>(new Category(0, ""));
        categoriesSQLTable = new CategoriesSQLTable(tdf, provider);
    }

    @Override
    public ITable<Category> getCategoryTable() {



        return categoriesSQLTable;

    }

    @Override
    public ITable<Comment> getCommentTable() {
        return null;
    }

    @Override
    public ITable<Entry> getEntryTable() {
        return null;
    }

    @Override
    public ITable<Client> getClientTable() {
        return null;
    }
}
