package version6;

import java.util.Objects;

public final class BasePlusCommissionEmployee
        extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale,
            double baseSalary) {

        super(
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale
        );

        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {

        if (baseSalary < 0) {
            throw new IllegalArgumentException(
                    "Base salary cannot be negative."
            );
        }

        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {

        return baseSalary
                + super.computeSalary(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    public void displayEmployee() {

        System.out.println(
                "BasePlusCommissionEmployee{"
                        + "ID=" + getEmpID()
                        + ", Name=" + getEmpName()
                        + ", Birth Date=" + getBirthDate()
                        + ", Date Hired=" + getDateHired()
                        + ", Total Sale="
                        + String.format("%.2f", getTotalSale())
                        + ", Base Salary="
                        + String.format("%.2f", baseSalary)
                        + "}"
        );
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof BasePlusCommissionEmployee)) {
            return false;
        }

        BasePlusCommissionEmployee other =
                (BasePlusCommissionEmployee) obj;

        return Double.compare(
                baseSalary,
                other.baseSalary
        ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                baseSalary
        );
    }
}