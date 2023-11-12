package christmas.domain;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class Date {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private final LocalDate date;

    private Date(final LocalDate date) {
        validate(date);
        this.date = date;
    }

    public static Date from(final int date) {
        try {
            return new Date(LocalDate.of(2023, 12, date));
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }

    public boolean isBefore(LocalDate date) {
        return this.date.isBefore(date);
    }

    public boolean isAfter(LocalDate date) {
        return this.date.isAfter(date);
    }

    public int getPeriodFrom(LocalDate date) {
        return Period.between(date, this.date).getDays();
    }

    public int getPeriodTo(LocalDate date) {
        return Period.between(this.date, date).getDays();
    }

    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }

    private static void validate(LocalDate date) {
        if (date.isBefore(DATE_MIN) || date.isAfter(DATE_MAX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }
}
