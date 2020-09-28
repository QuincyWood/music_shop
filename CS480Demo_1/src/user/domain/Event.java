package user.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Event {
	/*
	 * Correspond to the user table
	 */
	private String Name;
	private String location;
	private String date; 
	private int id;
	

	
	public Event() {
    }
 
    public Event(int id) {
        this.id = id;
    }
 
    public Event(int id, String Name, String location, String date) {
        this(Name,location, date);
        this.id = id;
    }
     
    public Event(String Name,String location, String date) {
        this.setName(Name);
    	this.location = location;
        this.date = date;
       
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }
 
    public String getdate() {
        return date;
    }
 
    public void setdate(String date) {
        this.date = date;
    }

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
 
   
}