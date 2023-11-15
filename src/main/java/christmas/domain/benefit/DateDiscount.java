package christmas.domain.benefit;

import christmas.domain.visit.Date;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DateDiscount {
    SPECIAL_DISCOUNT(
            1_000,
            Arrays.asList(
                    LocalDate.of(2023, 12, 03),
                    LocalDate.of(2023, 12, 10),
                    LocalDate.of(2023, 12, 17),
                    LocalDate.of(2023, 12, 24),
                    LocalDate.of(2023, 12, 25),
                    LocalDate.of(2023, 12, 31))),
    EMPTY(0,
            Collections.EMPTY_LIST),
    ;

    private final int amount;
    private final List<LocalDate> dates;

    DateDiscount(int amount, List<LocalDate> dates) {
        this.amount = amount;
        this.dates = dates;
    }

    public static DateDiscount getDateDiscountByDate(Date date) {
        return Arrays.stream(DateDiscount.values())
                .filter(dateDiscount -> dateDiscount.hasDate(date))
                .findAny()
                .orElse(EMPTY);
    }

    private boolean hasDate(Date date) {
        return dates.stream()
                .anyMatch(date::isEqual);
    }

    public int getAmount() {
        return amount;
    }
}
