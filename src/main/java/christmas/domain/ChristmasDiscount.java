package christmas.domain;

import java.time.LocalDate;
import java.time.Period;

public class ChristmasDiscount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 25);
    private static final int DISCOUNT_START = 1_000;
    private static final int DISCOUNT_AMOUNT = 100;
    private final int discount;

    private ChristmasDiscount(final int discount) {
        this.discount = discount;
    }

    public static ChristmasDiscount from(final LocalDate visitDate) {
        return new ChristmasDiscount(calculateDiscount(visitDate));
    }

    private static int calculateDiscount(LocalDate visitDate) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        return DISCOUNT_START + Period.between(DATE_MIN, visitDate).getDays() * DISCOUNT_AMOUNT;
    }

    public int getDiscount() {
        return this.discount * -1;
    }
}
