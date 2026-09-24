package Version5;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {

        super();

        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            int totalPiecesFinished,
            double ratePerPiece) {

        super(
                empID,
                empName,
                birthDate,
                dateHired
        );

        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {

        if (totalPiecesFinished < 0) {
            this.totalPiecesFinished = 0;
        } else {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public void setRatePerPiece(double ratePerPiece) {

        if (ratePerPiece < 0) {
            this.ratePerPiece = 0;
        } else {
            this.ratePerPiece = ratePerPiece;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int bonusBlocks =
                totalPiecesFinished / 100;

        double bonusPay =
                bonusBlocks * (10.0 * ratePerPiece);

        double salary =
                basePay + bonusPay;

        // Birthday bonus
        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayPieceWorkerEmployee() {

        System.out.println(
                "PieceWorkerEmployee{"
                        + "empID = " + getEmpID()
                        + ", empName = '" + getEmpName() + '\''
                        + ", birthDate = '" + getBirthDate() + '\''
                        + ", dateHired = '" + getDateHired() + '\''
                        + ", totalPiecesFinished = " + totalPiecesFinished
                        + ", ratePerPiece = " + ratePerPiece
                        + '}'
        );
    }

    @Override
    public String toString() {

        return "PieceWorkerEmployee{"
                + "empID = " + getEmpID()
                + ", empName = '" + getEmpName() + '\''
                + ", birthDate = '" + getBirthDate() + '\''
                + ", dateHired = '" + getDateHired() + '\''
                + ", totalPiecesFinished = " + totalPiecesFinished
                + ", ratePerPiece = " + ratePerPiece
                + ", salary = " + computeSalary(6)
                + '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof PieceWorkerEmployee)) {
            return false;
        }

        PieceWorkerEmployee other =
                (PieceWorkerEmployee) obj;

        return totalPiecesFinished ==
                other.totalPiecesFinished
                && Double.compare(
                ratePerPiece,
                other.ratePerPiece
        ) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                super.hashCode(),
                totalPiecesFinished,
                ratePerPiece
        );
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}