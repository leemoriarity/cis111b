public class EmployeeTester {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        employees[0] = new Employee(1001,"Lee", "Moriarity", "Bi-Weekly");
        employees[1] = new HourlyEmployee(1002,"Erika", "Sulo","Weekly", 44, 16);
        employees[2] = new SalariedEmployee(1003,"Vinko", "Jervis", "Monthly", 4000);
        employees[3] = new CommissionEmployee(1004,"Brooke", "Baker", "Weekly", 3700, .20);
        employees[4] = new HourlyEmployeeBonus(1005,"Omari", "Valentine", "Weekly",45, 16,2.5);
        employees[5] = new BasePlusCommissionEmployee(1006,"Trevor", "Phelps", "Weekly",2030, .15,100);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
