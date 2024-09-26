/**
 * This class contains unit tests for the CarEngine class to verify that all engine
 * attributes, calculations, and methods function as expected. It tests the
 * default constructor, overloaded constructor, and setter methods.
 *
 * @author Lehem Temesgen
 * @version 07/31/2024
 */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarEngineTest {
    private static CarEngine defaultEngine;
    private static CarEngine overloadEngine;

    /**
     * Initializes CarEngine instances before all the tests.
     */
    @BeforeAll
    public static void init() {
        System.out.println("Starting CarEngine tests...");
        // initialize engine before each test using the default constructor
        defaultEngine = new CarEngine();
        // initialize engine before each test using the overload constructor
        overloadEngine = new CarEngine("OgCompany", 100, 500, 80, 90, 1);
    }

    /**
     * Notifies that all the tests have been completed.
     */
    @AfterAll
    public static void tearDown() {
        System.out.println("CarEngine tests completed.");
    }

    /**
     * Tests the default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals("Unknown", defaultEngine.getCompanyName());
        assertEquals(0, defaultEngine.getTorque());
        assertEquals(0, defaultEngine.getSpeed());
        assertEquals(0, defaultEngine.getBoreSize());
        assertEquals(0, defaultEngine.getStroke());
        assertEquals(0, defaultEngine.getNumCylinders());
    }

    /**
     * Tests the overload constructor
     */
    @Test
    public void testOverloadedConstructor() {
        assertEquals("OgCompany", overloadEngine.getCompanyName());
        assertEquals(100, overloadEngine.getTorque());
        assertEquals(500, overloadEngine.getSpeed());
        assertEquals(80, overloadEngine.getBoreSize());
        assertEquals(90, overloadEngine.getStroke());
        assertEquals(1, overloadEngine.getNumCylinders());
    }

    /**
     * Tests the setCompanyName method.
     */
    @Test
    public void testSetCompanyName() {
        overloadEngine.setCompanyName(null);
        assertEquals("Unknown", overloadEngine.getCompanyName());

        overloadEngine.setCompanyName("NewCompany");
        assertEquals("NewCompany", overloadEngine.getCompanyName());
    }

    /**
     * Tests the setNumCylinders method.
     */
    @Test
    public void testSetNumCylinders() {
        overloadEngine.setNumCylinders(-1);
        assertEquals(0, overloadEngine.getNumCylinders());

        overloadEngine.setNumCylinders(10);
        assertEquals(8, overloadEngine.getNumCylinders());

        overloadEngine.setNumCylinders(5);
        assertEquals(5, overloadEngine.getNumCylinders());
    }

    /**
     * Tests the setBoreSize method.
     */
    @Test
    public void testSetBoreSize() {
        overloadEngine.setBoreSize(50);
        assertEquals(50, overloadEngine.getBoreSize());

        overloadEngine.setBoreSize(120);
        assertEquals(100, overloadEngine.getBoreSize());

        overloadEngine.setBoreSize(-1);
        assertEquals(0, overloadEngine.getBoreSize());
    }

    /**
     * Tests the setEngineDisplacement method.
     */
    @Test
    public void testSetEngineDisplacement() {
        overloadEngine.setEngineDisplacement();
        assertEquals(452.389342f, overloadEngine.getEngineDisplacement());
    }

    /**
     * Tests the setHorsePower method.
     */
    @Test
    public void testSetHorsePower() {
        overloadEngine.setHorsePower(false);
        assertEquals(9.520183f , overloadEngine.getHorsePower());

        overloadEngine.setHorsePower(true);
        assertEquals(30.1592895f, overloadEngine.getHorsePower());
    }
}
