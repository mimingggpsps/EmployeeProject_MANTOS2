package Version2;

public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int piecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {}

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int piecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.piecesFinished = piecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public int getPiecesFinished() {
        return piecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }
    public void setPiecesFinished(int pieces) {
        this.piecesFinished = pieces;
    }
    public void setRatePerPiece(double rate) {
        this.ratePerPiece = rate;
    }

    public double computeSalary() {
        return (piecesFinished * ratePerPiece) + ((piecesFinished / 100) * 10 * ratePerPiece);
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if (birthDate.getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces: %d | Rate: ₱%.2f/pc%n",
                empID, empName, birthDate, dateHired, piecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, birthDate, dateHired, piecesFinished, ratePerPiece, computeSalary());
    }
}
