public class HydrogenFuelAECar extends FuelAECar {

    private double MPGe;
    private double fuelCapacity;
    private String battery;

    public HydrogenFuelAECar() { super(); }

    public HydrogenFuelAECar(int year, String make, String model, double MSRP, String style, String drivetrain, int hp, int topSpeed, double range, String engine, String fuel, double fuelCapacity, double MPGe, String battery) {
        super(year, make, model, MSRP, style, drivetrain, hp, topSpeed, range, engine, fuel);
        this.fuelCapacity = fuelCapacity;
        this.battery = battery;
        this.MPGe = MPGe;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Fuel Capacity: " + fuelCapacity + "kg" + "\n" +
                "MPGe: " + MPGe + " combined city/highway" + "\n" +
                "Battery: " + battery + "\n";
    }
}