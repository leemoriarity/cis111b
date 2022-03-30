public class BatteryElectricAECar extends ElectricAECar {

        private double MPGe;
        private String charger;

        public BatteryElectricAECar() { super(); }

        public BatteryElectricAECar(int year, String make, String model, double MSRP, String style, String drivetrain, int hp, int topSpeed, String battery, double electricRange, int MPGe, String charger){
            super(year, make, model, MSRP, style, drivetrain, hp, topSpeed, battery, electricRange);
            this.MPGe = MPGe;
            this.charger = charger;
        }

    @Override
    public String toString() {
        return super.toString() +
                "MPGe: " + MPGe + " combined city/highway" + "\n" +
                "Charger: " + charger;
    }
}
