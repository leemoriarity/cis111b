public class HourlyEmployee extends Employee implements Taxable, Payable {

    protected double totalHours;
    protected double payRate;
    protected double regPay;
    protected double overtimeHours;
    protected double overtimeRate;
    protected double overtimePay;
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

        if (totalHours > 40) {
            overtimeHours = totalHours - 40;
            this.totalHours = 40;
            overtimeRate = (payRate * 1.5);
            overtimePay = overtimeHours * overtimeRate;
        }
        regPay = totalHours * payRate;
    }

    //Getters
    public double getTotalHours() {
        return totalHours;
    }
    public double getPayRate() {  return payRate; }

    /**
     * @return Earnings Statement
     */
    public String toString() {
        String output;
        if (totalHours > 40) {
            output = super.toString() +
                    "Earnings           Rate Hours/units         Amount" + "\n" +
                    "------------------------------------------------------" + "\n" +
                    "RegHrs" + "             " + payRate + "  " + totalHours + "               " + regPay + "\n" +
                    "OT 1.5" + "             " + overtimeRate + "  " + overtimeHours + "                " + overtimePay+ "\n";
        } else {
            output = super.toString() +
                    "Earnings           Rate Hours/units         Amount" + "\n" +
                    "------------------------------------------------------" + "\n" +
                    "RegHrs" + "             " + payRate + "  " + totalHours + "               " + regPay + "\n";
        }
        if (bonus == false)
            output += "------------------------------------------------------" + "\n" +
                    "Gross Pay:" + "                                  " + getGrossAmount() + "\n" +
                    "Tax Withheld:" + "                               " + getTaxWithheld() + "\n" +
                    "Net Pay:" + "                                    " + getPayAmount() + "\n";
        return output;
    }

    @Override
    public double getGrossAmount() {
        return regPay + overtimePay;
    }

    @Override
    public double getTaxWithheld() {
        return getGrossAmount() * TAX_PERCENT;
    }

    @Override
    public double getPayAmount() {
        return getGrossAmount() * (1 - TAX_PERCENT);
    }
}
