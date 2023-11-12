package christmas.domain;

import java.time.LocalDate;

public class WeekdayDiscount implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final int DISCOUNT_AMOUNT = DayOfWeekDiscount.WEEKDAY_DISCOUNT.getAmount();
    private final int discount;

    public WeekdayDiscount(final int discount) {
        this.discount = discount;
    }

    public static int calculateDiscount(Date visitDate, final Order visitOrder) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (DayOfWeekDiscount.getDayOfWeekDiscountByDate(visitDate) != DayOfWeekDiscount.WEEKDAY_DISCOUNT) {
            return 0;
        }
        return visitOrder.countMenuByMenuGroup(DayOfWeekDiscount.WEEKDAY_DISCOUNT.getMenuGroup()) * DISCOUNT_AMOUNT;
    }

    @Override
    public int getDiscount() {
        return discount * -1;
    }
}
