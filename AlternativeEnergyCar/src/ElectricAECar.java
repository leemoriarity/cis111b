public abstract class ElectricAECar extends AlternativeEnergyCar {

    private String battery;
    private double electricRange;

    public ElectricAECar() { super(); }

    public ElectricAECar(int year, String make, String model, double MSRP, String style, String drivetrain, int hp, int topSpeed, String battery, double electricRange) {
        super(year, make, model, MSRP, style, drivetrain, hp, topSpeed);
        this.battery = battery;
        this.electricRange = electricRange;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Battery: " + battery + "\n" +
                "Electric Range: " + electricRange + " miles" + "\n";

    }
}