//--== CS400 File Header Information ==--
// Name: Vikas Raaja
// Email: raaja@wisc.edu
// Team: JC Red
// Role: Data Wrangler
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader:

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;


/**
 * This class tests the methods from the Pokemon class 
 * and DataReaderInterface
 * 
 * @author Vikas 
 * 
 */
class DataWranglerTests {

    private static List<PokemonInterface> list; // List that holds all the pokemon from the CSV
    
    /**
     * Setting up the list of Pokemon. This method also tests readDataSet() from the DataReader.java class
     * as list calls on that method to receive the collection of all Pokemon objects 
     */
    @BeforeAll
    static void setup() {
    	try {
    		// creating new readers to set up the call to readDataSet()
    		BufferedReader br = new BufferedReader(new FileReader("pokemon_stats.csv"));
    		DataReader reader = new DataReader();
    		list = reader.readDataSet(br); 
    		// should print Blaziken
    		System.out.println(list.get(252).getName());
    	}
    	catch (FileNotFoundException e) {System.out.print(e.getMessage());}
    	catch (IOException e) {System.out.print(e.getMessage());}
    }

    
    /**
     * Testing getName()
     */
    @Test
    void testGetName() {
        // We are using the first Pokemon "Bulbasaur"
        assertEquals("Bulbasaur", list.get(0).getName(), "First Pokemon should be Bulbasaur");
    }


    /**
     * Testing getCP()
     */
    @Test
    void testGetCP() {
        // 302 is the manually calculated cp for Ivysaur 
        assertEquals(302, list.get(1).getCP(), "Ivysaur should have a cp of 302");
    }
    
    /**
     * Testing getID()
     */
    @Test
    void testGetID() {
        // We are using the Pokemon "Mewtwo" (145)
        assertEquals(145, list.get(145).getID(), "Mewtwo's ID is 145");
    }

    /**
     * Testing getRegion()
     */
    @Test
    void testGetRegion() {
        // We are using the Pokemon "Magnezone" (456)
        assertEquals("Sinnoh", list.get(456).getRegion(), "Magnezone is first introduced in the Sinnoh region");
    }

    /**
     * Testing getTypes()
     */
    @Test
    void testGetTypes() {
        String type1 = "Grass"; // first type for Pokemon "Applin" (828)
        String type2 = "Dragon"; // second type for Pokemon "Applin" (828)
        assertEquals(type1, list.get(828).getTypes()[0], "Applin's first type is grass");
        assertEquals(type2, list.get(828).getTypes()[1], "Applin's second type is dragon");
        
        // Now, we are using a Pokemon with only 1 type - Muk (85)
        assertEquals("Poison", list.get(85).getTypes()[0], "Muk's first type is poison");
        assertEquals(null, list.get(85).getTypes()[1], "Muk doesn't have a 2nd type");
        
        
    }
}


