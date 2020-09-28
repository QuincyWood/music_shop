//package net.codejava.javaee.music_shop;
package user.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.Artist;
import user.domain.Artist;


 
/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author www.codejava.net
 *
 */
public class ArtistDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ArtistDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean insertArtist(Artist artist) throws SQLException {
        String sql = "INSERT INTO artist (Name, Song, Price, Year) VALUES (?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, artist.getartist_name());
        statement.setString(2,artist.getSong());
        statement.setInt(3, artist.getprice());
        statement.setInt(4, artist.getyear());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<Artist> listAllArtist() throws SQLException {
        List<Artist> listArtist = new ArrayList<>();
         
        String sql = "SELECT * FROM artist";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	int id = resultSet.getInt("id");
            String artist_name = resultSet.getString("Name");
            String song = resultSet.getString("Song");
            int price = resultSet.getInt("Price");
            int year =resultSet.getInt("Year");
          
             
            Artist artist = new Artist(id, artist_name, song, price, year);
            listArtist.add(artist);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listArtist;
    }
     
    public boolean deleteArtist(Artist artist) throws SQLException {
        String sql = "DELETE FROM artist where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, artist.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateArtist(Artist artist) throws SQLException {
        String sql = "UPDATE artist SET Name = ?, Song = ?, Price = ?, Year = ?";
     //   sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, artist.getartist_name());
        statement.setString(2, artist.getSong());
        statement.setInt(3, artist.getprice());
        statement.setInt(4, artist.getyear());
      //  statement.setInt(5, artist.getId());
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Artist getArtist(int id) throws SQLException {
        Artist artist = null;
        String sql = "SELECT * FROM artist WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String artist_name = resultSet.getString("Name");
            String song = resultSet.getString("Song");
            int price = resultSet.getInt("Price");
            int year =resultSet.getInt("Year");
            
             
            artist = new Artist(id,artist_name, song, price, year);
             
            
            
        }
         
        resultSet.close();
        statement.close();
         
        return artist;
    }
    public List<Artist> listAllQuery2() throws SQLException {
        List<Artist> listArtist = new ArrayList<>();
         
       // String sql = "SELECT * FROM artist";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *" +" FROM artist" + " WHERE Year = 2017");
         
        while (resultSet.next()) {
        	int id = resultSet.getInt("id");
            String artist_name = resultSet.getString("Name");
            String song = resultSet.getString("Song");
            int price = resultSet.getInt("Price");
            int year =resultSet.getInt("Year");
          
             
            Artist artist = new Artist(id, artist_name, song, price, year);
            listArtist.add(artist);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listArtist;
    }
    
    
}