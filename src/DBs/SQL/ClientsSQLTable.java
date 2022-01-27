package first.DBs.SQL;

import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.TearDropFactory;
import first.models.Category;
import first.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientsSQLTable extends ASQLTable<Client> {
    private static final String TABLE_NAME = "Client";
    private static final String NAME_COLUMN_NAME = "Name";

    public ClientsSQLTable(TearDropFactory<Client> localFactory, DBConnectionProvider dbProvider) {
        super(localFactory, dbProvider);
    }

    @Override
    Client getElFromRSLT(ResultSet rslt) throws SQLException {

        int id = rslt.getInt(getIdColumnName());
        String name = rslt.getString(NAME_COLUMN_NAME);
        return new Client(id, name);
    }

    @Override
    PreparedStatement getAddElTo(Connection c, Client el, String query) throws SQLException {
        query += new String("(null, ?)");
        PreparedStatement q = c.prepareStatement(query);
        q.setString(1, el.getName());
        return q;
    }

    @Override
    String getTableName() {
        return TABLE_NAME;
    }


}
