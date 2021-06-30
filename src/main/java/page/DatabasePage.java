package page;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	
	public static String getData(String columName) throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sqlUrl="jdbc:mysql://localhost:3306/jan2021";
		String sqlUserName="root";
		String sqlPassword="1Jendj9y$";
		String query="select * from users";
		
		//creating a connection to your local Database
		Connection con = DriverManager.getConnection(sqlUrl, sqlUserName, sqlPassword);
		//Empowering the con ref variable to execute queries
		Statement smt = con.createStatement();
		//Executing query
	    ResultSet rs = smt.executeQuery(query);
	    while(rs.next()) {
	    	return rs.getString(columName);
	    	
	    }
	    
		return columName;
	
	}

}
