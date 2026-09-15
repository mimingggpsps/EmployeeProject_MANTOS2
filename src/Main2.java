package Version2;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("=== 1. Composition Verification ===");
        Name sampleName = new Name("Chloe Mae", "L", "Mantos");
        MyDate sampleDate = new MyDate(15, 5, 2026);

        System.out.print("Name: ");
        sampleName.displayName();
        System.out.print("Date: ");
        sampleDate.displayDate();
        System.out.println();

        System.out.println("--- Hourly Employee Payroll Test ---");
        MyDate dob = new MyDate(15, 5, 2007);
        MyDate hired = new MyDate(1, 6, 2022);
        HourlyEmployee emp1 = new HourlyEmployee(101, sampleName, dob, hired, 45.0f, 200.0);

        HourlyEmployee emp2 = new HourlyEmployee();
        emp2.setEmpID(102);
        emp2.setEmpName(new Name("Bob", "C", "Jones", "Jr."));
        emp2.setBirthDate(new MyDate(15, 10, 1995));
        emp2.setDateHired(new MyDate(12, 3, 2021));
        emp2.setTotalHoursWorked(40.0f);
        emp2.setRatePerHour(150.0);

        System.out.println("[displayHourlyEmployee()]");
        emp1.displayHourlyEmployee();

        System.out.println("\n[toString()]");
        System.out.println(emp1);

        System.out.println("\n[Birthday Incentive Check]");
        // FIXED: Changed parameter from 10 to 6 to match June
        System.out.printf("Regular Month (June) Salary: ₱%.2f%n", emp1.computeSalary(6));
        // FIXED: Changed parameter from 9 to 5 to match May (Chloe's birth month)
        System.out.printf("Birth Month (May) Salary (+₱5,000.00): ₱%.2f%n", emp1.computeSalary(5));
        System.out.println();

        System.out.println("--- Piece Worker Employee Test ---");
        PieceWorkerEmployee pw1 = new PieceWorkerEmployee(201, new Name("Charlie", "D", "Brown"), new MyDate(5, 4, 1998), new MyDate(10, 1, 2020), 250, 50.0);

        System.out.println("[displayPieceWorkerEmployee()]");
        pw1.displayPieceWorkerEmployee();

        System.out.println("\n[toString()]");
        System.out.println(pw1);

        System.out.printf("Regular Month Salary: ₱%.2f | Birth Month (Apr) Salary: ₱%.2f%n", pw1.computeSalary(5), pw1.computeSalary(4));
    }
}
