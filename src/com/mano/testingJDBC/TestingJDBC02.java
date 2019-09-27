package com.mano.testingJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestingJDBC02 {

	public static void main(String[] args) {
		TestingJDBC02 testingJDBC02 = new TestingJDBC02();
		boolean z = testingJDBC02.SQLSelect();
	}

	public boolean SQLSelect() {
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/sakila";

		// Database credentials
		final String USER = "root";
		final String PASS = "mano";

		Connection conn = null;
		Statement stmt = null;
		
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * from dresses where category='Bridal'";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int DressID = rs.getInt("DressID");
				String Category = rs.getString("Category");
				String Name = rs.getString("Name");
				String Color = rs.getString("Color");
				String Size = rs.getString("Size");
				int Price = rs.getInt("Price");
				String Description = rs.getString("Description");
				//String last = rs.getString("last");

				// Display values
				System.out.print("DressID: " + DressID);
				System.out.print(", Category: " + Category);
				System.out.println(", Name: " + Name );
				System.out.println(", Size: " + Size);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		return false;
	}
}
