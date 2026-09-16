package version3;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        totalHoursWorked = 0;
        ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {

        super(empID, empName, birthDate, dateHired);

        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {

        double salary;

        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {

            double regularPay = 40 * ratePerHour;
            double overtimeHours = totalHoursWorked - 40;
            double overtimePay = overtimeHours * ratePerHour * 1.5;

            salary = regularPay + overtimePay;
        }

        return salary + super.computeSalary(currentMonth);
    }

    public void displayHourlyEmployee() {

        displayEmployee();

        System.out.println("Total Hours Worked: " + totalHoursWorked);
        System.out.printf("Rate Per Hour: %.2f%n", ratePerHour);
        System.out.printf("Salary: %.2f%n", computeSalary());
    }

    @Override
    public String toString() {
        return "HourlyEmployee [" + super.toString()
                + ", Hours: " + totalHoursWorked
                + ", Rate: " + String.format("%.2f", ratePerHour)
                + ", Salary: " + String.format("%.2f", computeSalary()) + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }

        HourlyEmployee other = (HourlyEmployee) obj;

        return super.equals(other)
                && totalHoursWorked == other.totalHoursWorked
                && ratePerHour == other.ratePerHour;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
                + Float.floatToIntBits(totalHoursWorked)
                + (int) ratePerHour;
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}