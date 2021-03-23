// --== CS400 File Header Information ==--
// Name: Arnav Karnik
// Email: akarnik@wisc.edu
// Team: JC Red
// Role: Backend Developer 
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Backend implements BackendInterface {
  
  private ExtendedRedBlackTree<PokemonInterface> _tree; // Red Black Tree containing all Pokemon
  private List<PokemonInterface> objList; // List of all the pokemon
  
  /**
   * Constructor to instantiate backend using a string array of arguments.
   * These arguments will be extracted from readDataSet()  written by the Data Wrangler 
   * 
   * @param args - String[] of arguments 
   * @throws FileNotFoundException - if the file isn't found
   */
  public Backend(String[] args) throws FileNotFoundException {
    // declaring all the instance objects
    //_tree = new ExtendedRedBlackTree<PokemonInterface>();
    
    // using readers to etract the list of Pokemon from the CSV
    FileReader reader = new FileReader(args[0]);
    BufferedReader file = new BufferedReader(reader);
    DataReader pokemonDataReader = new DataReader(); // instantiating a PokemonDataReader to extract Pokemon
    
    //Handling exceptions in attempts to declare _tree
    try {
      objList = pokemonDataReader.readDataSet(file);
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return;
    }
    // populating the red black tree with the method call below
    populatePokemonTree();
  }
  
  /**
   * Constructor to instantiate backend using a Reader object.
   * These reader will be used to extract pokemon from readDataSet() written by the Data Wrangler 
   * @param Reader r - the reader from the front end that facilitate's the extraction of the movies 
   */
  public Backend(Reader r) {
    //_tree = new ExtendedRedBlackTree<PokemonInterface>();
    
    DataReader pokemonDataReader = new DataReader();
    
    // Handling exceptions in attempts to declare _tree
    try {
      objList = pokemonDataReader.readDataSet(r);
    } catch(IOException e) {
      System.out.println(e.getMessage());
      return;
    }
    
    // Populating the red black tree with the method call below
    populatePokemonTree();
  }
  
  /**
   * Private helper method to populate the Pokemon Red Black Tree
   */
  private void populatePokemonTree() {
    for (PokemonInterface p: objList) {
      _tree.insert(p);
    }
  }
  
  /**
   * Allows the front end to add another pokemon into the red black tree
   */
  @Override
  public void addPokemon(PokemonInterface pokemon) {
    // TODO Auto-generated method stub
    _tree.insert(pokemon);
  }

  /**
   * Method that searches the red black tree for a certain Pokemon cp value
   * @return the Pokemon with the nearest CP value
   */
  @Override
  public PokemonInterface findPokemonCP(int cp) {
    // TODO Auto-generated method stub
    return _tree.getNode(cp);
  }
  
  /**
   * Method that creates a list of the selected Pokemon type inputed by the user
   * @return list of Pokemon with the selected type
   */
  @Override
  public List<PokemonInterface> getPokemonType(String type) {
    // TODO Auto-generated method stub
    ArrayList<PokemonInterface> list_types = new ArrayList<PokemonInterface>();
    Iterator<PokemonInterface> treeIterator = _tree.iterator();
    while(treeIterator.hasNext()) {
      PokemonInterface next = treeIterator.next();
      for(int i=0;i<next.getTypes().length;i++) {
        if(type.contains(next.getTypes()[i])) {
          list_types.add(next);
        }
      }
    }
    return list_types;
  }

  /**
   * Method that creates a list of Pokemon whose CP values are within 
   * the range inputed by the user
   * @return a list of Pokemon whose CP values are within the
   *         range that is selected by the user
   */
  @Override
  public List<PokemonInterface> getPokemonCPRange(int cp1, int cp2) {
    // TODO Auto-generated method stub
    ArrayList<PokemonInterface> list_pokemonInCPRange = new ArrayList<PokemonInterface>();
    Iterator<PokemonInterface> treeIterator = _tree.iterator();
    while(treeIterator.hasNext()) {
      PokemonInterface next = treeIterator.next();
      if(next.getCP() >= cp1 && next.getCP() <= cp2) {
        list_pokemonInCPRange.add(next);
      }
    }
    return list_pokemonInCPRange;
  }

  /**
   * Method that creates a list of Pokemon that are from the given region
   * prompted by the user
   * @return a list of Pokemon that are from the specific region specified by the user
   */
  @Override
  public List<PokemonInterface> getPokemonRegion(String region) {
    // TODO Auto-generated method stub
    ArrayList<PokemonInterface> list_regions = new ArrayList<PokemonInterface>();
    Iterator<PokemonInterface> treeIterator = _tree.iterator();
    while(treeIterator.hasNext()) {
      PokemonInterface next = treeIterator.next();
      if(region.contains(next.getRegion().toLowerCase().trim())) {
        list_regions.add(next);
      }
    }
    return list_regions;
  }
}
