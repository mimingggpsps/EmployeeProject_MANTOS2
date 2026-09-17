package Version4;

import java.util.Base64;

public class EmployeeRoster {
    private Employee[] emplist;
    private int max;
    private int count;

    public EmployeeRoster() {
        max = 10;
        emplist = new Employee[max];
        count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        emplist = new Employee[this.max];
        count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if(emp == null) {
            return false;
        }

        if(count >= max) {
            return false;
        }

        emplist[count] = emp;
        count++;

        return true;
    }

    public Employee removeEmployee(int empID) {
        for(int i = 0; i < count; i++) {
            if(emplist[i].getEmpID() == empID) {
                Employee removed = emplist[i];

                for(int j = 1; j < count - 1; j++) {
                    emplist[j] = emplist[j+1];
                }
                emplist[count - 1] = null;
                count--;

                return removed;
            }
        }
        return null;
    }

    public  Employee searchEmployee(int empID) {
        for(int i = 0; i < count; i++) {
            if(emplist[i].getEmpID() == empID) {
                return emplist[i];
            }
        }
        return null;
    }

    public int countHE() {
        int total = 0;

        for(int i = 0; i < count; i++) {
            if(emplist[i].getClass() == HourlyEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;

        for(int i = 0; i < count; i++) {
            if(emplist[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;

        for(int i = 0; i < count; i++) {
            if(emplist[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;

        for(int i = 0; i < count; i++) {
            if(emplist[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayHE() {
            for(int i = 0; i < count; i++) {
                if(emplist[i] instanceof HourlyEmployee) {
          HourlyEmployee emp = (HourlyEmployee) emplist[i];
          emp.displayHourlyEmployee();
                }
            }
        }


    public void displayPWE() {
        for(int i = 0; i < count; i++) {
            if(emplist[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee emp = (PieceWorkerEmployee) emplist[i];
                emp.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for(int i = 0; i < count; i++) {
            if(emplist[i] instanceof CommissionEmployee) {
                CommissionEmployee emp = (CommissionEmployee) emplist[i];
                emp.displayCommissionEmployee();
            }
        }
    }


    public void displayBPCE() {
        for(int i = 0; i < count; i++) {
            if(emplist[i] instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee emp = (BasePlusCommissionEmployee) emplist[i];
                emp.displayBasePlusCommissionEmployee();
            }
        }
    }


    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee emp = emplist[i];
            System.out.println((i + 1) + ". ID: " + emp.getEmpID() + " | Name: " + emp.getEmpName() + " | Type: " + emp.getClass().getName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee emp = emplist[i];
            String category;
            double salary;

            if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
                category = "Base Plus Commission";
                salary = bpce.computeSalary(currentMonth);
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) emp;
                category = "Commission";
                salary = ce.computeSalary(currentMonth);
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                category = "Piece Worker";
                salary = pwe.computeSalary(currentMonth);
            } else if (emp instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) emp;
                category = "Hourly";
                salary = he.computeSalary(currentMonth);
            } else {
                category = "Unknown";
                salary = emp.computeSalary(currentMonth);
            }

        }
    }
}
