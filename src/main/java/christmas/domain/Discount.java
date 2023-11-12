package christmas.domain;

public interface Discount {
    static ChristmasDiscount generateChristmasDiscount(final Date visitDate) {
        return new ChristmasDiscount(ChristmasDiscount.calculateDiscount(visitDate));
    }

    static WeekdayDiscount generateWeekdayDiscount(final Date visitDate, final Order visitOrder) {
        return new WeekdayDiscount(WeekdayDiscount.calculateDiscount(visitDate, visitOrder));
    }

    static WeekendDiscount generateWeekendDiscount(final Date visitDate, final Order visitOrder) {
        return new WeekendDiscount((WeekendDiscount.calculateDiscount(visitDate, visitOrder)));
    }

    int getDiscount();
}
