package christmas.domain;

import christmas.util.StringUtil;

import java.time.LocalDate;

public class WeekendDiscount implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final int DISCOUNT_AMOUNT = DayOfWeekDiscount.WEEKEND_DISCOUNT.getAmount();
    private static final String DISCOUNT_NAME = "주말 할인";
    private final int amount;

    public WeekendDiscount(final int amount) {
        this.amount = amount;
    }

    public static int calculateAmount(Date visitDate, final Order visitOrder) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (DayOfWeekDiscount.getDayOfWeekDiscountByDate(visitDate) != DayOfWeekDiscount.WEEKEND_DISCOUNT) {
            return 0;
        }
        return visitOrder.countMenuByMenuGroup(DayOfWeekDiscount.WEEKEND_DISCOUNT.getMenuGroup()) * DISCOUNT_AMOUNT;
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
