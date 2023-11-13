package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class DiscountsGenerator {
    private DiscountsGenerator() {
    }

    public static Discounts generate(Visit visit) {
        List<Discount> discounts = new ArrayList<>();
        discounts.add(Discount.generateChristmasDiscount(visit.getDate()));
        discounts.add(Discount.generateWeekdayDiscount(visit.getDate(), visit.getOrder()));
        discounts.add(Discount.generateWeekendDiscount(visit.getDate(), visit.getOrder()));
        discounts.add(Discount.generateSpecialDiscount(visit.getDate()));
        discounts.add(Discount.generateGiveaway(visit.getDate(), visit.getOrder()));
        return Discounts.valueOf(discounts);
    }
}
