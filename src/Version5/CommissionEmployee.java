package Version5;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {

        super();

        this.totalSale = 0.0;
    }

    public CommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale) {

        super(
                empID,
                empName,
                birthDate,
                dateHired
        );

        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {

        if (totalSale < 0) {
            this.totalSale = 0;
        } else {
            this.totalSale = totalSale;
        }
    }

    public double getCommissionRate() {

        double rate;

        if (totalSale < 50000) {

            rate = 0.05;

        } else if (totalSale < 100000) {

            rate = 0.10;

        } else if (totalSale < 500000) {

            rate = 0.15;

        } else {

            rate = 0.20;
        }

        return rate;
    }

    @Override
    public double computeSalary(int currentMonth) {

        double salary =
                totalSale * getCommissionRate();

        // Birthday bonus
        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayCommissionEmployee() {

        System.out.println(
                "CommissionEmployee{"
                        + "empID = " + getEmpID()
                        + ", empName = '" + getEmpName() + '\''
                        + ", birthDate = '" + getBirthDate() + '\''
                        + ", dateHired = '" + getDateHired() + '\''
                        + ", totalSale = " + totalSale
                        + '}'
        );
    }

    @Override
    public String toString() {

        return "CommissionEmployee{"
                + "empID = " + getEmpID()
                + ", empName = '" + getEmpName() + '\''
                + ", birthDate = '" + getBirthDate() + '\''
                + ", dateHired = '" + getDateHired() + '\''
                + ", totalSale = " + totalSale
                + ", salary = " + computeSalary(6)
                + '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }

        CommissionEmployee other =
                (CommissionEmployee) obj;

        return Double.compare(
                totalSale,
                other.totalSale
        ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                totalSale
        );
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}