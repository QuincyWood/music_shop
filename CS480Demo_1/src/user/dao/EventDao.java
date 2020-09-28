package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.util.ArrayList;
import java.util.List;

import user.domain.Event;




/**
 * DDL functions performed in database
 * @author changxin bai
 *
 */
public class EventDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public EventDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean insertEvent(Event event) throws SQLException {
        String sql = "INSERT INTO event (Name,Location, date ) VALUES (?,?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, event.getName());
        statement.setString(2, event.getLocation());
        statement.setString(3, event.getdate());
        
       
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Event> listAllEvent() throws SQLException {
        List<Event> listEvent = new ArrayList<>();
         
        String sql = "SELECT * FROM event";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String Location = resultSet.getString("Location");
            String date = resultSet.getString("date");
            String Name = resultSet.getString("Name");
             
            Event event = new Event(id,Name, Location,date);
            listEvent.add(event);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listEvent;
    }
     
    public boolean deleteEvent(Event event) throws SQLException {
        String sql = "DELETE FROM event where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, event.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateEvent(Event event) throws SQLException {
        String sql = "UPDATE event SET Name = ?,Location = ?, date = ?" ;
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, event.getLocation());
        statement.setString(2, event.getdate());   
        statement.setString(3, event.getName());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Event getEvent(int id) throws SQLException {
    	Event event = null;
        String sql = "SELECT * FROM event WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String Location = resultSet.getString("Location");
            String date = resultSet.getString("date");
            String Name = resultSet.getString("Name");
             
            event = new Event(id, Name, Location, date);
        }
         
        resultSet.close();
        statement.close();
         
        return event;
    }
    
    public List<Event> listQuery3() throws SQLException {
        List<Event> listEvent = new ArrayList<>();
         
        //String sql = "SELECT * FROM event";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *" + "FROM event" + " WHERE Location = 'Chicago'");
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String Location = resultSet.getString("Location");
            String date = resultSet.getString("date");
            String Name = resultSet.getString("Name");
             
            Event event = new Event(id,Name, Location,date);
            listEvent.add(event);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listEvent;
    }
}