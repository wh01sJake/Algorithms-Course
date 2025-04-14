package Week8Lab;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class ReadMovies{
	public static void main(String args[]) throws Exception{
		BufferedReader br=null;
		ArrayList<Movies> movieList = new ArrayList<>();

		 

		try{
			br = new BufferedReader(new FileReader("movie_data.csv"));
			String line;
			String[] tempArr; // using this to store each column in a line

			br.readLine(); // reading first line to avoid the header

			// this is used to format the incoming date
			SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");

			while((line = br.readLine()) != null){ // reading each line of file
				tempArr = line.split(","); // each column has a comma between it

				//associating each input with a variable type
				// first input is the title so it's string
				String title = tempArr[0];
				//second input is a Date so we need to convert string to date
				Date release = ft.parse(tempArr[1]);
				// third input is the rating which is an int
				int rating = Integer.parseInt(tempArr[2]);
				// fourth input is the genre which stays as string
				String genre = tempArr[3];

				movieList.add(new Movies(title, release, rating, genre));
			}
		}
		finally{ // closes the buffered read regardless of whether an exception was called.
			if(br!=null)
			{
				br.close();
			}
		}

		// prints out all the movie data
		for(Movies movie : movieList)
		{
			System.out.println(movie);
		}
	}
}