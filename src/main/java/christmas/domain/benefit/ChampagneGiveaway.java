package christmas.domain.benefit;

import christmas.domain.visit.Menu;
import christmas.domain.visit.Date;
import christmas.domain.visit.Order;

import java.time.LocalDate;

public class ChampagneGiveaway implements Giveaway {
    private static final LocalDate DATE_MIN = LocalDate.of(2023, 12, 1);
    private static final LocalDate DATE_MAX = LocalDate.of(2023, 12, 31);
    private static final Menu GIVEAWAY_MENU = Menu.CHAMPAGNE;
    private static final int GIVEAWAY_NUMBER = 1;
    private static final int GIVEAWAY_THRESHOLD = 120_000;
    private final int amount;

    public ChampagneGiveaway(final int amount) {
        this.amount = amount;
    }

    public static int calculateAmount(Date visitDate, Order visitOrder) {
        if (visitDate.isBefore(DATE_MIN) || visitDate.isAfter(DATE_MAX)) {
            return 0;
        }
        if (visitOrder.getTotalOrderAmount() < GIVEAWAY_THRESHOLD) {
            return 0;
        }
        return GIVEAWAY_MENU.getPrice() * GIVEAWAY_NUMBER;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public boolean isApplicable() {
        return amount != 0;
    }

    @Override
    public String toString() {
        return String.join(" ", GIVEAWAY_MENU.getName(), GIVEAWAY_NUMBER + "개");
    }
}
