package Version4;


import java.util.Objects;


public class BasePlusCommissionEmployee
        extends CommissionEmployee {


    private double baseSalary;


    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }


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
            this.baseSalary = 0;
        } else {
            this.baseSalary = baseSalary;
        }
    }


    public double computeSalary(int currentMonth) {


        double salary =
                getTotalSale() * getCommissionRate()
                        + baseSalary;


        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }


        return salary;
    }


    public void displayBasePlusCommissionEmployee() {
        System.out.println(
                "BasePlusCommissionEmployee{" +
                        "empID = " + getEmpID() +
                        ", empName = '" + getEmpName() + '\'' +
                        ", birthDate = '" + getBirthDate() + '\'' +
                        ", dateHired = '" + getDateHired() + '\'' +
                        ", totalSale = " + getTotalSale() +
                        ", baseSalary = " + baseSalary +
                        '}'
        );
    }


    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "empID = " + getEmpID() +
                ", empName = '" + getEmpName() + '\'' +
                ", birthDate = '" + getBirthDate() + '\'' +
                ", dateHired = '" + getDateHired() + '\'' +
                ", totalSale = " + getTotalSale() +
                ", baseSalary = " + baseSalary +
                ", salary = " + computeSalary(6) +
                '}';
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


    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
