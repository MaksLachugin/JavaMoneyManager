package first.DBs.SQL;

import first.DBs.ATable;
import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.SQL.Settings.SQLDBProvider;
import first.DBs.TearDropFactory;
import first.models.MyItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class ASQLTable<T extends MyItem> extends ATable<T> {
    private static final String ID_COLUMN_NAME = "ID";
    private DBConnectionProvider dbProvider;

    public ASQLTable(TearDropFactory<T> localFactory, DBConnectionProvider dbProvider) {
        super(localFactory);
        this.dbProvider = dbProvider;
    }


    @Override
    public void add(T el) {
        final String query = String.format("INSERT INTO %s VALUES", getTableName());
        try (Connection c = dbProvider.getConnection()) {
            PreparedStatement q = getAddElTo(c, el, query);
            q.executeUpdate();
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
    }

    @Override
    public T getElementByID(int ID) {
        final String query = String.format("SELECT * FROM %s WHERE ", getTableName()) + requestByColumn();
        try (Connection c = dbProvider.getConnection()) {
            PreparedStatement q = c.prepareStatement(query);
            q.setInt(1, ID);
            ResultSet rslt = q.executeQuery();
            while (rslt.next()) {
                return getElFromRSLT(rslt);
            }
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }

        return null;
    }

    @Override
    public List<T> getLst() {
        final String query = String.format("SELECT * FROM %s;", getTableName());
        List<T> items = new LinkedList<>();
        try (Connection c = dbProvider.getConnection()) {
            PreparedStatement q = c.prepareStatement(query);
            ResultSet rslt = q.executeQuery();
            while (rslt.next()) {
                items.add(getElFromRSLT(rslt));
            }
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        return items;
    }

    @Override
    public void removeItemByID(int ID) {
        final String query = String.format("DELETE FROM %s WHERE ", getTableName()) + requestByColumn();

        try (Connection c = dbProvider.getConnection()) {
            PreparedStatement q = c.prepareStatement(query);
            q.setInt(1, ID);
            q.executeUpdate();
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
    }


    @Override
    public void load(String path) throws Exception {
    }

    @Override
    public void save(String path) throws Exception {

    }

    private String requestByColumn() {
        return String.format("%s == ?;", ID_COLUMN_NAME);
    }

    abstract T getElFromRSLT(ResultSet rslt) throws SQLException;

    abstract PreparedStatement getAddElTo(Connection c, T el, String query) throws SQLException;

    protected String getIdColumnName() {
        return ID_COLUMN_NAME;
    }

    abstract String getTableName();
}
