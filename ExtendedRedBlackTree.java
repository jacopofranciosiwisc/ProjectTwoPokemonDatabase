// --== CS400 File Header Information ==--
// Name: Arnav Karnik
// Email: akarnik@wisc.edu
// Team: JC Red
// Role: Backend Developer 
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

public class ExtendedRedBlackTree<T> extends RedBlackTree{
  public ExtendedRedBlackTree() {
    super();
  }
  public PokemonInterface getNode(int cp) {
    return getNodeHelper(cp, root);
  }
  public PokemonInterface getNodeHelper(int cp, Node<PokemonInterface> current) {
    while(current != null) {
      if(cp > current.data.getCP()) {
        // do something
      } else if(cp < current.data.getCP()) {
        // do another something
      }
      else {
        // when you find the pokemon with the cp value
        return current.data;
      }
    }
    // if the pokemon in the red black tree do not have a cp value provided
    return current.parent.data;
  }
}
