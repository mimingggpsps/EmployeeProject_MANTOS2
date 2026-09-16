package version3;

public class Main3 {

    public static void main(String[] args) {

        int targetMonth = 9;

        Name name1 =
                new Name("Alice", "Marie", "Smith");

        MyDate birth1 =
                new MyDate(18, 9, 2000);

        MyDate hired1 =
                new MyDate(1, 6, 2022);


        Name name2 =
                new Name("Bob", "Charles", "Jones", "Jr.");

        MyDate birth2 =
                new MyDate(5, 4, 1998);

        MyDate hired2 =
                new MyDate(15, 1, 2023);


        Name name3 =
                new Name("Charlie", "D", "Brown");

        MyDate birth3 =
                new MyDate(10, 7, 2001);

        MyDate hired3 =
                new MyDate(20, 8, 2022);


        Name name4 =
                new Name("David", "E", "Garcia");

        MyDate birth4 =
                new MyDate(25, 9, 1999);

        MyDate hired4 =
                new MyDate(10, 5, 2021);


        Employee[] employees = {

                new HourlyEmployee(
                        101, name1, birth1, hired1,
                        45, 237.50),

                new PieceWorkerEmployee(
                        201, name2, birth2, hired2,
                        100, 40.50),

                new CommissionEmployee(
                        301, name3, birth3, hired3,
                        120000),

                new BasePlusCommissionEmployee(
                        401, name4, birth4, hired4,
                        150000, 10000)
        };


        System.out.println(
                "======================================================================");

        System.out.println(
                "POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");

        System.out.println(
                "======================================================================");


        for (int i = 0; i < employees.length; i++) {

            double totalSalary =
                    employees[i].computeSalary(targetMonth);

            double salaryWithoutBonus =
                    employees[i].computeSalary();

            double birthdayBonus =
                    totalSalary - salaryWithoutBonus;


            System.out.println();
            System.out.println((i + 1) + ". "
                    + employees[i].getClass().getSimpleName()
                    + " [" + employees[i].toString() + "]");

            System.out.printf(
                    "  Base Pay: %.2f%n",
                    salaryWithoutBonus);

            System.out.printf(
                    "  Birthday Bonus: %.2f",
                    birthdayBonus);

            if (birthdayBonus > 0) {
                System.out.println(" (Eligible)");
            } else {
                System.out.println(" (Ineligible)");
            }

            System.out.printf(
                    "  Total Payout: %.2f%n",
                    totalSalary);
        }


        System.out.println();
        System.out.println(
                "======================================================================");

        System.out.println(
                "OBJECT CONTRACT TESTS (equals & hashCode)");

        System.out.println(
                "======================================================================");


        Name testName1 =
                new Name("Alice", "Marie", "Smith");

        Name testName2 =
                new Name("Alice", "Marie", "Smith");


        MyDate testBirth1 =
                new MyDate(18, 9, 2000);

        MyDate testBirth2 =
                new MyDate(18, 9, 2000);


        MyDate testHire1 =
                new MyDate(1, 6, 2022);

        MyDate testHire2 =
                new MyDate(1, 6, 2022);


        Employee emp1 =
                new HourlyEmployee(
                        101,
                        testName1,
                        testBirth1,
                        testHire1,
                        45,
                        237.50);


        Employee emp1Identical =
                new HourlyEmployee(
                        101,
                        testName2,
                        testBirth2,
                        testHire2,
                        45,
                        237.50);


        Employee emp2 =
                new HourlyEmployee(
                        102,
                        testName2,
                        testBirth2,
                        testHire2,
                        45,
                        237.50);


        System.out.println(
                "emp1 equals emp1Identical: "
                        + emp1.equals(emp1Identical));

        System.out.println(
                "emp1 hashCode: "
                        + emp1.hashCode()
                        + " | emp1Identical hashCode: "
                        + emp1Identical.hashCode());

        System.out.println(
                "Hash codes match: "
                        + (emp1.hashCode()
                        == emp1Identical.hashCode()));

        System.out.println(
                "emp1 equals emp2: "
                        + emp1.equals(emp2));



        System.out.println();
        System.out.println(
                "======================================================================");

        System.out.println(
                "DEEP CLONE VERIFICATION");

        System.out.println(
                "======================================================================");


        HourlyEmployee original =
                new HourlyEmployee(
                        101,
                        new Name("Alice", "Marie", "Smith"),
                        new MyDate(18, 9, 2000),
                        new MyDate(1, 6, 2022),
                        45,
                        237.50);


        HourlyEmployee clone =
                original.clone();


        System.out.println(
                "Original Name before modification: "
                        + original.getEmpName());


        clone.getEmpName().setLastName("Taylor");


        System.out.println(
                "Clone Name changed to: "
                        + clone.getEmpName());


        System.out.println(
                "Original Name after modification: "
                        + original.getEmpName());


        System.out.println(
                "Deep copy successful!");
    }
}