public class BasePlusCommissionEmployee extends CommissionEmployee implements Taxable, Payable {

    private double basePay;

    public BasePlusCommissionEmployee(int employeeID, String firstName, String lastName, String paySchedule, double totalSales, double commissionPercent, double basePay) {
        super(employeeID, firstName, lastName, paySchedule, totalSales, commissionPercent);
        this.basePay = basePay;
    }

    public double getBasePay() {
        return basePay;
    }

    /**
     * @return Earning Statement
     */
    public String toString() {
        base = true;
        return super.toString() +
                "Base Pay" + "                                    " + getBasePay() + "\n" +
                "------------------------------------------------------" + "\n" +
                "Gross Pay:" + "                                  " + getGrossAmount() + "\n" +
                "Tax Withheld:" + "                               " + getTaxWithheld() + "\n" +
                "Net Pay:" + "                                    " + getPayAmount() + "\n";
    }

    @Override
    public double getGrossAmount() {
        return commissionTotal + basePay;
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

