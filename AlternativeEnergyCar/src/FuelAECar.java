public abstract class FuelAECar extends AlternativeEnergyCar {

    private double range;
    private String engine;
    private String fuel;

    public FuelAECar() { super(); }

    public FuelAECar(int year, String make, String model, double MSRP, String style, String drivetrain, int hp, int topSpeed, double range, String engine, String fuel) {
        super(year, make, model, MSRP, style, drivetrain, hp, topSpeed);
        this.range = range;
        this.engine = engine;
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Range: " + range + " miles" + "\n" +
                "Engine: " + engine + "\n" +
                "Fuel: " + fuel + "\n";
    }
}