package Version2;

public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSales;
    private double baseSalary;

    public BasePlusCommissionEmployee() {}

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSales, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalSales = totalSales;
        this.baseSalary = baseSalary;
    }

    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public void setTotalSales(double sales) {
        this.totalSales = sales;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double computeSalary() {
        double rate = 0.05;
        if(totalSales >= 500000) {
            rate = 0.20;
        }

        else if(totalSales >= 100000) {
            rate = 0.15;
        }

        else if (totalSales >= 50000) {
            rate = 0.10;
        }
        return baseSalary + (totalSales * rate);
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if(birthDate.getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }


    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Sales: ₱%.2f | Base: ₱%.2f%n",
                empID, empName, birthDate, dateHired, totalSales, baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%.2f, Base: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, birthDate, dateHired, totalSales, baseSalary, computeSalary());
    }
}
