package br.eti.gregori.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws RuntimeException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "1234");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		} 
	}
}
