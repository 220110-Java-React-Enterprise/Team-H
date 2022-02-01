package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory;
    private static Connection connection;

    private ConnectionFactory(String host, int port, String dbname, String username, String password) throws SQLException {

        String connectionStr = "jdbc:mariadb://" +
                host + ":" + port + "/" +
                dbname + "?user=" + username +
                "&password=" + password;

        connection = DriverManager.getConnection(connectionStr);
    }

    public static Connection getConnection(String host, int port, String dbname, String username, String password) throws SQLException {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory(host, port, dbname, username, password);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
        connectionFactory = null;
    }

}
