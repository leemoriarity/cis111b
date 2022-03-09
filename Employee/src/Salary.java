public class Salary extends Employee {

    private double salaryPay;

    public Salary() {
        super();
    }

    /**
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param paySchedule
     * @param salaryPay
     */
    public Salary(int employeeID, String firstName, String lastName, String paySchedule, double salaryPay) {
        super(employeeID, firstName, lastName, paySchedule);
        this.salaryPay = salaryPay;
    }

    /**
     * @return Gross Pay
     */
    @Override
    public double calculateGrossPay() {
        return salaryPay;
    }

    /**
     * @return Earnings Statement
     */
    public String toString() {
        return  super.toString() +
                "Earnings                  Amount" + "\n" +
                "----------------------------------" + "\n" +
                "Salary" + "                    " + calculateGrossPay() + "\n" +
                "----------------------------------" + "\n" +
                "Gross Pay:" + "                " + calculateGrossPay() + "\n";
    }
}
