package christmas.domain;

import java.time.LocalDate;

public class SpecialDiscount implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final int DISCOUNT_AMOUNT = DateDiscount.SPECIAL_DISCOUNT.getAmount();
    private final int discount;

    public SpecialDiscount(final int discount) {
        this.discount = discount;
    }

    public static int calculateDiscount(Date visitDate) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (DateDiscount.getDateDiscountByDate(visitDate) != DateDiscount.SPECIAL_DISCOUNT) {
            return 0;
        }
        return DISCOUNT_AMOUNT;
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isApplicable() {
        return discount != 0;
    }
}
