public class PTO extends Hourly {

    private double ptoHours;
    private double ptoPay;

    public PTO() {
        super();
    }
    /**
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param paySchedule
     * @param totalHours
     * @param payRate
     * @param ptoHours
     */
    public PTO(int employeeID, String firstName, String lastName, String paySchedule, double totalHours, double payRate, double ptoHours) {
        super(employeeID, firstName, lastName, paySchedule, totalHours, payRate);
        this.ptoHours = ptoHours;
    }

    /**
     * @return Gross Pay
     */
    @Override
    public double calculateGrossPay() {
        ptoPay = (ptoHours * payRate);
        return super.calculateGrossPay() + ptoPay;
    }
    /**
     * @return Earnings Statement
     */
    public String toString() {
        extra = true;
        return super.toString() +
                "PTO" + "                " + getPayRate() + "  " + ptoHours + "               " + ptoPay + "\n" +
                "------------------------------------------------------" + "\n" +
                "Gross Pay:" + "                                  " + this.calculateGrossPay() + "\n";
    }
}
