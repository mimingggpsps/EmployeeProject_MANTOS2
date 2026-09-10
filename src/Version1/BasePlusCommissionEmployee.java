package Version1;

public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;


    public BasePlusCommissionEmployee() {
        empID = 0;
        empName = "N/A";
        totalSale = 0;
        baseSalary = 0;
    }


    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        totalSale = 0;
        baseSalary = 0;
    }


    public BasePlusCommissionEmployee(int empID, String empName,
                                      double totalSale,
                                      double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
    }


    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }


    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }


    public double computeSalary() {

        double commissionRate;

        if (totalSale < 50000) {
            commissionRate = 0.05;
        }
        else if (totalSale < 100000) {
            commissionRate = 0.10;
        }
        else if (totalSale < 500000) {
            commissionRate = 0.15;
        }
        else {
            commissionRate = 0.20;
        }

        return baseSalary + (totalSale * commissionRate);
    }


    public void displayBasePlusCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Total Sales: ₱%.2f | Base Salary: ₱%.2f%n",
                empID,
                empName,
                totalSale,
                baseSalary
        );
    }


    @Override
    public String toString() {

        double commissionRate;

        if (totalSale < 50000) {
            commissionRate = 0.05;
        }
        else if (totalSale < 100000) {
            commissionRate = 0.10;
        }
        else if (totalSale < 500000) {
            commissionRate = 0.15;
        }
        else {
            commissionRate = 0.20;
        }

        return String.format(
                "Version1.BasePlusCommissionEmployee [ID: %d, Name: %s, Sales: ₱%.2f, Base Salary: ₱%.2f, Commission Rate: %.0f%%, Total Salary: ₱%.2f]",
                empID,
                empName,
                totalSale,
                baseSalary,
                commissionRate * 100,
                computeSalary()
        );
    }
}