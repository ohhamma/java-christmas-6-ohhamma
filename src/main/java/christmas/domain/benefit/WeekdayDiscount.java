package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.domain.visit.Order;
import christmas.util.StringUtil;

import java.time.LocalDate;

public record WeekdayDiscount(int amount) implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final DayOfWeekDiscount DISCOUNT_TYPE = DayOfWeekDiscount.WEEKDAY_DISCOUNT;
    private static final String DISCOUNT_NAME = "평일 할인";

    public static int calculateAmount(Date visitDate, final Order visitOrder) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (DayOfWeekDiscount.getDayOfWeekDiscountByDate(visitDate) != DISCOUNT_TYPE) {
            return 0;
        }
        return visitOrder.countMenuByMenuGroup(DayOfWeekDiscount.WEEKDAY_DISCOUNT.getMenuGroup()) * DISCOUNT_TYPE.getAmount();
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
