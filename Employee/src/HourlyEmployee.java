public class HourlyEmployee extends Employee {

    protected double totalHours;
    protected double payRate;
    protected double overtimeHours;
    protected double overtimeRate;
    protected double overtimePay;
    protected double grossPay;
    protected double adjustedGrossPay;
    protected boolean bonus = false;

    public HourlyEmployee() {
        super();
    }

    /**
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param paySchedule
     * @param totalHours
     * @param payRate
     */
    public HourlyEmployee(int employeeID, String firstName, String lastName, String paySchedule, double totalHours, double payRate) {
        super(employeeID, firstName, lastName, paySchedule);
        this.totalHours = totalHours;
        this.payRate = payRate;
    }

    //Getters
    public double getTotalHours() {
        return totalHours;
    }
    public double getPayRate() {  return payRate; }

    /**
     * @return Gross Pay
     */
    @Override
    public double calculateGrossPay() {
        if (totalHours > 40) {
            overtimeHours = totalHours - 40;
            totalHours = 40;
            overtimeRate = (payRate * 1.5);
            overtimePay = overtimeHours * overtimeRate;
        }
        grossPay = totalHours * payRate;
        adjustedGrossPay = grossPay + overtimePay;
        return grossPay;
    }

    /**
     * @return Earnings Statement
     */
    public String toString() {
        String output;
        if (totalHours > 40) {
            calculateGrossPay();
            output = super.toString() +
                    "Earnings           Rate Hours/units         Amount" + "\n" +
                    "------------------------------------------------------" + "\n" +
                    "RegHrs" + "             " + payRate + "  " + totalHours + "               " + grossPay + "\n" +
                    "OT 1.5" + "             " + overtimeRate + "  " + overtimeHours + "                " + overtimePay+ "\n";
        } else {
            calculateGrossPay();
            output = super.toString() +
                    "Earnings           Rate Hours/units         Amount" + "\n" +
                    "------------------------------------------------------" + "\n" +
                    "RegHrs" + "             " + payRate + "  " + totalHours + "               " + grossPay + "\n";
        }
        if (bonus == false)
            output += "------------------------------------------------------" + "\n" +
                    "Gross Pay:" + "                                  " + adjustedGrossPay + "\n";
        return output;
    }
}
