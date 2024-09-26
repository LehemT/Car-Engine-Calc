/**
 * Main class is the main interface of this program. It creates a list of CarEngine objects,
 * each representing an engine with unique specifications, calculates and prints details
 * such as torque, speed, displacement, and horsepower of each engine.
 *
 * @author Lehem Temesgen
 * @version 07/31/2024
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // creating an ArrayList of CarEngine objects
        ArrayList<CarEngine> engineList = new ArrayList<>();

        // adding 5 CarEngine instances to the arraylist using the different limits
        engineList.add(new CarEngine("Engine00", -100, -500, -80, -90, -1));
        engineList.add(new CarEngine("Engine15", 100, 500, 80, 90, 1));
        engineList.add(new CarEngine("Engine26", 200, 600, 90, 95, 5));
        engineList.add(new CarEngine("Engine37", 300, 700, 100, 100, 8));
        engineList.add(new CarEngine("Engine48", 400, 800, 120, 120, 10));

        printEngineDetails(engineList);
    }

    /**
     * Prints the details of each engine in an array list.
     * @param engines
     */
    public static void printEngineDetails(ArrayList<CarEngine> engines) {
        for (CarEngine engine : engines) {
            System.out.println("Company Name: " + engine.getCompanyName());
            System.out.println("Torque: " + engine.getTorque() + " lb-ft");
            System.out.println("Speed: " + engine.getSpeed() + " RPM");
            System.out.println("Cylinder Bore: " + engine.getBoreSize() + " mm");
            System.out.println("Crankshaft Stroke: " + engine.getStroke() + " mm");
            System.out.println("Number of Cylinders: " + engine.getNumCylinders());
            System.out.println("Engine Displacement: " + engine.getEngineDisplacement() + " cc");
            System.out.println("Horsepower: " + engine.getHorsePower() + " HP");
            System.out.println();
        }
    }
}