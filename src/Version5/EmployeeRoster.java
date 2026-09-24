package Version5;

import java.util.ArrayList;

public class EmployeeRoster {

    private ArrayList<Employee> empList;

    public EmployeeRoster() {

        empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {

        empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {

        if (emp == null) {
            return false;
        }

        empList.add(emp);

        return true;
    }

    public Employee removeEmployee(int empID) {

        for (int i = 0; i < empList.size(); i++) {

            if (empList.get(i).getEmpID() == empID) {

                Employee removed =
                        empList.get(i);

                empList.remove(i);

                return removed;
            }
        }

        return null;
    }

    public Employee searchEmployee(int empID) {

        for (Employee emp : empList) {

            if (emp.getEmpID() == empID) {
                return emp;
            }
        }

        return null;
    }

    public int countEmployees() {

        return empList.size();
    }

    public int countHE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp instanceof HourlyEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countPWE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp instanceof PieceWorkerEmployee) {
                total++;
            }
        }

        return total;
    }

    public int countCE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp.getClass() == CommissionEmployee.class) {
                total++;
            }
        }

        return total;
    }

    public int countBPCE() {

        int total = 0;

        for (Employee emp : empList) {

            if (emp instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }

    /*
     * VERSION 5:
     * No instanceof.
     * No casting.
     *
     * Java automatically calls the correct
     * subclass computeSalary() method.
     */
    public void displayPayroll(int currentMonth) {

        for (Employee emp : empList) {

            double salary =
                    emp.computeSalary(currentMonth);

            String birthday = "";

            if (emp.getBirthDate().getMonth() == currentMonth) {
                birthday = " (Birthday Bonus Applied)";
            }

            System.out.printf(
                    "ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(),
                    emp.getEmpName(),
                    salary,
                    birthday
            );
        }
    }

    public void displayAllEmployees() {

        for (Employee emp : empList) {

            System.out.println(emp);
        }
    }
}