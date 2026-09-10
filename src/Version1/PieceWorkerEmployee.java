package Version1;

public class PieceWorkerEmployee {

    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;


    public PieceWorkerEmployee() {
        empID = 0;
        empName = "N/A";
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }


    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }


    public PieceWorkerEmployee(int empID, String empName,
                               int totalPiecesFinished,
                               double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }


    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }


    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        }
    }


    public double computeSalary() {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int bonusPieces =
                totalPiecesFinished / 100;

        double bonusPay =
                bonusPieces * (10 * ratePerPiece);

        return basePay + bonusPay;
    }


    public void displayPieceWorkerEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f%n",
                empID,
                empName,
                totalPiecesFinished,
                ratePerPiece
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Version1.PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID,
                empName,
                totalPiecesFinished,
                ratePerPiece,
                computeSalary()
        );
    }
}