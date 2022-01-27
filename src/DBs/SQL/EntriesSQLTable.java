package first.DBs.SQL;

import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.TearDropFactory;
import first.models.Category;
import first.models.Client;
import first.models.Entry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntriesSQLTable extends ASQLTable<Entry> {
    private static final String TABLE_NAME = "Entry";
    private static final String COST_COLUMN_NAME = "Cost";
    private static final String TIME_COLUMN_NAME = "Time";
    private static final String IDCOMMENT_COLUMN_NAME = "IDComment";
    private static final String IDCLIENT_COLUMN_NAME = "IDClient";
    private static final String IDCATEGORY_COLUMN_NAME = "IDCategory";

    public EntriesSQLTable(TearDropFactory<Entry> localFactory, DBConnectionProvider dbProvider) {
        super(localFactory, dbProvider);
    }

    @Override
    Entry getElFromRSLT(ResultSet rslt) throws SQLException {
        int id = rslt.getInt(getIdColumnName());
        int IDComment = rslt.getInt(IDCOMMENT_COLUMN_NAME);
        int IDClient = rslt.getInt(IDCLIENT_COLUMN_NAME);
        int IDCategory = rslt.getInt(IDCATEGORY_COLUMN_NAME);
        Long time = rslt.getLong(TIME_COLUMN_NAME);
        int cost = rslt.getInt(COST_COLUMN_NAME);
        return new Entry(id, cost, time, IDComment, IDClient, IDCategory);
    }

    @Override
    PreparedStatement getAddElTo(Connection c, Entry el, String query) throws SQLException {
        query += new String("(null, ?, ?, ?, ?, ?)");
        PreparedStatement q = c.prepareStatement(query);
        q.setInt(1, el.getCost());
        q.setLong(2, el.getTime());
        q.setInt(3, el.getIDComment());
        q.setInt(4, el.getIDClient());
        q.setInt(5, el.getIDCategory());
        return q;
    }

    @Override
    String getTableName() {
        return TABLE_NAME;
    }
}
