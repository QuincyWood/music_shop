package user.domain;

/**
 * User object
 * 
 * @author changxin bai
 * 
 */
public class Artist {
	/*
	 * Correspond to the user table
	 */
	
	private int id;
	private String artist_name;
	private String song; 
	private int price;
	private int year;
	
	
	public Artist() {
    }
	
	 public Artist(int id) {
		 this.id = id;
	    }
	 
	 
	    public Artist(int id,String artist_name, String song, int price, int year) {
	    	this(artist_name, song, price, year);
//	        this.year = year;
//	        this.price = price;
//	        this.artist_name = artist_name;
//	        this.song = song;
//	        this.price = price;	
	        this.id = id;
	    }
	     
	    public Artist(String artist_name,String song, int price, int year) {	      
	    	this.artist_name = artist_name;
	    	this.song = song;
	        this.price = price;
	        this.year = year;
	    }
	

	
	public String getartist_name() {
		return artist_name;
	}

	public void setartist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public int getyear() {
		return year;
	}

	public void setyear(int year) {
		this.year = year;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	
//	@Override
//	public String toString() {
//		return "User [ artist_name=" + artist_name + ", price="
//				+ price + ", id=" + id +"]";
//	}
}
