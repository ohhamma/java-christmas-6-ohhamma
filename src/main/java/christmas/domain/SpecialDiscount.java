package christmas.domain;

import christmas.util.StringUtil;

import java.time.LocalDate;

public class SpecialDiscount implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final int DISCOUNT_AMOUNT = DateDiscount.SPECIAL_DISCOUNT.getAmount();
    private static final String DISCOUNT_NAME = "특별 할인";
    private final int amount;

    public SpecialDiscount(final int amount) {
        this.amount = amount;
    }

    public static int calculateAmount(Date visitDate) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (DateDiscount.getDateDiscountByDate(visitDate) != DateDiscount.SPECIAL_DISCOUNT) {
            return 0;
        }
        return DISCOUNT_AMOUNT;
    }

    @Override
    public int getAmount() {
        return amount;
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
        return String.join(": ", DISCOUNT_NAME, StringUtil.generateMoney(amount * -1));
    }
}
