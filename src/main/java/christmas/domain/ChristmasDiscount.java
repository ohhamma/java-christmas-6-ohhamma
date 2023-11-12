package christmas.domain;

import java.time.LocalDate;

public class ChristmasDiscount implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 25);
    private static final int DISCOUNT_START = 1_000;
    private static final int DISCOUNT_AMOUNT = 100;
    private final int discount;

    public ChristmasDiscount(final int discount) {
        this.discount = discount;
    }

    public static int calculateDiscount(Date visitDate) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        return DISCOUNT_START + visitDate.getPeriodFrom(DATE_MIN) * DISCOUNT_AMOUNT;
    }

    @Override
    public int getDiscount() {
        return discount * -1;
    }
}
