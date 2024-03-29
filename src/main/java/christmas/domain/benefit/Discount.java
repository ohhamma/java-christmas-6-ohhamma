package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.domain.visit.Order;

public interface Discount {
    String DISCOUNT_DELIMITER = ": ";

    static ChristmasDiscount generateChristmasDiscount(final Date visitDate) {
        return new ChristmasDiscount(ChristmasDiscount.calculateAmount(visitDate));
    }

    static WeekdayDiscount generateWeekdayDiscount(final Date visitDate, final Order visitOrder) {
        return new WeekdayDiscount(WeekdayDiscount.calculateAmount(visitDate, visitOrder));
    }

    static WeekendDiscount generateWeekendDiscount(final Date visitDate, final Order visitOrder) {
        return new WeekendDiscount(WeekendDiscount.calculateAmount(visitDate, visitOrder));
    }

    static SpecialDiscount generateSpecialDiscount(final Date visitDate) {
        return new SpecialDiscount(SpecialDiscount.calculateAmount((visitDate)));
    }

    int amount();

    String getName();

    boolean isApplicable();
}
