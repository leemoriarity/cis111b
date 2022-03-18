public class CommissionEmployee extends Employee {

    protected double totalSales;
    protected double commissionPercent;
    protected double commissionTotal;
    protected boolean base = false;

    public CommissionEmployee() {
        super();
    }

    /**
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param paySchedule
     * @param totalSales
     * @param commissionPercent
     */
    public CommissionEmployee(int employeeID, String firstName, String lastName, String paySchedule, double totalSales, double commissionPercent) {
        super(employeeID, firstName, lastName, paySchedule);
        this.totalSales = totalSales;
        this.commissionPercent = commissionPercent;
        this.commissionTotal = totalSales * commissionPercent;
    }

    //Getters
    public double getTotalSales() {
        return totalSales;
    }
    public String getCommissionPercent() { return commissionPercent * 100 + "%"; }

    /**
     * @return Gross Pay
     */
    @Override
    public double calculateGrossPay() {
        return commissionTotal;
    }

    /**
     * @return Earnings Statement
     */
    public String toString() {
        String output = super.toString() +
                "Earnings           Rate/Total Sales         Amount" + "\n" +
                "------------------------------------------------------" + "\n" +
                "Commission" + "         " + getCommissionPercent() + "  " + getTotalSales() + "            " + commissionTotal + "\n";
                if (base == false) {
                    output += "------------------------------------------------------" + "\n" +
                            "Gross Pay:" + "                                  " + this.calculateGrossPay() + "\n";
                }
                return output;
    }
}

