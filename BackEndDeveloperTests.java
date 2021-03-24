// --== CS400 File Header Information ==--
// Name: Arnav Karnik
// Email: akarnik@wisc.edu
// Team: JC Red
// Role: Backend Developer
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BackEndDeveloperTests {
  FileReader r1;
  @BeforeEach
  void createBackend() {
    
    try {
      r1 = new FileReader("pokemon_stats.csv");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * This test method adds a blastoise pokemon into the red black tree.
   * Next you get the region of this pokemon in the red black tree to see
   * if the pokemon was successfully added to the red black tree.
   */
  @Test
  void testAddPokemon() {
    Backend backend = new Backend(r1);
    Pokemon Blastoise = new Pokemon(4, "blastoise", 2311, 786, 3579, "Bob", 32, null);
    backend.addPokemon(Blastoise);
    //System.out.println(backend.getPokemonRegion("Bob").get(0));
    assertEquals(Blastoise, backend.getPokemonRegion("Bob").get(0));
  }
  
  /**
   * This test method adds three Pokemon into the red black tree.
   * After checks the implementation of findCP method by passing in 156.
   * The Pokemon Pikachu should be returned from the method since Pikachu's
   * CP value is 156
   */
  @Test
  void testFindCP() {
    Backend backend = new Backend(r1);
    Pokemon Blastoise = new Pokemon(4, "blastoise", 243, 545, 365, "Kanto", 43, null);
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 40, 22, 70, "Kanto", 20, null);
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 234, 545, 266, "Sinnoh", 21, null);
    backend.addPokemon(Arceus);
    //System.out.println(backend.findPokemonCP(156));
    assertEquals(Pikachu, backend.findPokemonCP(156));
  }
  
/**
 * This test method adds three Pokemon into the red black tree.
 * After checks the implementation of the getPokemonType() method.
 * Then checks the list returned by the method consists only of Pikachu
 * since this is the only pokemon of type Electric
 */
  @Test
  void testGetPokemonType() {
    Backend backend = new Backend(r1);
    Pokemon Blastoise = new Pokemon(4, "blastoise", 243, 534, 325, "Kanto", 43, new String[]{"Steel", "Water"});
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 412, 242, 70, "Kanto", 20, new String[]{"Rohan", "Flying"});
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 76, 433, 2326, "Sinnoh", 21, new String[]{"Grass", "Ice"});
    backend.addPokemon(Arceus);
    //System.out.println(backend.getPokemonType("Rohan"));
    ArrayList<Pokemon> list = new ArrayList<Pokemon>();
    list.add(Pikachu);
    assertEquals(list, backend.getPokemonType("Rohan"));
  }
  
  /**
   * This test method adds three Pokemon into the red black tree. 
   * After checks the implementation of the getPokemonInCPRange.
   * Then checks if the list provided back from the method consists of 
   * Pikachu and Arceus.
   */
  @Test
  void testGetPokemonCPRange() {
    Backend backend = new Backend(r1);
    Pokemon Blastoise = new Pokemon(4, "blastoise", 23, 58774, 35, "Kanto", 43, null);
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 40, 22, 7077, "Kanto", 20, null); // 5061
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 40, 2893, 72, "Sinnoh", 291, null); // 2461
    backend.addPokemon(Arceus);
    //System.out.println(backend.getPokemonCPRange(150, 170));
    ArrayList<Pokemon> _lst = new ArrayList<Pokemon>();
    _lst.add(Arceus);
    _lst.add(Pikachu);
    assertEquals(_lst, backend.getPokemonCPRange(2400, 5065));
  }

  /**
   * This test method adds three Pokemon into the red black tree.
   * After checks the implementation of the getPokemonRegion method
   * by passing the region "Kanto". This should return the Pokemon 
   * Pikachu and Blastoise in a list since they are from the same region.
   */
  @Test
  void testGetPokemonRegion() {
    Backend backend = new Backend(r1);
    Pokemon Blastoise = new Pokemon(4, "blastoise", 2433, 9944, 35, "Rohan", 43, null);
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 402, 223, 740, "Rohan", 20, null);
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 430, 233, 272, "Sinnoh", 21, null);
    backend.addPokemon(Arceus);
    //System.out.println(backend.getPokemonRegion("Rohan"));
    ArrayList<Pokemon> list = new ArrayList<Pokemon>();
    list.add(Pikachu);
    list.add(Blastoise);
    assertEquals(list, backend.getPokemonRegion("Rohan"));
  }
}
