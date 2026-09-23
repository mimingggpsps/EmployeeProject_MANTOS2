package Version4;


public class Main4 {


    public static void main(String[] args) {


        System.out.println(
                "EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT"
        );



        EmployeeRoster roster = new EmployeeRoster(6);


        HourlyEmployee mary =
                new HourlyEmployee(
                        101,
                        new Name("Mary Rose", "D.", "Alvarez"),
                        new MyDate(15, 9, 2000),
                        new MyDate(10, 1, 2024),
                        40,
                        237.50
                );



        PieceWorkerEmployee bob =
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


        BasePlusCommissionEmployee kevin =
                new BasePlusCommissionEmployee(
                        401,
                        new Name("Kurt", "L.", "Raganas"),
                        new MyDate(12, 7, 1998),
                        new MyDate(8, 4, 2022),
                        100000,
                        17000
                );


        HourlyEmployee david =
                new HourlyEmployee(
                        102,
                        new Name("Jonel", "A.", "Uy"),
                        new MyDate(25, 6, 2000),
                        new MyDate(15, 5, 2024),
                        40,
                        200.00
                );



        System.out.println(
                "Added: " + mary.getEmpName()
                        + " (Hourly) -> "
                        + (roster.addEmployee(mary)
                        ? "Success" : "Failed")
        );


        System.out.println(
                "Added: " + bob.getEmpName()
                        + " (Piece Worker) -> "
                        + (roster.addEmployee(bob)
                        ? "Success" : "Failed")
        );


        System.out.println(
                "Added: " + kyum.getEmpName()
                        + " (Commission) -> "
                        + (roster.addEmployee(kyum)
                        ? "Success" : "Failed")
        );


        System.out.println(
                "Added: " + kevin.getEmpName()
                        + " (Base Plus Commission) -> "
                        + (roster.addEmployee(kevin)
                        ? "Success" : "Failed")
        );


        System.out.println(
                "Added: " + david.getEmpName()
                        + " (Hourly) -> "
                        + (roster.addEmployee(david)
                        ? "Success" : "Failed")
        );



        Employee extra =
                new Employee(
                        999,
                        new Name("Extra", "Employee"),
                        new MyDate(1, 1, 2000),
                        new MyDate(1, 1, 2025)
                );


        System.out.println(
                "Attempting to add employee beyond capacity..."
        );


        System.out.println(
                "Added extra employee -> "
                        + (roster.addEmployee(extra)
                        ? "Success" : "Failed - Roster Full")
        );


        System.out.println();



        System.out.println(
                "--- ROSTER COMPOSITION COUNTS ---"
        );


        System.out.println(
                "Total Employees: 5 / 6"
        );


        System.out.println(
                "Hourly Employees: "
                        + roster.countHE()
        );


        System.out.println(
                "Piece Worker Employees: "
                        + roster.countPWE()
        );


        System.out.println(
                "Commission Employees (Pure): "
                        + roster.countCE()
        );


        System.out.println(
                "Base Plus Commission Employees: "
                        + roster.countBPCE()
        );


        System.out.println();




        System.out.println(
                "HOURLY EMPLOYEES"
        );



        roster.displayHE();


        System.out.println();





        System.out.println(
                "PIECE WORKER EMPLOYEES"
        );




        roster.displayPWE();


        System.out.println();




        System.out.println(
                "COMMISSION EMPLOYEES"
        );





        roster.displayCE();


        System.out.println();



        System.out.println(
                "BASE PLUS COMMISSION EMPLOYEES"
        );




        roster.displayBPCE();


        System.out.println();




        System.out.println(
                "ROSTER PAYROLL REPORT (Target Month: Sep)"
        );




        roster.displayPayroll(9);


        System.out.println();




        System.out.println(
                "TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION"
        );




        System.out.println(
                "Removing Employee ID 201 ("
                        + bob.getEmpName()
                        + ")..."
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


        System.out.println(
                "Current Employee Count: 4"
        );


        System.out.println(
                "Remaining Employees in Roster:"
        );


        roster.displayAllEmployees();



    }
}
