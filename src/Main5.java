package Version5;

public class Main5 {

    public static void main(String[] args) {


        System.out.println(
                "DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)"
        );


        EmployeeRoster roster =
                new EmployeeRoster();


        HourlyEmployee mary =
                new HourlyEmployee(
                        101,
                        new Name("Mary Rose", "D.", "Alvarez"),
                        new MyDate(15, 9, 2000),
                        new MyDate(10, 1, 2024),
                        40, 237.50
                );

        PieceWorkerEmployee chloe =
                new PieceWorkerEmployee(
                        201,
                        new Name("Chloe", "L.", "Mentos", "Jr."),
                        new MyDate(20, 5, 2001),
                        new MyDate(12, 2, 2024),
                        90,
                        45.00
                );


        CommissionEmployee kyum =
                new CommissionEmployee(
                        301,
                        new Name("Kyum", "L.", "Kyum"),
                        new MyDate(8, 9, 1999),
                        new MyDate(5, 3, 2023),
                        100000
                );


        BasePlusCommissionEmployee kurt =
                new BasePlusCommissionEmployee(
                        401,
                        new Name("Kurt", "L.", "Raganas"),
                        new MyDate(12, 7, 1998),
                        new MyDate(8, 4, 2022),
                        100000,
                        17000
                );

        roster.addEmployee(mary);

        System.out.println(
                "Enrolled: " + mary.getEmpName() + " (Hourly)"
        );

        roster.addEmployee(chloe);

        System.out.println(
                "Enrolled: " + chloe.getEmpName() + " (Piece Worker)"
        );

        roster.addEmployee(kyum);

        System.out.println(
                "Enrolled: " + kyum.getEmpName() + " (Commission)"
        );

        roster.addEmployee(kurt);

        System.out.println(
                "Enrolled: " + kurt.getEmpName() + " (Base Plus Commission)"
        );

        System.out.println();

        System.out.println(
                "Total Roster Size: " + roster.countEmployees() + " employees"
        );

        System.out.println();

        System.out.println(
                "ROSTER COMPOSITION"
        );

        System.out.println(
                "Hourly Employees: " + roster.countHE()
        );

        System.out.println(
                "Piece Worker Employees: " + roster.countPWE()
        );

        System.out.println(
                "Commission Employees: " + roster.countCE()
        );

        System.out.println(
                "Base Plus Commission Employees: " + roster.countBPCE()
        );

        System.out.println();

        System.out.println(
                "PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)"
        );

        System.out.println(
                "[No downcasting; dynamic dispatch via Employee.computeSalary()]"
        );

        roster.displayPayroll(9);

        System.out.println();


        System.out.println(
                "COLLECTION REMOVAL TEST"
        );

        System.out.println(
                "Removing Employee ID 201..."
        );

        Employee removed =
                roster.removeEmployee(201);

        if (removed != null) {

            System.out.println(
                    "Successfully removed."
            );

        } else {

            System.out.println(
                    "Employee not found."
            );
        }

        System.out.println();

        System.out.println(
                "Updated Roster Size: " + roster.countEmployees()
        );

        System.out.println();

        System.out.println(
                "Current Active Employees:"
        );

        roster.displayAllEmployees();

    }
}