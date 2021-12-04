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

public class FactoryTable implements ITableProvider{

    private final String pathForSQL = "D:\\code\\IdeaProjects\\java1_1\\Java_Lachugin.db";
    public List<ITable<? extends MyItem>> getTable(int i) {
        /*
        1 - SQL
        0 - Array
         */
        List<ITable<? extends MyItem>> lst = new ArrayList<>();
        lst.add(getCategoryTable(i));
        lst.add(getCommentTable(i));
        lst.add(getClientTable(i));
        lst.add(getEntryTable(i));
        return lst;
    }

    private ITable<Category> getCategoryTable(int i) {

        return new ArrayTable<Category>(tdf);
    }

    private ITable<Comment> getCommentTable(int i) {
        TearDropFactory<Comment> tdf = new TearDropFactory<Comment>(new Comment(0, ""));
        if (i == 1) {
            DBConnectionProvider provider = new SQLDBProvider(pathForSQL);
            return new CommentsSQLTable(tdf, provider);
        }
        return new ArrayTable<Comment>(tdf);
    }

    private ITable<Client> getClientTable(int i) {
        TearDropFactory<Client> tdf = new TearDropFactory<Client>(new Client(0, ""));
        if (i == 1) {
            DBConnectionProvider provider = new SQLDBProvider(pathForSQL);
            return new ClientsSQLTable(tdf, provider);
        }
        return new ArrayTable<Client>(tdf);
    }

    private ITable<Entry> getEntryTable(int i) {
        TearDropFactory<Entry> tdf = new TearDropFactory<Entry>(new Entry(0, 0, 0L));
        if (i == 1) {
            DBConnectionProvider provider = new SQLDBProvider(pathForSQL);
            return new EntriesSQLTable(tdf, provider);
        }
        return new ArrayTable<Entry>(tdf);
    }

    @Override
    public ITable<Category> getCategoryTable() {
        return null;
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
