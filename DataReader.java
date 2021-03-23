// --== CS400 File Header Information ==--
// Name: Vikas Raaja 
// Email: raaja@wisc.edu
// Team: JC Red
// Role: Data Wrangler
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None


import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 * Class that implements DataReaderInterface. It has only one method, which is critical to functionality 
 * of the entire program. 
 * 
 * @author vikas
 *
 */
public class DataReader implements DataReaderInterface{
	
	/**
	 * Extracts the contents of the pokemon_stats CSV file and adds them to a list. This method will be called on 
	 * by the Backend class to use the list of Pokemon
	 *  
	 * @param Reader inputFileReader - the CSV file that we use 
	 * @return List<PokemonInterface> - list of all pokemon from CSV
	 * @throws IOException - if inputFileReader is null 
	 */
	public List<PokemonInterface> readDataSet(Reader inputFileReader) throws IOException {
		List<PokemonInterface> list = new ArrayList<PokemonInterface>();
	    if (inputFileReader == null) throw new IOException();
	   	Scanner scan = new Scanner(inputFileReader); // scanning the CSV
	   	String temp = scan.nextLine(); // next line of the CSV
	   	if (temp != null) {
    		temp = scan.nextLine();
	    	while (scan.hasNextLine()) {
		    	// store Pokemon attribute names into an array of Strings 
	    		String[] headers = temp.split(",");
	    		// creating a local array of Strings to store Pokemon types 
	    		String[] types = new String[2];
	    		types[0] = headers[9];
	    		types[1] = headers[10];
	    		if (types[1].equals("None")) types[1] = null;
	    		// Now we add a new Pokemon object to the list. Most of the attributes in headers were ints converted
	    		// into strings. We have to parse those specific attributes back into ints 
						// ID			   name 
	    		list.add(new Pokemon(Integer.parseInt(headers[0]), headers[1], 
	    					// attack 		 defense 				 HP
	    				Integer.parseInt(headers[2]), Integer.parseInt(headers[3]), Integer.parseInt(headers[4]), 
	    				//region	speed 	        	  types
	    				headers[5], Integer.parseInt(headers[8]), types)); 			 
	    		temp = scan.nextLine();
	   		}
	    }
		return list;
	}
}
