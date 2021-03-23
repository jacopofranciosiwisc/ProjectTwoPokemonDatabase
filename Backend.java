import java.util.*;

public class Backend implements BackendInterface {
  
  private RedBlackTree<PokemonInterface> _tree; // Red Black Tree containing all Pokemon
  
  /**
   * Constructor that instantiates the backend object and the red black tree as well
   */
  public Backend() {
    _tree = new RedBlackTree<PokemonInterface>();
  }
  
  /**
   * Private helper method to populate the Pokemon Red Black Tree
   */
  private void populatePokemonTree() {
    
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
    if(_tree == null) throw new NullPointerException(
          "This RedBlackTree cannot store null references.");
    return getPokemonHelper(cp, _tree.root);
  }
  
  private PokemonInterface getPokemonHelper(int val, Node<PokemonInterface> subtree) {
    if(subtree == null) {
      return subtree.parent;
    }
    else {
      int compare = val.compareTo(subtree.data);
      if(compare < 0) {
        return getPokemonHelper(val, subtree.leftChild);
      } else if(compare > 0) {
        return getPokemonHelper(val, subtree.rightChild);
      } else {
        // pokemon was found with specific cp value
        return subtree;
      }
    }
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
    ArrayList<PokemonInterface> list_pokemonInCPRange = new ArrayList<Pokemon>();
    Iterator<PokemonInterface> treeIterator = _tree.iterator();
    while(treeIterator.hasNext()) {
      PokemonInterface next = treeIterator.next();
      if(next.getCP() > cp1 && next.getCP() < cp2) {
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
