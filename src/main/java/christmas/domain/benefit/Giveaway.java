package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.domain.visit.Order;

public interface Giveaway {
    String GIVEAWAY_DELIMITER = " ";

    static ChampagneGiveaway generateChampangeGiveaway(final Date visitDate, final Order visitOrder) {
        return new ChampagneGiveaway(ChampagneGiveaway.calculateAmount(visitDate, visitOrder));
    }

    int getAmount();

    boolean isApplicable();
}
