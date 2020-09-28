package user.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Customer {
	/*
	 * Correspond to the user table
	 */
	
	private String customer_name;
	private String email; 
	private int id;
	

	
	public Customer() {
    }
 
    public Customer(int id) {
        this.id = id;
    }
 
    public Customer(int id, String customer_name, String email) {
        this(customer_name, email);
        this.id = id;
    }
     
    public Customer(String customer_name, String email) {
        this.customer_name = customer_name;
        this.email = email;
       
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getCustomer_name() {
        return customer_name;
    }
 
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
   
}