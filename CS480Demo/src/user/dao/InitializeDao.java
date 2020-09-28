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
		statement.executeUpdate("Drop Table if Customers exist");
		
		 String sql = "CREATE TABLE Customers " +            
                 " (first VARCHAR(255), " + 
                 " last VARCHAR(255), " + 
                 " email address VARCHAR(255), " + 
                 " PRIMARY KEY ( id ))"; 
		 
		 statement.executeUpdate(sql);	
//		 
		 
			statement.executeUpdate("Drop Table if Artist exist");
			
			 String sqlm = "CREATE TABLE Artist " +            
	                 " (Name VARCHAR(255), " + 
	                 " Song VARCHAR(255), " + 
	                 " Price VARCHAR(255), " + 
	                 " Year VARCHAR(255)"; 
			 
			 statement.executeUpdate(sqlm);	
		 
			 statement.executeUpdate("Drop Table if Event exist");
				
			 String sqlmn = "CREATE TABLE Event " +            
	                 " (Location VARCHAR(255), " + 
	                 " Date VARCHAR(255), " + 	     
	                 " PRIMARY KEY ( ticket_id ))"; 
			 
			 statement.executeUpdate(sqlmn);	
			 
			 
//		 preparedstatements = connect.prepareStatement("insert info of customers(name, email, ID )");
//		 preparedstatements.setString(12345, "Quincy Woodall, quincy@user.com");
//		 preparedstatements.setString(12378, "Joe Name, joe1@user.com");
//		 preparedstatements.setString(24689, "Kill Bill, great_Movie@user.com");
//		 
//		 preparedstatements.executeUpdate();
//		 
//		 resultset = statement.executeQuery("Select * from Customers");
//		 
//		
		 
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
