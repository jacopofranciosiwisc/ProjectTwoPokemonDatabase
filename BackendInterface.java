
// --== CS400 File Header Information ==--
// Name: Arnav Karnik
// Email: akarnik@wisc.edu
// Team: JC Red
// Role: Backend Developer 
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.List;

public interface BackendInterface {
  
  public void addPokemon(Pokemon pokemon);
  public Pokemon findPokemonCP(int cp);
  public List<Pokemon> getPokemonType(String type);
  public List<Pokemon> getPokemonCPRange(int cp1, int cp2);
  public List<Pokemon> getPokemonRegion(String region);
}
