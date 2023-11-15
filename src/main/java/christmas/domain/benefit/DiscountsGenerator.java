package christmas.domain.benefit;

import christmas.domain.visit.Visit;

import java.util.ArrayList;
import java.util.List;

public class DiscountsGenerator {
    private static final int DISCOUNT_THRESHOLD = 10_000;

    private DiscountsGenerator() {
    }

    public static Discounts generate(final Visit visit) {
        List<Discount> discounts = new ArrayList<>();
        if (visit.getOrder().getTotalOrderAmount() < DISCOUNT_THRESHOLD) {
            return Discounts.valueOf(discounts);
        }
        discounts.add(Discount.generateChristmasDiscount(visit.getDate()));
        discounts.add(Discount.generateWeekdayDiscount(visit.getDate(), visit.getOrder()));
        discounts.add(Discount.generateWeekendDiscount(visit.getDate(), visit.getOrder()));
        discounts.add(Discount.generateSpecialDiscount(visit.getDate()));
        return Discounts.valueOf(discounts);
    }
}
