package version3;

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        empID = 0;
        empName = new Name();
        birthDate = new MyDate();
        dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
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

    public double computeSalary(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return 5000;
        }

        return 0;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + empName);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Date Hired: " + dateHired);
    }

    @Override
    public String toString() {
        return "Employee ID: " + empID
                + ", Name: " + empName
                + ", Birth Date: " + birthDate
                + ", Date Hired: " + dateHired;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;

        return empID == other.empID;
    }

    @Override
    public int hashCode() {
        return empID;
    }

    @Override
    public Employee clone() {

        try {
            Employee copy = (Employee) super.clone();

            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();

            return copy;

        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}