// --== CS400 File Header Information ==--
// Name: Vikas Raaja 
// Email: raaja@wisc.edu
// Team: JC Red
// Role: Data Wrangler
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.List;
import java.util.zip.DataFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

/**
 * Interface to be implemented by the Data Wrangler. It contains only method called readDataSet()
 * @author vikas
 *
 */
public interface DataReaderInterface{

	public List<PokemonInterface> readDataSet(Reader inputFileReader) throws FileNotFoundException, IOException, DataFormatException;

}
