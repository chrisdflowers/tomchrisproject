package org.wardrobe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver {
	
	/**
	 * This will connect to the existing database.
	 * 
	 * @return the database connection.
	 */
	protected static Connection connect() {
		Connection connection = null;
		try {
			
			// Load the driver's class file into memory and register it.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Get the db connection given the db address, username and, password
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?allowMultiQueries=true", "root", "shishlik");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error: unable to load driver class!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Oops! Something went wrong with your connection. Please see the details below: ");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * This method successfully closes the connection that is given.
	 * 
	 * @param connection
	 * @return 1 if the connection was successfully closed and -1 if there was some problem closing the connection.
	 */
	protected static int closeConnection(Connection connection) {
		// Set result to 1 by default so if the connection successfully closes, 1 is returned
	    int result = 1;

	    try {
	    	// close the connection that is given
	    	connection.close();
	    	
	    } catch(SQLException e) { // Catch the SQLException if connection was not closed properly
	    	// set the result to -1, which indicates unsuccessful action 
	    	result = -1;
	    	// Print a basic summary and the error stack trace
	    	System.out.println("The connection could not be closed.");
	    	e.printStackTrace();
	    }

	    // Return the status of the connection
	    return result;
	}

}
