package christmas.domain;

public class Date {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 31;
    private int date;

    private Date(int date) {
        this.date = date;
    }

    public static Date from(int date) {
        validateRange(date);
        return new Date(date);
    }

    private static void validateRange(int number) {
        if (number < RANGE_MIN || number > RANGE_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_DATE.getMessage());
        }
    }
}
