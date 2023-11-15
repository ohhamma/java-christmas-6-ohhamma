package christmas.domain.visit;

import christmas.domain.exception.ExceptionMessage;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class Date {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final LocalDate DATE_MIN = LocalDate.of(YEAR, MONTH, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(YEAR, MONTH, 31);
    private final LocalDate date;

    private Date(final LocalDate date) {
        validate(date);
        this.date = date;
    }

    public static Date from(final int day) {
        try {
            return new Date(LocalDate.of(YEAR, MONTH, day));
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }

    public boolean isEqual(final LocalDate date) {
        return this.date.equals(date);
    }

    public boolean isBefore(final LocalDate date) {
        return this.date.isBefore(date);
    }

    public boolean isAfter(final LocalDate date) {
        return this.date.isAfter(date);
    }

    public int getPeriodFrom(final LocalDate date) {
        return Period.between(date, this.date).getDays();
    }

    public int getMonth() {
        return this.date.getMonth().getValue();
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }

    private static void validate(final LocalDate date) {
        if (date.isBefore(DATE_MIN) || date.isAfter(DATE_MAX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }
}
