// --== CS400 File Header Information ==--
// Name: Rohan Putcha
// Email: rputcha@wisc.edu
// Team: JC red
// Role: Frontend Developer
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 * The Frontend class connects the backend implementation to the user through commands. The user may add Pokemon
 * and search (using various criteria) for Pokemon, accessing the backend through Frontend commands in this class.
 *
 * @author Rohan Putcha
 */
public class Frontend {

    private BufferedReader inputFile; // refers to the variable holding the input file for the backend instantiation
    private Scanner scanner; // the scanner used throughout the program maintaining the same input buffer
    private static int idOfNewPokemon; // the static int is used to keep track of IDs of newly added Pokemon

    /**
     * Constructor takes no arguments and instantiates a scanner to be used in prompts and
     * the starting ID for all new Pokemon. The constructor is essential in providing the path for the CSV
     * file where all existing pokemon data is accessed. This should always be run first in order to use
     * frontendObj.inputFile to use as a parameter in creating a Backend object. An example of this is in
     * the main method of the application.
     */
    public Frontend() {
        BufferedReader filein = null;
        try {
            FileReader reader = new FileReader("src/pokemon_stats.csv"); // path to csv
            filein = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        inputFile = filein;
        scanner = new Scanner(System.in);
        idOfNewPokemon = 900; // ID starts at 900 since existing pokemon in the database populate approximately 0-900
    }

    /**
     * Main method within the frontend which instantiates the frontend object and runs it.
     *
     * @param args input arguments when running the program
     */
    public static void main(String [] args) {
        Frontend frontend = new Frontend();
        frontend.run(new Backend(frontend.inputFile));
    }

    /**
     * The run method takes a backend object as a parameter to run the program with. This method simply
     * prints the welcome message and calls the first state of the application.
     *
     * @param backend the backend object that the application is based upon
     */
    public void run(BackendInterface backend) {
        System.out.println("Welcome to the Pokemon Catalog!");
        this.mainScreen(backend);
    }

    /**
     * This is the main menu where all options can be accessed. From here, the program may enter 3 other states:
     * add mode, search mode, exit program screen. Depending on user input, these different states may be accessed.
     * There is a while loop that is continuously run so that other states can simply return and the application
     * will proceed to run again and again without needing inefficient recursion (very large call stacks).
     *
     * @param backend the backend object that is the backbone of the application is not accessed here but is passed
     *                along to other methods for use
     */
    public void mainScreen(BackendInterface backend) {
        while (true) {
            // while loop runs while program runs
            System.out.println("\nMain screen");
            System.out.println("-----------");
            System.out.println("You can search for Pokemon in the existing database and add your own new Pokemon!");
            System.out.println("\nWhat would you like to do?");
            System.out.println("\t1) Enter 'a' to go to add mode");
            System.out.println("\t2) Enter 's' to go to search mode");
            System.out.println("\t3) Enter 'x' to exit the program");
            System.out.println();

            String command = scanner.next();
            if (command.equals("x"))
                break;
            else if (command.equals("a"))
                addMode(backend);
            else if (command.equals("s"))
                searchMode(backend);
            else
                System.out.println("Enter a valid command!");
        }
        // once while loop exits (x is entered), call end screen
        endScreen();
    }

    /**
     * The program enters add mode when 'a' is entered from the main screen. Here, the user is able to create
     * a new pokemon by providing all the needed information to add to the backend/RBT. The user is prompted for required
     * stats to calculate CP and define attributes like region and types. At any point, if the user types 'x', they are
     * sent back to the main screen.
     *
     * @param backend the backend object's addPokemon method is used to add the new pokemon which was created
     *                by combining all the given attributes into the constructor
     */
    public void addMode(BackendInterface backend) {
        System.out.println("\nAdd Mode");
        System.out.println("--------");
        System.out.println("You will now add information for each attribute of a new Pokemon. Type 'x' at any point" +
                " to exit add mode.");
        // get each attribute one at a time: name, attack, defense, hp, speed, region, types. x at any time should
        // return to main screen
        System.out.print("\nEnter Pokemon name: ");
        String name = scanner.next();
        if (name.equals("x"))
            return;
        System.out.print("\nEnter Pokemon attack stat: ");
        String attack = scanner.next();
        if (attack.equals("x"))
            return;
        System.out.print("\nEnter Pokemon defense stat: ");
        String defense = scanner.next();
        if (defense.equals("x"))
            return;
        System.out.print("\nEnter Pokemon HP: ");
        String HP = scanner.next();
        if (HP.equals("x"))
            return;
        System.out.print("\nEnter Pokemon speed: ");
        String speed = scanner.next();
        if (speed.equals("x"))
            return;
        System.out.print("\nEnter Pokemon region: ");
        String region = scanner.next();
        if (region.equals("x"))
            return;
        System.out.print("\nEnter Pokemon type 1: ");
        String type1 = scanner.next();
        if (type1.equals("x"))
            return;
        System.out.print("\nEnter Pokemon type 2 (enter 'None' if you do not want a second type): ");
        String type2 = scanner.next();
        if (type2.equals("x"))
            return;
        else if (type2.equals("None"))
            type2 = null;

        // use pokemon constructor to create pokemon out of given attributes:
        Pokemon pokemon = new Pokemon(idOfNewPokemon, name, Integer.parseInt(attack), Integer.parseInt(defense),
                Integer.parseInt(HP), Integer.parseInt(speed), region, new String[] {type1, type2});
        // add pokemon to RBT using backend reference:
        backend.addPokemon(pokemon);
        // change ID for next added pokemon:
        idOfNewPokemon++;
    }

    /**
     * The program enters search mode when 's' is entered. Here, the user is able to search for Pokemon using
     * various criteria. For each search filter, there is a "sub-mode". The user uses 'c', 'r', 't', and 'g'
     * to enter the different sub-modes. If the user enters CP search mode (c), they can search the Backend/RBT for
     * a specific CP for Pokemon. If the user enters Region search mode (r), they can search for a specific region
     * and have all the pokemon from that region displayed. If the user enters Type search mode (t), all pokemon that
     * are of the provided type are returned and displayed as a list. If the user enters CP Range Search Mode (g),
     * all Pokemon in the provided bounds for CP are displayed as a list. Finally, the user may enter 'x' within
     * the sub-modes to return to the original search mode or 'x' in search mode to return to the main screen.
     *
     * @param backend the backend object is used to access the search results of searching various pokemon with
     *                different filters
     */
    public void searchMode(BackendInterface backend) {
        while (true) {
            // while loop runs so that search mode is only exited using 'x'
            System.out.println("\nSearch Mode");
            System.out.println("-----------");
            System.out.println("You will be able to search for Pokemon using one of the following attributes:");
            System.out.println("\t1) Enter 'c' to search by CP");
            System.out.println("\t2) Enter 'r' to search by region");
            System.out.println("\t3) Enter 't' to search by type");
            System.out.println("\t4) Enter 'g' to search by a range of CP values");
            System.out.println("\t5) Enter 'x' to return to the main screen");
            System.out.println();

            String command = scanner.next();
            if (command.equals("x"))
                return;
            else if (command.equals("c")) {
                System.out.print("\nEnter the CP you are searching for (or 'x' to go back to search mode): ");
                String cp = scanner.next();
                if (cp.equals("x"))
                    continue;
                Pokemon pokemon = backend.findPokemonCP(Integer.parseInt(cp));
                if (pokemon != null)
                    System.out.println(pokemon);
                else
                    System.out.println("No Pokemon were found with this CP!"); // in case pokemon is null (no CP values are close), tell user
            }
            else if (command.equals("r")) {
                System.out.print("\nEnter the region you are searching for (or 'x' to go back to search mode): ");
                String region = scanner.next();
                if (region.equals("x"))
                    continue;
                List<Pokemon> pokemon = backend.getPokemonRegion(region);
                displayPokemon(pokemon);
            }
            else if (command.equals("t")) {
                System.out.print("\nEnter the type of the Pokemon you are searching for " +
                        "(or 'x' to go back to search mode): ");
                String type = scanner.next();
                if (type.equals("x"))
                    continue;
                List<Pokemon> pokemon = backend.getPokemonType(type);
                displayPokemon(pokemon);
            }
            else if (command.equals("g")) {
                // cpl: CP lower bound, cpu: CP upper bound
                System.out.print("\nEnter the lower bound of the range of CP of the Pokemon you are searching for " +
                        "(or 'x' to go back to search mode): ");
                String cpl = scanner.next();
                if (cpl.equals("x"))
                    continue;
                System.out.print("\nEnter the upper bound of the range of CP of the Pokemon you are searching for " +
                        "(or 'x' to go back to search mode): ");
                String cpu = scanner.next();
                if (cpu.equals("x"))
                    continue;
                List<Pokemon> pokemon = backend.getPokemonCPRange(Integer.parseInt(cpl), Integer.parseInt(cpu));
                displayPokemon(pokemon);
            }
            else
                System.out.println("Enter a valid command!");
        }
    }

    /**
     * This method is used to display a list of pokemon in a visually pleasing manner
     *
     * @param pokemon the list of pokemon that are to be displayed as search results
     */
    public void displayPokemon(List<Pokemon> pokemon) {
        System.out.println("----------------------------------");
        System.out.println("Pokemon matching search results:");
        String builder;
        // iterate through the pokemon in the list (based on whatever parameter) and print info
        for (Pokemon p : pokemon) {
            builder = "ID#"+p.getID() + "\t" + p.getName();
            builder = builder + "\n\tCP:\t"+ p.getCP();
            builder = builder + "\n\tRegion: " + p.getRegion();
            builder = builder + "\n\tType(s): " + p.getTypes()[0];
            if (p.getTypes()[1] != null) // if the second type exists, add it to the output
                builder = builder + "\t" + p.getTypes()[1];
            System.out.println(builder);
            System.out.println();
        }
        System.out.println("---------------------------------");
    }

    /**
     * After the program has finished executing (x is entered from the main screen), the
     * program will call this method to display the thank you message and end the program.
     */
    public void endScreen() {
        System.out.println("\nThank you for using Pokemon Catalog!");
    }
}
