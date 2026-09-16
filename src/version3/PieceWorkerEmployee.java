package version3;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        totalPiecesFinished = 0;
        ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        int bonus = totalPiecesFinished / 100;
        double productionPay =
                totalPiecesFinished * ratePerPiece;

        double productionBonus =
                bonus * 10 * ratePerPiece;

        return productionPay
                + productionBonus
                + super.computeSalary(currentMonth);
    }

    public void displayPieceWorkerEmployee() {

        displayEmployee();

        System.out.println("Total Pieces Finished: " + totalPiecesFinished);
        System.out.printf("Rate Per Piece: %.2f%n", ratePerPiece);
        System.out.printf("Salary: %.2f%n", computeSalary());
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee [" + super.toString()
                + ", Pieces: " + totalPiecesFinished
                + ", Rate: " + String.format("%.2f", ratePerPiece)
                + ", Salary: " + String.format("%.2f", computeSalary()) + "]";
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;

        return super.equals(other)
                && totalPiecesFinished == other.totalPiecesFinished
                && ratePerPiece == other.ratePerPiece;
    }

    @Override
    public int hashCode() {
        return super.hashCode()
                + totalPiecesFinished
                + (int) ratePerPiece;
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}