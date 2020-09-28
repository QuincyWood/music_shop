package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.User;



/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class InitializeDao {
	
	
	/**
	 * get the search result with username 
	 * @param username
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void initDB()  {
		Statement statement; 
		PreparedStatement preparedstatements;
		ResultSet resultset;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/music_shop?serverTimezone=UTC&useLegacyDatetimeCode=false",
                              "root","Nin-ten-do-1");
		    
		statement = connect.createStatement();
		statement.executeUpdate("Drop Table If Exists customers");
		
		 String sql = "CREATE TABLE customers " +                         
                 " (id int(50) NOT NULL AUTO_INCREMENT  PRIMARY KEY, " + 
                 "  customer_name VARCHAR(50) NOT NULL, " + 
                 "  email VARCHAR(50) NOT NULL) ";
		 
		 statement.executeUpdate(sql);	
//		 
		 
			statement.executeUpdate("Drop Table if exists artist");
			
			 String sql1 = "CREATE TABLE artist " +            
	                 " (id INT(20) Not NULL AUTO_INCREMENT PRIMARY KEY, " + 
	                 "  Name VARCHAR(50) NOT NULL, " + 
	                 "  Song VARCHAR(50) NOT NULL, " + 
	                 "  Price INT(20)  NOT NULL, " + 
	                 "  Year INT(15) NOT NULL) ";
	                  
	                 			 
			 statement.executeUpdate(sql1);	
		 
			 statement.executeUpdate("Drop Table if exists event");
				
			 String sql2 = "CREATE TABLE event " +            
	                 " (id INT(20) Not NULL AUTO_INCREMENT primary key, " + 
	                 "  Name VARCHAR(50) NOT NULL, " +
	                  "Location VARCHAR(20), " + 
	                 " date VARCHAR(20)) ";
	                 
			 
			 statement.executeUpdate(sql2);	
			 
			 
		 preparedstatements = connect.prepareStatement("INSERT INTO customers (customer_name, email) VALUES (?, ?)");
	    
		 preparedstatements.setString(1, "Quincy Woodall");
		 preparedstatements.setString(2, "'quincy@user.com'");
		 
		 
		 preparedstatements.executeUpdate();
//		 
		 resultset = statement.executeQuery("Select * from customers");
//		 
//		
		 
		 preparedstatements = connect.prepareStatement("INSERT INTO artist (Name, Song, Price, Year) VALUES (?, ?, ?, ?)"); 
		 
		 preparedstatements.setString(1, "Kendrick Lamar");
		 preparedstatements.setString(2, "DNA");
		 preparedstatements.setInt(3, 15);
		 preparedstatements.setInt(4, 2017);
		 
		 preparedstatements.executeUpdate();
//		 
		 resultset = statement.executeQuery("Select * from artist");
		 
		 
		 preparedstatements = connect.prepareStatement("INSERT  into event  (Name,Location, date) VALUES (?,?, ?)");
		 
		 preparedstatements.setString(1, "Kendrick Lamar");   
		 preparedstatements.setString(2, "Chicago");
		 preparedstatements.setString(3, "Feb 15");
		 
		 preparedstatements.executeUpdate();
//		 
		 resultset = statement.executeQuery("Select * from event");
		 
		 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * insert User
	 * @param user
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
}
