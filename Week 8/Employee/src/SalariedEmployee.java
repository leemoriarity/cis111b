public class SalariedEmployee extends Employee implements Taxable, Payable {

    private double salaryPay;

    public SalariedEmployee() {
        super();
    }

    /**
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param paySchedule
     * @param salaryPay
     */
    public SalariedEmployee(int employeeID, String firstName, String lastName, String paySchedule, double salaryPay) {
        super(employeeID, firstName, lastName, paySchedule);
        this.salaryPay = salaryPay;
    }
    public double getSalaryPay() {
        return salaryPay;
    }

    /**
     * @return Earnings Statement
     */
    public String toString() {
        return  super.toString() +
                "Earnings                  Amount" + "\n" +
                "----------------------------------" + "\n" +
                "Salary" + "                    " + getSalaryPay() + "\n" +
                "----------------------------------" + "\n" +
                "Gross Pay:" + "                " + getGrossAmount() + "\n" +
                "Tax Withheld:" + "             " + getTaxWithheld() + "\n" +
                "Net Pay:" + "                  " + getPayAmount() + "\n";

    }

    @Override
    public double getGrossAmount() {
        return salaryPay;
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
