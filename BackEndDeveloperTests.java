import static org.junit.jupiter.api.Assertions.*;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BackendTest {
  Backend backend;
  @BeforeEach
  void createBackend() {
    FileReader r1;
    try {
      r1 = new FileReader("src/pokemon_stat.csv");
      backend = new Backend(r1);
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
    Pokemon Blastoise = new Pokemon(4, "blastoise", 23, 54, 35, "Kanto", 32, null);
    backend.addPokemon(Blastoise);
    System.out.println(backend.getPokemonRegion("Kanto").get(0));
    assertEquals(Blastoise, backend.getPokemonRegion("Kanto").get(0));
  }
  
  /**
   * This test method adds three Pokemon into the red black tree.
   * After checks the implementation of findCP method by passing in 156.
   * The Pokemon Pikachu should be returned from the method since Pikachu's
   * CP value is 156
   */
  @Test
  void testFindCP() {
    Pokemon Blastoise = new Pokemon(4, "blastoise", 23, 54, 35, "Kanto", 43, null);
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 40, 22, 70, "Kanto", 20, null);
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 76, 43, 26, "Sinnoh", 21, null);
    backend.addPokemon(Arceus);
    System.out.println(backend.findPokemonCP(156));
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
    Pokemon Blastoise = new Pokemon(4, "blastoise", 23, 54, 35, "Kanto", 43, new String[]{"Steel", "Water"});
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 40, 22, 70, "Kanto", 20, new String[]{"Electric", "Flying"});
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 76, 43, 26, "Sinnoh", 21, new String[]{"Grass", "Ice"});
    backend.addPokemon(Arceus);
    System.out.println(backend.getPokemonType("Electric"));
    ArrayList<Pokemon> list = new ArrayList<Pokemon>();
    list.add(Pikachu);
    assertEquals(list, backend.getPokemonType("Electric"));
  }
  
  /**
   * This test method adds three Pokemon into the red black tree. 
   * After checks the implementation of the getPokemonInCPRange.
   * Then checks if the list provided back from the method consists of 
   * Pikachu and Arceus.
   */
  @Test
  void testGetPokemonCPRange() {
    Pokemon Blastoise = new Pokemon(4, "blastoise", 23, 54, 35, "Kanto", 43, null);
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 40, 22, 70, "Kanto", 20, null);
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 40, 23, 72, "Sinnoh", 21, null);
    backend.addPokemon(Arceus);
    System.out.println(backend.getPokemonCPRange(150, 170));
    ArrayList<Pokemon> _lst = new ArrayList<Pokemon>();
    _lst.add(Pikachu);
    _lst.add(Arceus);
    assertEquals(_lst, backend.getPokemonCPRange(150, 170));
  }

  /**
   * This test method adds three Pokemon into the red black tree.
   * After checks the implementation of the getPokemonRegion method
   * by passing the region "Kanto". This should return the Pokemon 
   * Pikachu and Blastoise in a list since they are from the same region.
   */
  @Test
  void testGetPokemonRegion() {
    Pokemon Blastoise = new Pokemon(4, "blastoise", 23, 54, 35, "Kanto", 43, null);
    backend.addPokemon(Blastoise);
    Pokemon Pikachu = new Pokemon(2, "Pikachu", 40, 22, 70, "Kanto", 20, null);
    backend.addPokemon(Pikachu);
    Pokemon Arceus = new Pokemon(1, "Arceus", 40, 23, 72, "Sinnoh", 21, null);
    backend.addPokemon(Arceus);
    System.out.println(backend.getPokemonRegion("Kanto"));
    ArrayList<Pokemon> list = new ArrayList<Pokemon>();
    list.add(Pikachu);
    list.add(Blastoise);
    assertEquals(list, backend.getPokemonRegion("Kanto"));
  }
}
