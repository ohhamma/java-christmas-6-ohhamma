package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class GiveawaysGenerator {
    private GiveawaysGenerator() {
    }

    public static Giveaways generate(Visit visit) {
        List<Giveaway> giveaways = new ArrayList<>();
        giveaways.add(Giveaway.generateChampangeGiveaway(visit.getDate(), visit.getOrder()));
        return Giveaways.valueOf(giveaways);
    }
}
