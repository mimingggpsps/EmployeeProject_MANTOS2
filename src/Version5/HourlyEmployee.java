package Version5;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {

        super();

        this.totalHoursWorked = 0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            float totalHoursWorked,
            double ratePerHour) {

        super(
                empID,
                empName,
                birthDate,
                dateHired
        );

        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {

        if (totalHoursWorked < 0) {
            this.totalHoursWorked = 0f;
        } else {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public void setRatePerHour(double ratePerHour) {

        if (ratePerHour < 0) {
            this.ratePerHour = 0.0;
        } else {
            this.ratePerHour = ratePerHour;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {

        double salary;

        if (totalHoursWorked <= 40) {

            salary =
                    totalHoursWorked * ratePerHour;

        } else {

            double regularPay =
                    40 * ratePerHour;

            double overtimePay =
                    (totalHoursWorked - 40)
                            * (ratePerHour * 1.5);

            salary =
                    regularPay + overtimePay;
        }

        // Birthday bonus
        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayHourlyEmployee() {

        System.out.println(
                "HourlyEmployee {"
                        + "empID = " + getEmpID()
                        + ", empName = '" + getEmpName() + '\''
                        + ", birthDate = '" + getBirthDate() + '\''
                        + ", dateHired = '" + getDateHired() + '\''
                        + ", totalHoursWorked = " + totalHoursWorked
                        + ", ratePerHour = " + ratePerHour
                        + '}'
        );
    }

    @Override
    public String toString() {

        return "HourlyEmployee {"
                + "empID = " + getEmpID()
                + ", empName = '" + getEmpName() + '\''
                + ", birthDate = '" + getBirthDate() + '\''
                + ", dateHired = '" + getDateHired() + '\''
                + ", totalHoursWorked = " + totalHoursWorked
                + ", ratePerHour = " + ratePerHour
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

        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }

        HourlyEmployee other =
                (HourlyEmployee) obj;

        return Float.compare(
                totalHoursWorked,
                other.totalHoursWorked
        ) == 0
                && Double.compare(
                ratePerHour,
                other.ratePerHour
        ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                totalHoursWorked,
                ratePerHour
        );
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}