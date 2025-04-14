package Week8Lab;

import java.util.*;
public class Movies{

	private String name;
	private Date release;
	private int rating;
	private String genre;

	public Movies(String name, Date release, int rating, String genre){
		this.name = name;
		this.release = release;
		this.rating = rating;
		this.genre = genre;
	}

	@Override
	public String toString()
	{
		return "******************************* \n Movie Name:\t" + this.name + "\n Release Date\t" + this.release + "\n Rating\t" + this.rating + "\n Genre\t" + this.genre;
	}


}