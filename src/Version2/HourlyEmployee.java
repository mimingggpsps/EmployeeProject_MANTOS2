package Version2;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {}

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
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

    public void setTotalHoursWorked(float hours) {
        this.totalHoursWorked = hours;
    }

    public void setRatePerHour(double rate) {
        this.ratePerHour = rate;
    }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        } else {
            return (40 * ratePerHour) + ((totalHoursWorked - 40) * ratePerHour * 1.5);
        }
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if (birthDate.getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour, computeSalary());
    }
}
