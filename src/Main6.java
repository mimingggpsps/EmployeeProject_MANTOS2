package version6;

public class Main6 {

    public static void main(String[] args) {


        System.out.println();
        System.out.println(
                "Employee is abstract and cannot be instantiated directly."
        );


        System.out.println(
                "1. TESTING ENCAPSULATION & DEFENSIVE COPYING"
        );

        MyDate originalBirthDate =
                new MyDate(
                        15,
                        12,
                        1995
                );

        HourlyEmployee testEmployee =
                new HourlyEmployee(
                        100,
                        new Name(
                                "Test",
                                "Employee"
                        ),
                        originalBirthDate,
                        new MyDate(
                                1,
                                1,
                                2025
                        ),
                        40,
                        100.00
                );

        System.out.println(
                "Original Birth Month: "
                        + testEmployee.getBirthDate().getMonth()
                        + " (Dec)"
        );

        System.out.println(
                "Attempting external tampering: "
                        + "emp.getBirthDate().setMonth(9)..."
        );

        testEmployee.getBirthDate().setMonth(9);

        System.out.println(
                "Employee's Actual Birth Date after tampering attempt: "
                        + testEmployee.getBirthDate()
        );

        if (testEmployee.getBirthDate().getMonth() == 12) {

            System.out.println(
                    "Result: SUCCESS "
                            + "(Internal state protected via defensive copying)"
            );

        } else {

            System.out.println(
                    "Result: FAILED"
            );
        }


        System.out.println(
                "2. TESTING EXCEPTION HANDLING & INPUT VALIDATION"
        );



        System.out.println(
                "Attempting to create HourlyEmployee with rate: -150.00..."
        );

        try {

            HourlyEmployee invalidEmployee =
                    new HourlyEmployee(
                            999,
                            new Name(
                                    "Invalid",
                                    "Employee"
                            ),
                            new MyDate(
                                    10,
                                    5,
                                    2000
                            ),
                            new MyDate(
                                    1,
                                    1,
                                    2025
                            ),
                            40,
                            -150.00
                    );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Caught Expected Exception: "
                            + "[IllegalArgumentException] "
                            + e.getMessage()
            );
        }

        System.out.println();

        System.out.println(
                "Attempting to assign invalid calendar date: "
                        + "31 Feb 2026..."
        );

        try {

            MyDate invalidDate =
                    new MyDate(
                            31,
                            2,
                            2026
                    );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Caught Expected Exception: "
                            + "[IllegalArgumentException] "
                            + e.getMessage()
            );
        }




        System.out.println(
                "3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)"
        );

        System.out.println(
                "[Dynamic Dispatch via Abstract Contract computeSalary()]"
        );


        EmployeeRoster roster =
                new EmployeeRoster();


        HourlyEmployee mary =
                new HourlyEmployee(
                        101,
                        new Name(
                                "Mary",
                                "M.",
                                "Raganas"
                        ),
                        new MyDate(
                                15,
                                9,
                                1995
                        ),
                        new MyDate(
                                10,
                                1,
                                2024
                        ),
                        40,
                        237.50
                );

        PieceWorkerEmployee kyum =
                new PieceWorkerEmployee(
                        201,
                        new Name(
                                "Kyum",
                                "C.",
                                "Kyum",
                                "Jr."
                        ),
                        new MyDate(
                                20,
                                5,
                                2001
                        ),
                        new MyDate(
                                12,
                                2,
                                2024
                        ),
                        90,
                        45.00
                );

        CommissionEmployee kurt =
                new CommissionEmployee(
                        301,
                        new Name(
                                "Kurt",
                                "L.",
                                "Alvarez"
                        ),
                        new MyDate(
                                8,
                                9,
                                1999
                        ),
                        new MyDate(
                                5,
                                3,
                                2023
                        ),
                        100000
                );

        BasePlusCommissionEmployee jonel =
                new BasePlusCommissionEmployee(
                        401,
                        new Name(
                                "Jonel",
                                "A.",
                                "Uy"
                        ),
                        new MyDate(
                                12,
                                7,
                                1998
                        ),
                        new MyDate(
                                8,
                                4,
                                2022
                        ),
                        100000,
                        17000
                );

        roster.addEmployee(mary);
        roster.addEmployee(kyum);
        roster.addEmployee(kurt);
        roster.addEmployee(jonel);

        roster.displayPayroll(9);

    }
}