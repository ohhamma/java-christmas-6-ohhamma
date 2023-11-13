package christmas.domain;

import java.util.List;

public class Discounts {
    private final List<Discount> discounts;

    private Discounts(final List<Discount> discounts) {
        this.discounts = discounts;
    }

    public static Discounts valueOf(final List<Discount> discounts) {
        return new Discounts(discounts);
    }

    public Discount getGiveaway() {
        return discounts.stream()
                .filter(discount -> discount instanceof Giveaway)
                .findFirst()
                .orElse(Discount.generateDefaultDiscount());
    }

    public int getTotalDiscountAmount() {
        return discounts.stream()
                .mapToInt(Discount::getDiscount)
                .sum();
    }
}
