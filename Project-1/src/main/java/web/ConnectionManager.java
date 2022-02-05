package web;

import util.ConnectionFactory;
import utils.FileLogger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private static Connection connection;

	private ConnectionManager() {

	}

	public static Connection getConnection() {
		if (connection == null) {
			connect();
		}
		return connection;
	}

	private static void connect() {
		try {
			Properties p = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream input = loader.getResourceAsStream("connection.properties");
			p.load(input);

			connection = ConnectionFactory.getConnection(p.getProperty("hostname"), Integer.parseInt(p.getProperty("port")),
					p.getProperty("dbname"), p.getProperty("username"), p.getProperty("password"));

		} catch (IOException | SQLException e) {
			FileLogger.getFileLogger().log(e);
		}

	}

	@Override
	public void finalize() {
		try {
			connection.close();
		} catch (Exception e) {
			FileLogger.getFileLogger().log(e);
		}
	}

}
