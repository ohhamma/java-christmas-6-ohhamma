package christmas.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Giveaways {
    private final List<Giveaway> giveaways;

    private Giveaways(final List<Giveaway> giveaways) {
        this.giveaways = giveaways;
    }

    public static Giveaways valueOf(final List<Giveaway> giveaways) {
        return new Giveaways(giveaways);
    }

    public int getTotalGiveawayAmount() {
        return giveaways.stream()
                .mapToInt(Giveaway::getAmount)
                .sum();
    }

    public boolean hasApplicable() {
        return giveaways.stream()
                .anyMatch(Giveaway::isApplicable);
    }

    @Override
    public String toString() {
        return giveaways.stream()
                .filter(Giveaway::isApplicable)
                .map(Giveaway::toString)
                .collect(Collectors.joining("\n"));
    }
}
