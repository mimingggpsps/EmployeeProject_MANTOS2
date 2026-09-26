package version6;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

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
            throw new IllegalArgumentException(
                    "Total pieces finished cannot be negative."
            );
        }

        this.totalPiecesFinished =
                totalPiecesFinished;
    }

    public void setRatePerPiece(double ratePerPiece) {

        if (ratePerPiece < 0) {
            throw new IllegalArgumentException(
                    "Rate per piece cannot be negative."
            );
        }

        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {

        double basePay =
                totalPiecesFinished * ratePerPiece;

        int bonusBlocks =
                totalPiecesFinished / 100;

        double productionBonus =
                bonusBlocks * 10 * ratePerPiece;

        return basePay
                + productionBonus
                + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    public void displayEmployee() {

        System.out.println(
                "PieceWorkerEmployee{"
                        + "ID=" + getEmpID()
                        + ", Name=" + getEmpName()
                        + ", Birth Date=" + getBirthDate()
                        + ", Date Hired=" + getDateHired()
                        + ", Pieces=" + totalPiecesFinished
                        + ", Rate=" + String.format("%.2f", ratePerPiece)
                        + "}"
        );
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
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
}