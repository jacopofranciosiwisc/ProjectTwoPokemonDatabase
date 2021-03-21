// --== CS400 File Header Information ==--
// Name: Vikas Raaja 
// Email: raaja@wisc.edu
// Team: JC Red
// Role: Data Wrangler
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

/**
 * Interface to be implemented by the Data Wrangler to create a pokemon object 
 * @author vikas
 */
public interface PokemonInterface extends Comparable<PokemonInterface> {
	
	public String getName();
	public int getAttack();
	public int getDefense();
	public int getHP();
	public int getSpeed();
	public int getCP();
	public int getID();
	public String getRegion();
	public String[] getTypes();
	public int compareTo(PokemonInterface otherPokemon); // from Comparable Interface

}
