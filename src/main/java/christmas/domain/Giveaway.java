package christmas.domain;

public interface Giveaway {
    static ChampagneGiveaway generateChampangeGiveaway(final Date visitDate, final Order visitOrder) {
        return new ChampagneGiveaway(ChampagneGiveaway.calculateAmount(visitDate, visitOrder));
    }

    int getAmount();

    boolean isApplicable();
}
