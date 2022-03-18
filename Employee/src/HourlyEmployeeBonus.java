public class HourlyEmployeeBonus extends HourlyEmployee {

    protected double bonusRate;
    protected double bonusHours;
    protected double bonusPay;

    public HourlyEmployeeBonus() { super(); }
    /**
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param paySchedule
     * @param totalHours
     * @param payRate
     * @param bonusRate
     */
    public HourlyEmployeeBonus(int employeeID, String firstName, String lastName, String paySchedule, double totalHours, double payRate, double bonusRate) {
        super(employeeID, firstName, lastName, paySchedule, totalHours, payRate);
        this.bonusRate = bonusRate;
        this.bonusHours = (overtimeHours + getTotalHours());
        this.bonusPay = bonusHours * bonusRate;
    }

    /**
     * @return Gross Pay
     */
    public double calculateGrossPay() {
        double gross = super.calculateGrossPay();
        bonusPay = (overtimeHours + getTotalHours()) * bonusRate;
        return (gross + bonusPay + overtimePay);
    }

    /**
     * @return Earnings Statement
     */
    public String toString() {
        bonus = true;
            return super.toString() +
                    "Bonus" + "               " + bonusRate + "  " + bonusHours + "               " + bonusPay + "\n" +
                    "------------------------------------------------------" + "\n" +
                    "Gross Pay:" + "                                  " + calculateGrossPay() + "\n";
    }
}
