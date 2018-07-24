package org.depersonalizationAssistant.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/depersonalization_assistant";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException error) {
			error.printStackTrace();
		}
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
