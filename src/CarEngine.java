/**
 * CarEngine class represents a car engine, and it's important parameters such as torque, speed, bore size, stroke,
 * and number of cylinders. The engine's power is also calculates in horsepower (HP) based on torque or displacement.
 *
 * @author Lehem Temesgen
 * @version 07/31/2024
 */

public class CarEngine
{
    private static final int CC_FROM_HP = 15;
    private static final int RADIANS_PER_SECOND = 5252;
    private float engineDisplacement;
    private float horsePower;
    private int numCylinders;
    private int stroke;    // in mm
    private int boreSize;    // in mm
    private int speed;    // in RPM
    private int torque;    // in lb-ft
    private String companyName;

    /**
     * Default constructor that initializes the attributes to default values.
     */
    public CarEngine(){
        engineDisplacement = 0;
        horsePower = 0;
        numCylinders = 0;
        stroke = 0;
        boreSize = 0;
        speed = 0;
        torque = 0;
        companyName = "Unknown";
    }

    /**
     * Overload constructor that initializes the attributes to given values.
     */
    public CarEngine(String companyName, int torque, int speed, int boreSize, int stroke, int numCylinders) {
        // ternary operator to set the company's name
        this.companyName = (companyName != null) ? companyName : "Unknown";

        // initialize remaining numerical variables depending on their limits
        this.torque = Math.max(torque, 0);
        this.speed = Math.max(speed, 0);
        this.boreSize = (boreSize < 0) ? 0 : Math.min(boreSize, 100);
        this.stroke = (stroke < 0) ? 0 : Math.min(stroke, 100);
        this.numCylinders = (numCylinders < 0) ? 0 : Math.min(numCylinders, 8);

        // calculate engine displacement in cc using πr^2 x stroke x number of cylinders
        // stroke & boreSize are converted from mm to cm in the calculation, boreSize is also divided by 2 for radius
        engineDisplacement = (float) (Math.PI * Math.pow(this.boreSize/10.0/2.0, 2) * (this.stroke/10.0) * this.numCylinders);

        // calculate horse power using torque x (RPM / 5252)
        if (speed != 0 && torque != 0) {
            this.horsePower = this.torque * (this.speed / (float) RADIANS_PER_SECOND);
        } else {
            // calculate horsepower using engine displacement / 15
            this.horsePower = engineDisplacement / CC_FROM_HP;
        }
    }

    /**
     * Calculates the horsepower of an engine using torque.
     * @return the horsepower calculated from torque
     */
    private float calculateHorsePowerFromTorque(){
        return torque * (speed / (float) RADIANS_PER_SECOND);
    }

    /**
     * Calculates an engine's displacement.
     * @return the engine's displacement
     */
    private float calculateEngineDisplacement(){
        return (float) (Math.PI * Math.pow(boreSize/10.0/2.0, 2) * (stroke/10.0) * numCylinders);
    }

    /**
     * Calculates the horsepower of an engine using displacement.
     * @return the horsepower calculated from torque
     */
    private float calculateHorsePowerFromDisplacement(){
        return engineDisplacement / CC_FROM_HP;
    }

    /**
     * Sets the engine company's name.
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = (companyName != null) ? companyName : "Unknown";
    }

    /**
     * Gets the engine's company's name.
     * @return company's name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the engine's displacement.
     */
    public void setEngineDisplacement() {
        this.engineDisplacement = calculateEngineDisplacement();
    }

    /**
     * Gets the engine's displacement.
     * @return displacement
     */
    public float getEngineDisplacement() {
        return engineDisplacement;
    }

    /**
     * Sets the engine's horsepower.
     * @param source
     */
    public void setHorsePower(boolean source) {
        if (source){
            this.horsePower = calculateHorsePowerFromDisplacement();
        } else {
            this.horsePower = calculateHorsePowerFromTorque();
        }
    }

    /**
     * Gets the engine's horsepower.
     * @return horsepower
     */
    public float getHorsePower() {
        return horsePower;
    }

    /**
     * Sets the engine's torque.
     * @param torque
     */
    public void setTorque(int torque) {
        this.torque = Math.max(torque, 0);
    }

    /**
     * Gets the engine's torque.
     * @return torque
     */
    public int getTorque() {
        return torque;
    }

    /**
     * Sets the engine's bore diameter.
     * @param boreSize
     */
    public void setBoreSize(int boreSize) {
        this.boreSize = (boreSize < 0) ? 0 : Math.min(boreSize, 100);
    }

    /**
     * Gets the engine's bore diameter.
     * @return bore size
     */
    public int getBoreSize() {
        return boreSize;
    }

    /**
     * Sets the engine's crankshaft stroke.
     * @param stroke
     */
    public void setStroke(int stroke) {
        this.stroke = (stroke < 0) ? 0 : Math.min(stroke, 100);
    }

    /**
     * Gets the engine's rankshaft stroke.
     * @return stroke
     */
    public int getStroke() {
        return stroke;
    }

    /**
     * Sets the engine's speed.
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = Math.max(0, speed);
    }

    /**
     * Gets the engine's speed.
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the engine's number of cylinders.
     * @param numCylinders
     */
    public void setNumCylinders(int numCylinders) {
        this.numCylinders = (numCylinders < 0) ? 0 : Math.min(numCylinders, 8);
    }

    /**
     * Gets the engine's number of cylinders.
     * @return number of cylinders
     */
    public int getNumCylinders() {
        return numCylinders;
    }
}
