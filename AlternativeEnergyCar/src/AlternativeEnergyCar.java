
public class AlternativeEnergyCar implements Comparable<AlternativeEnergyCar> {

    private int year;
    private String make;
    private String model;
    private double MSRP;
    private String bodyStyle;
    private String drivetrain;
    private int hp;
    private int topSpeed;

    public AlternativeEnergyCar() {
        this.year = 2022;
        this.make = "Tesla";
        this.model = "Model S Plaid";
        this.MSRP = 135990;
        this.bodyStyle = "Sedan";
        this.drivetrain = "AWD";
        this.hp = 1020;
        this.topSpeed = 200;
    }

    public AlternativeEnergyCar(int year, String make, String model, double MSRP, String bodyStyle, String drivetrain, int hp, int topSpeed) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.MSRP = MSRP;
        this.bodyStyle = bodyStyle;
        this.drivetrain = drivetrain;
        this.hp = hp;
        this.topSpeed = topSpeed;
    }

    //Setters
    public void setYear(int year) { this.year = year; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setMSRP(double MSRP) { this.MSRP = MSRP; }
    public void setBodyStyle(String bodyStyle) { this.bodyStyle = bodyStyle; }
    public void setDrivetrain(String drivetrain) { this.drivetrain = drivetrain; }
    public void setHp(int hp) { this.hp = hp; }
    public void setTopSpeed(int topSpeed) { this.topSpeed = topSpeed; }

    //Getters
    public int getYear() { return year; }
    public String getMake() {return make;}
    public String getModel() {return model;}
    public double getMSRP() {return MSRP; }
    public String getBodyStyle() {return bodyStyle;}
    public String getDrivetrain() {return drivetrain;}
    public int getHp() { return hp; }
    public int getTopSpeed() { return topSpeed; }

    //Controls
    public void accelerate() {}
    public void brake() {}
    public void reverse() {}
    public void cruiseControl() {}
    public void turnLeft() {}
    public void turnRight() {}
    public void autoPilot() {}

    @Override
    public String toString() {
        return  "Model: " + getYear() + " " + getMake() + " " + getModel() + "\n" +
                "MSRP: $" + getMSRP() + "\n" +
                "Body Style: " + getBodyStyle() + "\n" +
                "Drivetrain: " + getDrivetrain() + "\n" +
                "Horsepower: " + getHp() + " hp" + "\n" +
                "Top speed: " + getTopSpeed() + " mph" + "\n";
    }

    @Override
    public int compareTo(AlternativeEnergyCar car) {
        if (this.MSRP > car.getMSRP()) // if this price is greater than compared price
            return 1; // return 1
        else if (this.MSRP < car.getMSRP()) // if this price is less than compared price
            return -1; // return -1
        else return 0; // if price is equal return 0
    }
}