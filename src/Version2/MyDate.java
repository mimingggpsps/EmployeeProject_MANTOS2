package Version2;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return (day < 10 ? "0" + day : day) + " " + months[month] + " " + year;
    }
}
