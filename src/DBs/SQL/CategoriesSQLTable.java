package first.DBs.SQL;

import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.TearDropFactory;
import first.models.Category;
import first.models.MyItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesSQLTable extends ASQLTable<Category> {
    private static final String TABLE_NAME = "Category";
    private static final String NAME_COLUMN_NAME = "Name";
    private static final String Type_COLUMN_NAME = "Type";

    public CategoriesSQLTable(TearDropFactory<Category> localFactory, DBConnectionProvider dbProvider) {
        super(localFactory, dbProvider);
    }
    @Override
    Category getElFromRSLT(ResultSet rslt) throws SQLException {
        int id = rslt.getInt(getIdColumnName());
        String name = rslt.getString(NAME_COLUMN_NAME);
        String type = rslt.getString(Type_COLUMN_NAME);
        return new Category(id, name, type);
    }

    @Override
    PreparedStatement getAddElTo(Connection c, Category el, String query) throws SQLException {
        query += new String("(?, ?, ?)");
        PreparedStatement q = c.prepareStatement(query);
        q.setInt(1,el.getID());
        q.setString(2, el.getName());
        q.setString(3, el.getType().toString());
        return q;
    }

    @Override
    String getTableName() {
        return TABLE_NAME;
    }

}
