public class Commission extends Employee {

    private double totalSales;
    private double commissionPercent;

    public Commission() {
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
    public Commission(int employeeID, String firstName, String lastName, String paySchedule, double totalSales, double commissionPercent) {
        super(employeeID, firstName, lastName, paySchedule);
        this.totalSales = totalSales;
        this.commissionPercent = commissionPercent;
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
        return totalSales * commissionPercent;
    }

    /**
     * @return Earnings Statement
     */
    public String toString() {
        return  super.toString() +
                "Earnings           Rate/Total Sales         Amount" + "\n" +
                "------------------------------------------------------" + "\n" +
                "Commission" + "         " + getCommissionPercent() + "  " + getTotalSales() + "            " + calculateGrossPay() + "\n" +
                "------------------------------------------------------" + "\n" +
                "Gross Pay:" + "                                  " + calculateGrossPay() + "\n";
    }
}

