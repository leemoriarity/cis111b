public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double basePay;

    public BasePlusCommissionEmployee(int employeeID, String firstName, String lastName, String paySchedule, double totalSales, double commissionPercent, double basePay) {
        super(employeeID, firstName, lastName, paySchedule, totalSales, commissionPercent);
        this.basePay = basePay;
    }

    public double getBasePay() {
        return basePay;
    }

    /**
     * @return Gross Pay
     */
    @Override
    public double calculateGrossPay() {
        return commissionTotal + basePay;
    }

    /**
     * @return Earning Statement
     */
    public String toString() {
        base = true;
        return super.toString() +
                "Base Pay" + "                                    " + getBasePay() + "\n" +
                "------------------------------------------------------" + "\n" +
                "Gross Pay:" + "                                  " + calculateGrossPay() + "\n";
    }
}

