package user.web.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.ArtistDao;
import user.dao.CustomerDao;
import user.dao.EventDao;
import user.domain.Artist;
import user.domain.Customer;
import user.domain.Event;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDao customerDao;
    private ArtistDao artistDao;
    private EventDao eventDao;
	PreparedStatement preparedstatements;
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        customerDao = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword);
        artistDao = new ArtistDao(jdbcURL, jdbcUsername, jdbcPassword);
        eventDao = new EventDao(jdbcURL, jdbcUsername, jdbcPassword);
                
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        System.out.println(action);
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);               
                break;
            case "/new_2":
            	showNewForm_art(request, response);
            	break;
            case "/new_3":
            	showNewForm_event(request, response);
            	break;
            case "/insert":
                insertCustomer(request, response);        
                break;
            case "/insert_2":
            	insertArtist(request, response);
            	break;
            case "/insert_3":
            	insertEvent(request, response);
            	break;
            case "/delete":
                deleteCustomer(request, response);
                break;
            case "/delete_2":
            	deleteArtist(request, response);
            	break;
            case "/delete_3":
            	deleteEvent(request, response);
            	break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/edit_2":
            	showEditForm_art(request, response);
            	break;
            case "/edit_3":
            	showEditForm_event(request, response);
            	break;	
            case "/update":
                updateCustomer(request, response);
                break;
            case "/update_2":
            	updateArtist(request, response);
            	break;
            case "/update_3":
            	updateEvent(request, response);
            	break;
            case "/list":
                listCustomer(request, response);
                break; 
            case "/list_Query":
            	listQuery(request, response);
                break;
            case "/list_Query2":
            	listQuery2(request, response);
                break;
            case "/list_Query3":
            	listQuery3(request, response);
                break;
            case "/list_Com_Query":
            	listQuery_Com(request, response);
                break;
            case "/list1":
        		listArtist(request, response);
        		break;
            case "/list2":
        		listEvent(request, response);
        		break;                            	
        }                                                                          
            
            }
                                               
        catch (SQLException ex) {
            throw new ServletException(ex);
        }
                                                
    }
      
    private void listEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Event> listEvent= eventDao.listAllEvent();
        request.setAttribute("listEvent", listEvent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/Eventlist.jsp");
        dispatcher.forward(request, response);
    }
    
    
    private void listArtist(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Artist> listArtist = artistDao.listAllArtist();
        request.setAttribute("listArtist", listArtist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/Artistlist.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listQuery(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerDao.listAllQuery();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/simplelist.jsp");
        dispatcher.forward(request, response);
    }
    private void listQuery_Com(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerDao.listAllComQuery();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/complexlist.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listQuery2(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Artist> listArtist = artistDao.listAllQuery2();
        request.setAttribute("listArtist", listArtist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/simplelist2.jsp");
        dispatcher.forward(request, response);
    }
   
    private void listQuery3(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Event> listEvent = eventDao.listQuery3();
        request.setAttribute("listEvent", listEvent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/simplelist3.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = customerDao.listAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/customerlist.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewForm_event(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/EventForm.jsp");
        dispatcher.forward(request, response);
    }
    
    
    private void showNewForm_art(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/ArtistForm.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/CustomerForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm_event(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Event existingEvent = eventDao.getEvent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/EventForm.jsp");
        request.setAttribute("event", existingEvent);
        dispatcher.forward(request, response);
 
    }
    
    
    private void showEditForm_art(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Artist existingArtist = artistDao.getArtist(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/ArtistForm.jsp");
        request.setAttribute("artist", existingArtist);
        dispatcher.forward(request, response);
 
    }
    
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerDao.getCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/user/CustomerForm.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
 
    }
    
    private void insertEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String Location = request.getParameter("Location");       
        String date = request.getParameter("date");
        String Name = request.getParameter("Name");
 
        Event newEvent = new Event(Name,Location, date);
        eventDao.insertEvent(newEvent);
        response.sendRedirect("list2");
    }
    
    private void insertArtist(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String Name = request.getParameter("Name");         	
        String Song = request.getParameter("Song");  
        int Price = Integer.parseInt(request.getParameter("Price"));    
        int Year = Integer.parseInt(request.getParameter("Year"));
        
        Artist newArtist = new Artist(Name, Song, Price, Year);
        artistDao.insertArtist(newArtist);
        response.sendRedirect("list1");
    }
    
 
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String customer_name = request.getParameter("customer_name");
        String email = request.getParameter("email");
       
 
        Customer newCustomer = new Customer(customer_name, email);
        customerDao.insertCustomer(newCustomer);
        response.sendRedirect("list");
    }
    
    private void updateEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String Location = request.getParameter("Location");
        String date = request.getParameter("date");
        String Name = request.getParameter("Name");
 
        Event event = new Event(id, Name,Location, date);
        eventDao.updateEvent(event);
        response.sendRedirect("list2");
    }
    
 
    private void updateArtist(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String Name = request.getParameter("Name");
        String Song = request.getParameter("Song");
        int Price = Integer.parseInt(request.getParameter("Price"));
        int Year = Integer.parseInt(request.getParameter("Year"));
        
        Artist artist = new Artist(id, Name, Song,Price, Year);
        artistDao.updateArtist(artist);
        response.sendRedirect("list1");
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String customer_name = request.getParameter("customer_name");
        String email = request.getParameter("email");
        
 
        Customer customers = new Customer(id, customer_name, email);
        customerDao.updateCustomer(customers);
        response.sendRedirect("list");
    }
    
    private void deleteEvent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Event event = new Event(id);
        eventDao.deleteEvent(event);
        response.sendRedirect("list2");
 
    }
    
    private void deleteArtist(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Artist artist = new Artist(id);
        artistDao.deleteArtist(artist);
        response.sendRedirect("list1");
 
    }
 
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Customer customers = new Customer(id);
        customerDao.deleteCustomer(customers);
        response.sendRedirect("list");
 
    }
    
    
    
}