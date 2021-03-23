// --== CS400 File Header Information ==--
// Name: Rohan Putcha
// Email: rputcha@wisc.edu
// Team: JC red
// Role: Frontend Developer
// TA: Xinyi Liu
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.fail;



/**
 * This class contains a set of tests for the front end of the Pokemon Catalog project.
 */
public class FrontEndDeveloperTests {
    /**
     * Ensures that the input and output is reset to the original sources before running
     * each test method.
     */
    @BeforeEach
    public void setUpInputOutput() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    /**
     * This method tests instantiation of the frontend object. If the frontend object is
     * null or throws an exception while being created, the test will fail with the appropriate
     * message.
     */
    @Test
    public void testFrontendInstantiation() {
        try {
            Frontend frontend = new Frontend();
            if (frontend == null)
                fail("FAILED: Frontend was not instantiated!");
        } catch (Exception e) {
            fail("FAILED: Instantiation failed!");
        }
    }

    /**
     * This method tests 'a' as input into the front end to ensure the functionality
     * of character commands in the command line. It makes sure that input 'a' is
     * accepted by the Frontend java file and relayed to the backend without any
     * exceptions thrown by the program. It also ensures that 'a' on the home screen
     * will move the program into add mode.
     */
    @Test
    public void testAInput() {
        // a will enter add mode, x will go back to menu screen, x again will end the program
        String testInput = "a" + System.lineSeparator() + "x" + System.lineSeparator() + "x";
        // sends testInput to InputStream
        InputStream inputStream= new ByteArrayInputStream(testInput.getBytes());
        // uses InputStream to set input for the program
        System.setIn(inputStream);
        // changes primary input back to keyboard
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            Frontend frontend = new Frontend();
            frontend.run(new Backend(frontend.inputFile));
            String appOutput = outputStream.toString();
            System.setOut(System.out); // return output to console to see errors/success
            if (!appOutput.contains("Add Mode"))
                fail("FAILED: When 'a' is entered, program must change to be in 'add mode'");
        } catch (Exception e) {
            fail("FAILED: Instantiation failed!");
        }
    }

    /**
     * This method tests 'x' as input into the front end to ensure the functionality
     * of character commands in the command line. It makes sure that input 'x' is
     * accepted by the Frontend java file and relayed to the backend without any
     * exceptions thrown by the program. It also ensures that 'x' on the home screen
     * will exit the program with a thank you message.
     */
    @Test
    public void testXInput() {

        String testInput = "x";
        // sends testInput to InputStream
        InputStream inputStream= new ByteArrayInputStream(testInput.getBytes());
        // uses InputStream to set input for the program
        System.setIn(inputStream);
        // changes primary input back to keyboard
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            Frontend frontend = new Frontend();
            frontend.run(new Backend(frontend.inputFile));
            String appOutput = outputStream.toString();
            System.setOut(System.out); // return output to console to see errors/success
            if (!appOutput.contains("Thank you"))
                fail("FAILED: When 'x' is entered, program must have exit message");
        } catch (Exception e) {
            fail("FAILED: Instantiation failed!");
        }
    }

    /**
     * This method tests 's' as input into the front end to ensure the functionality
     * of character commands in the command line. It makes sure that input 's' is
     * accepted by the Frontend java file and relayed to the backend without any
     * exceptions thrown by the program. It also ensures that 's' on the home screen
     * will move the program into search mode.
     */
    @Test
    public void testSInput() {
        // s will enter search mode, x will go back to menu screen, x again will end the program
        String testInput = "s" + System.lineSeparator() + "x" + System.lineSeparator() + "x";
        // sends testInput to InputStream
        InputStream inputStream= new ByteArrayInputStream(testInput.getBytes());
        // uses InputStream to set input for the program
        System.setIn(inputStream);
        // changes primary input back to keyboard
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            Frontend frontend = new Frontend();
            frontend.run(new Backend(frontend.inputFile));
            String appOutput = outputStream.toString();
            System.setOut(System.out); // return output to console to see errors/success
            if (!appOutput.contains("Search Mode"))
                fail("FAILED: When 's' is entered, program must enter 'search mode'");
        } catch (Exception e) {
            fail("FAILED: Instantiation failed!");
        }
    }

    /**
     * This method tests input into the front end to ensure the functionality
     * of character commands in the command line. It makes sure that inputs 's'
     * and 'a' work as intended without throwing exceptions. It mainly makes sure
     * that using 'x' to go back to the main screen works from both modes
     */
    @Test
    public void testXToGoBackFromModes() {
        // 'a' will enter add mode, x will go back to menu screen
        String testInput = "a" + System.lineSeparator() + "x";
        // 's' will enter search mode, x will go back to menu screen
        testInput = testInput + System.lineSeparator() + "s" + System.lineSeparator() + "x";
        // enter 'x' one last time to exit menu screen
        testInput = testInput + System.lineSeparator() + "x";
        // sends testInput to InputStream
        InputStream inputStream= new ByteArrayInputStream(testInput.getBytes());
        // uses InputStream to set input for the program
        System.setIn(inputStream);
        // changes primary input back to keyboard
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        try {
            Frontend frontend = new Frontend();
            frontend.run(new Backend(frontend.inputFile));
            String appOutput = outputStream.toString();
            System.setOut(System.out); // return output to console to see errors/success
            if (!appOutput.contains("Thank you"))
                fail("FAILED: Opening different modes failed or exit message not found");
        } catch (Exception e) {
            fail("FAILED: Instantiation failed or opening/going back from different modes failed.");
        }
    }
}

