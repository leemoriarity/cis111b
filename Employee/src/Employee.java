public class Employee {

    private int employeeID;
    private String firstName;
    private String lastName;
    private final String paySchedule;

    /**
     * Default Employee Constructor
     */
    public Employee(){
        this.employeeID = 1;
        this.firstName = "Lee";
        this.lastName = "Moriarity";
        this.paySchedule = "Bi-Weekly";
    }

    /**
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param paySchedule
     */
    public Employee(int employeeID, String firstName, String lastName, String paySchedule) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.paySchedule = paySchedule;
    }

    //Getters
    public int getEmployeeID() {
        return employeeID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    //Setters
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Gross Pay
     */
    public double calculateGrossPay(){
        return 0;
    }

    /**
     * @return Earnings Statement
     */
    @Override
    public String toString() {
        return  "E A R N I N G S    S T A T E M E N T" + "\n" +
                "Employee No.:  " + employeeID + "\n" +
                "Employee Name: " + firstName + " " + lastName + "\n" +
                "Pay Frequency: " + paySchedule + "\n";
    }
}