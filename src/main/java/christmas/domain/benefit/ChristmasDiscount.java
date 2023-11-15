package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.util.StringUtil;

import java.time.LocalDate;

public record ChristmasDiscount(int amount) implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 25);
    private static final int DISCOUNT_START = 1_000;
    private static final int DISCOUNT_AMOUNT = 100;
    private static final String DISCOUNT_NAME = "크리스마스 디데이 할인";

    public static int calculateAmount(final Date visitDate) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        return DISCOUNT_START + visitDate.getPeriodFrom(DATE_MIN) * DISCOUNT_AMOUNT;
    }

    @Override
    public String getName() {
        return DISCOUNT_NAME;
    }

    @Override
    public boolean isApplicable() {
        return amount != 0;
    }

    @Override
    public String toString() {
        return String.join(DISCOUNT_DELIMITER, DISCOUNT_NAME, StringUtil.generateMoney(amount * -1));
    }
}
