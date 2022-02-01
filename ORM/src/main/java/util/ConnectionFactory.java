package util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory;
    private static Connection connection;

    private ConnectionFactory(String host, int port, String dbname, String username, String password, String schema, String driver) {

    }

    public static Connection getConnection(String host, int port, String dbname, String username, String password, String schema, String driver) {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory(host, port, dbname, username, password, schema, driver);
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        connection.close();
        connectionFactory = null;
    }
}
