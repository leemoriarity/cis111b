public class EthanolFuelAECar extends FuelAECar {

    private double mpg;
    private double fuelCapacity;

    public EthanolFuelAECar() { super(); }

    public EthanolFuelAECar(int year, String make, String model, double MSRP, String style, String drivetrain, int hp, int topSpeed, double range, String engine, String fuel, double fuelCapacity, double mpg) {
        super(year, make, model, MSRP, style, drivetrain, hp, topSpeed, range, engine, fuel);
        this.mpg = mpg;
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Fuel Capacity: " + fuelCapacity + " gal" + "\n" +
                "MPG: " + mpg + " combined city/highway" + "\n";
    }
}