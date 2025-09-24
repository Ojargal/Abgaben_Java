public class Date {
    private int day;
    private int month;
    private int year;

//    constructor
public Date(int day, int month, int year) {
    if (isValidDate(day, month, year)) {
        this.day = day;
        this.month = month;
        this.year = year;
    } else {
        throw new IllegalArgumentException("Invalid date");
    }
}


    private boolean isValidDate(int day, int month, int year) {
        if (year < 0 || month < 1 || month > 12 || day < 1){
            return false;
        }

        int daysInMonth = 31;
        if (month == 4 || month == 6 || month == 9 || month == 11){
            daysInMonth = 30;
        } else if (month == 2){
            daysInMonth = isLeapYear(year) ? 29 : 28;
        }
        return day <= daysInMonth;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

//    Getters and Setters


    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }

//    Comparison method for sorting
    public boolean isEarierThan(Date other){
        if (year != other.year) return year < other.year;
        if (month != other.month) return month < other.month;
        return day < other.day;
    }
}
