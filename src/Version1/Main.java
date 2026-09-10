package Version1;

public class Main {

    public static void main(String[] args) {


        System.out.println("--- Hourly Employee Test ---");


        HourlyEmployee hourly1 = new HourlyEmployee();

        hourly1.setEmpID(101);
        hourly1.setEmpName("Chloe Mae");
        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(hourly1);



        System.out.println();
        System.out.println("--- Piece Worker Employee Test ---");


        PieceWorkerEmployee piece1 =
                new PieceWorkerEmployee();

        piece1.setEmpID(201);
        piece1.setEmpName("Bob Mantos");
        piece1.setTotalPiecesFinished(200);
        piece1.setRatePerPiece(15);

        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(piece1);


        System.out.println();
        System.out.println("--- Commission Employee Test ---");


        CommissionEmployee commission1 =
                new CommissionEmployee();

        commission1.setEmpID(202);
        commission1.setEmpName("Kurt Ian");
        commission1.setTotalSale(7500);

        System.out.println("[displayCommissionEmployee()]");
        commission1.displayCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(commission1);



        System.out.println();
        System.out.println("--- Base Plus Commission Employee Test ---");

        BasePlusCommissionEmployee base1 =
                new BasePlusCommissionEmployee();

        base1.setEmpID(401);
        base1.setEmpName("Mary Rose");
        base1.setTotalSale(15000);
        base1.setBaseSalary(2000);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        base1.displayBasePlusCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(base1);

    }
}