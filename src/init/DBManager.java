package init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBManager {
    private Statement st;
    private Connection conn;

    private DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost:3306/biblio";
            conn = DriverManager.getConnection(host, "root", "");
            st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static DBManager instance = new DBManager();

    public static DBManager getInstance() {
        return instance;
    }

    public PreparedStatement prepare(String sql) throws SQLException {
        return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    public Statement getStatement() {
        return st;
    }


}
