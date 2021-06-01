package utility;

import java.beans.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public Connection connectToDatabase() throws ConnectException {
		final String URL = "jdbc:mysql://localhost:3306/atmapp";
		final String USERNAME = "root";
		final String PASSWORD = "Anurag1997@";
		Statement statement = null;
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			if (connection != null) {
				System.out.println("Connected to database succesfully!!!!");

			}
		} catch (SQLException e) {
			
			throw new ConnectException("Connection Not Establish");
			
			
		}

		return connection;
	}
	

	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println("The cause of the exception is ::" + e.getMessage());
			}
			
		}

	}
}
