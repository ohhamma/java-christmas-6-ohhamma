package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.util.StringUtil;

import java.time.LocalDate;

public record SpecialDiscount(int amount) implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final DateDiscount DISCOUNT_TYPE = DateDiscount.SPECIAL_DISCOUNT;
    private static final String DISCOUNT_NAME = "특별 할인";

    public static int calculateAmount(final Date visitDate) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (DateDiscount.getDateDiscountByDate(visitDate) != DateDiscount.SPECIAL_DISCOUNT) {
            return 0;
        }
        return DISCOUNT_TYPE.getAmount();
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
