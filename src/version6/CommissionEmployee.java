package version6;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

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
            throw new IllegalArgumentException(
                    "Total sale cannot be negative."
            );
        }

        this.totalSale = totalSale;
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

        double salary =
                totalSale * getCommissionRate();

        salary += getBirthdayBonus(currentMonth);

        return salary;
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    public void displayEmployee() {

        System.out.println(
                "CommissionEmployee{"
                        + "ID=" + getEmpID()
                        + ", Name=" + getEmpName()
                        + ", Birth Date=" + getBirthDate()
                        + ", Date Hired=" + getDateHired()
                        + ", Total Sale="
                        + String.format("%.2f", totalSale)
                        + ", Commission Rate="
                        + String.format("%.0f%%",
                        getCommissionRate() * 100)
                        + "}"
        );
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
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
}