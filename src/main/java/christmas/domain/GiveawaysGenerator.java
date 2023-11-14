package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class GiveawaysGenerator {
    private static final int GIVEAWAY_THRESHOLD = 10_000;

    private GiveawaysGenerator() {
    }

    public static Giveaways generate(Visit visit) {
        List<Giveaway> giveaways = new ArrayList<>();
        if (visit.getOrder().getTotalOrderAmount() < GIVEAWAY_THRESHOLD) {
            return Giveaways.valueOf(giveaways);
        }
        giveaways.add(Giveaway.generateChampangeGiveaway(visit.getDate(), visit.getOrder()));
        return Giveaways.valueOf(giveaways);
    }
}
