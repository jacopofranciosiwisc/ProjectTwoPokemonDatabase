import java.util.*;



public class Backend implements BackendInterface {
  private RedBlackTree<Pokemon> _tree; // Red Black Tree containing all Pokemon
  
  /**
   * Constructor that instantiates the backend object and the red black tree as well
   */
  public Backend() {
    _tree = new RedBlackTree<Pokemon>();
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
  public void addPokemon(Pokemon pokemon) {
    // TODO Auto-generated method stub
    _tree.insert(pokemon);
  }

  /**
   * Method that searches the red black tree for a certain Pokemon cp value
   * @return the Pokemon with the nearest CP value
   */
  @Override
  public Pokemon findPokemonCP(int cp) {
    // TODO Auto-generated method stub
    return lookupHelper(cp, _tree.root);
  }
 
  /**
   * Helper method for findPokemonCP
   * @param cp
   * @param current
   * @return
   */
  public static Pokemon lookupHelper(int cp, Node<Pokemon> current) {
    while(current != null) {
      if(cp < current.getCP()) {
        current = current.getLeftChild();
      }
      else if(cp > current.getCP()) {
        current = current.getRightChild();
      }
      else {
        return current;
      }
    }
    return current.parent;
  }
  
  /**
   * Method that creates a list of the selected Pokemon type inputed by the user
   * @return list of Pokemon with the selected type
   */
  @Override
  public List<Pokemon> getPokemonType(String type) {
    // TODO Auto-generated method stub
    ArrayList<Pokemon> list_types = new ArrayList<Pokemon>();
    Iterator<Pokemon> treeIterator = _tree.iterator();
    while(treeIterator.hasNext()) {
      Pokemon next = treeIterator.next();
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
  public List<Pokemon> getPokemonCPRange(int cp1, int cp2) {
    // TODO Auto-generated method stub
    ArrayList<Pokemon> list_pokemonInCPRange = new ArrayList<Pokemon>();
    Iterator<Pokemon> treeIterator = _tree.iterator();
    while(treeIterator.hasNext()) {
      Pokemon next = treeIterator.next();
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
  public List<Pokemon> getPokemonRegion(String region) {
    // TODO Auto-generated method stub
    ArrayList<Pokemon> list_regions = new ArrayList<Pokemon>();
    Iterator<Pokemon> treeIterator = _tree.iterator();
    while(treeIterator.hasNext()) {
      Pokemon next = treeIterator.next();
      if(region.contains(next.getRegion().toLowerCase().trim())) {
        list_regions.add(next);
      }
    }
    return list_regions;
  }
}
