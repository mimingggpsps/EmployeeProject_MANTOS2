package version6;

import java.util.Objects;

public final class MyDate implements Cloneable {

    private int day;
    private int month;
    private int year;

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {

        validateDate(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    private static void validateDate(
            int day,
            int month,
            int year) {

        if (year <= 1900) {
            throw new IllegalArgumentException(
                    "Invalid calendar date"
            );
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(
                    "Invalid calendar date"
            );
        }

        int maxDay;

        switch (month) {

            case 2:
                if (isLeapYear(year)) {
                    maxDay = 29;
                } else {
                    maxDay = 28;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                maxDay = 30;
                break;

            default:
                maxDay = 31;
        }

        if (day < 1 || day > maxDay) {
            throw new IllegalArgumentException(
                    "Invalid calendar date"
            );
        }
    }

    private static boolean isLeapYear(int year) {

        return (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);
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

        validateDate(day, month, year);

        this.day = day;
    }

    public void setMonth(int month) {

        validateDate(day, month, year);

        this.month = month;
    }

    public void setYear(int year) {

        validateDate(day, month, year);

        this.year = year;
    }

    public String displayDate() {

        String[] months = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"
        };

        return String.format(
                "%02d %s %04d",
                day,
                months[month - 1],
                year
        );
    }

    @Override
    public String toString() {
        return displayDate();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MyDate)) {
            return false;
        }

        MyDate other = (MyDate) obj;

        return day == other.day
                && month == other.month
                && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {

        try {
            return (MyDate) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}