
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
  
  public void addPokemon(PokemonInterface pokemon);
  public PokemonInterface findPokemonCP(int cp);
  public List<PokemonInterface> getPokemonType(String type);
  public List<PokemonInterface> getPokemonCPRange(int cp1, int cp2);
  public List<PokemonInterface> getPokemonRegion(String region);
}
