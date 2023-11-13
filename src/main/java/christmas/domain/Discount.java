package christmas.domain;

public interface Discount {
    static DefaultDiscount generateDefaultDiscount() {
        return new DefaultDiscount(DefaultDiscount.calculateDiscount());
    }

    static ChristmasDiscount generateChristmasDiscount(final Date visitDate) {
        return new ChristmasDiscount(ChristmasDiscount.calculateDiscount(visitDate));
    }

    static WeekdayDiscount generateWeekdayDiscount(final Date visitDate, final Order visitOrder) {
        return new WeekdayDiscount(WeekdayDiscount.calculateDiscount(visitDate, visitOrder));
    }

    static WeekendDiscount generateWeekendDiscount(final Date visitDate, final Order visitOrder) {
        return new WeekendDiscount(WeekendDiscount.calculateDiscount(visitDate, visitOrder));
    }

    static SpecialDiscount generateSpecialDiscount(final Date visitDate) {
        return new SpecialDiscount(SpecialDiscount.calculateDiscount((visitDate)));
    }

    static Giveaway generateGiveaway(final Date visitDate, final Order visitOrder) {
        return new Giveaway(Giveaway.calculateDiscount(visitDate, visitOrder));
    }

    int getDiscount();

    boolean isApplicable();
}
