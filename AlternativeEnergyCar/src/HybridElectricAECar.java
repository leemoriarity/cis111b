public class HybridElectricAECar extends ElectricAECar {

    private double range;
    private int mpg;
    private String engine;
    private String fuel;
    private double fuelCapacity;

    public HybridElectricAECar() { super(); }

    public HybridElectricAECar(int year, String make, String model, double MSRP, String style, String drivetrain, int hp, int topSpeed, String battery, double electricRange, double range, int mpg, String engine, String fuel, double fuelCapacity) {
        super(year, make, model, MSRP, style, drivetrain, hp, topSpeed, battery, electricRange);
        this.range = range;
        this.mpg = mpg;
        this.engine = engine;
        this.fuel = fuel;
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Range: " + range + " miles\n" +
                "MPG: " + mpg + " combined city/highway\n" +
                "Engine: " + engine + "\n" +
                "Fuel: " + fuel + "\n" +
                "Fuel capacity: " + fuelCapacity + " gallons\n";
    }
}