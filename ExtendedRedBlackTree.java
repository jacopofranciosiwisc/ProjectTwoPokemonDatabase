// --== CS400 File Header Information ==--
// Name: Arnav Karnik
// Email: akarnik@wisc.edu
// Team: JC Red
// Role: Backend Developer 
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

/**
 * ExtendedRedBlackTree extends the RedBlack Tree class by adding a search method
 * @author arnav
 *
 * @param <T>
 */
public class ExtendedRedBlackTree<T> extends RedBlackTree<PokemonInterface>{
    public ExtendedRedBlackTree() {
        super();
    }
    
    /**
     * Search method that searches red black tree for given cp
     * @param cp
     * @return
     */
    public PokemonInterface getNode(int cp) {
        return getNodeHelper(cp, root);
    }
    
    /**
     * Helper method to find a node
     * @param cp
     * @param current
     * @return
     */
    public PokemonInterface getNodeHelper(int cp, Node<PokemonInterface> current) {
        if(current != null) { // makes sure the current node is not null
            if(cp > current.data.getCP()) {
                if(current.rightChild != null) {
                    return getNodeHelper(cp, current.rightChild);
                } else {
                    // if the pokemon in the red black tree do not have a cp value provided
                    return current.data;
                }
            } else if(cp < current.data.getCP()) {
                if(current.leftChild != null) {
                    return getNodeHelper(cp, current.leftChild);
                } else {
                    // if the pokemon in the red black tree do not have a cp value provided
                    return current.data;
                }
            }
            else {
                // when you find the pokemon with the cp value
                return current.data;
            }
        }
        return null; // if the root is null
    }
}
