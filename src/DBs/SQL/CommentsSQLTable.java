package first.DBs.SQL;

import first.DBs.SQL.Settings.DBConnectionProvider;
import first.DBs.TearDropFactory;
import first.models.Category;
import first.models.Client;
import first.models.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentsSQLTable extends ASQLTable<Comment> {
    private static final String TABLE_NAME = "Comment";
    private static final String COMMENT_COLUMN_NAME = "Comment";

    public CommentsSQLTable(TearDropFactory<Comment> localFactory, DBConnectionProvider dbProvider) {
        super(localFactory, dbProvider);
    }

    @Override
    Comment getElFromRSLT(ResultSet rslt) throws SQLException {
        int id = rslt.getInt(getIdColumnName());
        String name = rslt.getString(COMMENT_COLUMN_NAME);
        return new Comment(id, name);
    }

    @Override
    PreparedStatement getAddElTo(Connection c, Comment el, String query) throws SQLException {
        query += new String("(?, ?)");
        PreparedStatement q = c.prepareStatement(query);
        q.setInt(1, el.getID());
        q.setString(2, el.getComment());
        return q;
    }

    @Override
    String getTableName() {
        return TABLE_NAME;
    }
}
