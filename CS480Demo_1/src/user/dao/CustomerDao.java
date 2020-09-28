package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.util.ArrayList;
import java.util.List;

import user.domain.Customer;
import user.domain.Artist;




/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class CustomerDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    Statement statement; 
	PreparedStatement preparedstatements;
	ResultSet resultset;
    public CustomerDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean insertCustomer(Customer customers) throws SQLException {
        String sql = "INSERT INTO customers (customer_name, email ) VALUES (?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customers.getCustomer_name());
        statement.setString(2, customers.getEmail());
        
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Customer> listAllCustomer() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();
         
        String sql = "SELECT * FROM customers";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String customer_name = resultSet.getString("customer_name");
            String email = resultSet.getString("email");
            
             
            Customer customers = new Customer(id, customer_name,email);
            listCustomer.add(customers);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCustomer;
    }
     
    public boolean deleteCustomer(Customer customers) throws SQLException {
        String sql = "DELETE FROM customers where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, customers.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateCustomer(Customer customers) throws SQLException {
        String sql = "UPDATE customers SET customer_name = ?, email = ?" ;
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customers.getCustomer_name());
        statement.setString(2, customers.getEmail());   
        
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Customer getCustomer(int id) throws SQLException {
    	Customer customers = null;
        String sql = "SELECT * FROM customers WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String customer_name = resultSet.getString("customer_name");
            String email = resultSet.getString("email");
           
             
            customers = new Customer(id, customer_name, email);
        }
         
        resultSet.close();
        statement.close();
         
        return customers;
    }
    
    public List<Customer> listAllQuery() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();
         
        //String sql = ("SELECT * FROM customers WHERE customer_name = Quincy Woodall");
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        //statement.executeQuery("SELECT * FROM customers WHERE customer_name = Quincy Woodall");
        ResultSet resultSet = statement.executeQuery("SELECT *" +" FROM customers" + " WHERE customer_name = 'Keith'");
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String customer_name = resultSet.getString("customer_name");
            String email = resultSet.getString("email");
            
             
            Customer customers = new Customer(id, customer_name,email);
            listCustomer.add(customers);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCustomer;
    }
    
    public List<Customer> listAllComQuery() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();
       // List<Artist> listArtist = new ArrayList<>();
         
        //String sql = ("SELECT * FROM customers WHERE customer_name = Quincy Woodall");
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        //statement.executeQuery("SELECT * FROM customers WHERE customer_name = Quincy Woodall");
        ResultSet resultSet = statement.executeQuery("SELECT *" + "from customers" + "JOIN artist on customers.id = artist.id");
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String customer_name = resultSet.getString("customer_name");
            String email = resultSet.getString("email");
//            String artist_name  = resultSet.getString("artist_name");
//            String song = resultSet.getString("Song");
//            int price = resultSet.getInt("Price");
//            int year = resultSet.getInt("Year");
             
            Customer customers = new Customer(id, customer_name,email);
          //  Artist artist = new Artist(id, artist_name,song,price,year );
            listCustomer.add(customers);
           // listArtist.add(artist);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCustomer;
    }
    
  
    
}