package com.mano.testingServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSearch01
 */
@WebServlet({"/ServletSearch01", "/search1"})
public class ServletSearch01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSearch01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String s = request.getParameter("parm1");
		
		PrintWriter out = response.getWriter();
		String v = "<html><h1>" + "Bridal Wear" + "</h1>";
		out.println(v);
		
		//TestingJDBC02 db = new TestingJDBC02();
		//db.SQLSelect();
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
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
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
				System.out.print(", Name: " + Name );
				System.out.println(", Color: " + Color);
				System.out.println(", Size: " + Size);
				System.out.println(", Price: " + Price);
				System.out.println(", Description: " + Description);
				
				String w = DressID + "  " + Category + "  " + Name + "  " + Color + "  " + Size + "  " + Price + "  " + Description;
				out.println(w);
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
	}

}
