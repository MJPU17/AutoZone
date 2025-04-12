package co.edu.unbosque.pattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection instance;
	private Connection connection;

	private final String url;
	private final String username;
	private final String password;
	
	

	private DBConnection(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static DBConnection getInstance(String url, String username, String password) {
		if (instance == null) {
			instance = new DBConnection(url, username, password);
		}
		return instance;
	}

	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(url, username, password);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error establishing connection to the database", e);
		}
		return connection;
	}
	
	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error closing connection to database", e);
		}
	}

}
