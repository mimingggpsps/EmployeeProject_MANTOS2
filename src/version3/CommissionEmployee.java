package version3;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        this.totalSale = totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public double getCommissionRate() {

        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {

        double commission =
                totalSale * getCommissionRate();

        return commission + super.computeSalary(currentMonth);
    }

    public void displayCommissionEmployee() {

        displayEmployee();

        System.out.printf("Total Sale: %.2f%n", totalSale);
        System.out.printf("Commission Rate: %.2f%%%n", getCommissionRate() * 100);
        System.out.printf("Salary: %.2f%n", computeSalary());
    }

    @Override
    public String toString() {
        return "CommissionEmployee [" + super.toString() + ", Sale: " + String.format("%.2f", totalSale) + ", Commission Rate: " + String.format("%.2f", getCommissionRate() * 100) + "%, Salary: " + String.format("%.2f", computeSalary()) + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }

        CommissionEmployee other =
                (CommissionEmployee) obj;

        return super.equals(other)
                && totalSale == other.totalSale;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) totalSale;
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}