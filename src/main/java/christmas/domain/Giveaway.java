package christmas.domain;

import java.time.LocalDate;

public class Giveaway implements Discount {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final Menu GIVEAWAY_MENU = Menu.CHAMPAGNE;
    private static final int GIVEAWAY_AMOUNT = 1;
    private static final int DISCOUNT_THRESHOLD = 120_000;
    private final int discount;

    public Giveaway(final int discount) {
        this.discount = discount;
    }

    public static int calculateDiscount(Date visitDate, Order visitOrder) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (visitOrder.getTotalOrderPrice() < DISCOUNT_THRESHOLD) {
            return 0;
        }
        return GIVEAWAY_MENU.getPrice() * GIVEAWAY_AMOUNT;
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isApplicable() {
        return discount != 0;
    }

    @Override
    public String toString() {
        return GIVEAWAY_MENU.getName() + " " + GIVEAWAY_AMOUNT + "개";
    }
}
