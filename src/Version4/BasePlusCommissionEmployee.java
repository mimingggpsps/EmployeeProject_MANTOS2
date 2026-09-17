package Version4;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        baseSalary = 0;
    }

    public BasePlusCommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale,
            double baseSalary) {

        super(empID, empName, birthDate, dateHired, totalSale);

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {

        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {

        displayEmployee();

        System.out.printf("Base Salary: %.2f%n", baseSalary);
        System.out.printf("Total Sale: %.2f%n", getTotalSale());
        System.out.printf("Total Salary: %.2f%n", computeSalary());
    }

    @Override
    public String toString() {

        return "BasePlusCommissionEmployee [" + super.toString() + ", Base Salary: " + String.format("%.2f", baseSalary) + ", Total Salary: " + String.format("%.2f", computeSalary()) + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }

        BasePlusCommissionEmployee other =
                (BasePlusCommissionEmployee) obj;

        return super.equals(other)
                && baseSalary == other.baseSalary;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) baseSalary;
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}