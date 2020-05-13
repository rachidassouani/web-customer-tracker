package io.rachidassouani.testDb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "your_username";
		String pass = "your_password";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/customertracker?useSSl=false&serverTimezone=UTC";
		String driver  = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to the database ....!" + jdbcUrl);
			
			Class.forName(driver);
			
			Connection cnx = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("SUCCESS!");
			
			cnx.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
