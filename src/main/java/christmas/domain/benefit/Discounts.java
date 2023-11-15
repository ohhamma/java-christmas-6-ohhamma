package christmas.domain.benefit;

import java.util.List;
import java.util.stream.Collectors;

public class Discounts {
    private final List<Discount> discounts;

    private Discounts(final List<Discount> discounts) {
        this.discounts = discounts;
    }

    public static Discounts valueOf(final List<Discount> discounts) {
        return new Discounts(discounts);
    }

    public int getTotalDiscountAmount() {
        return discounts.stream()
                .mapToInt(Discount::getAmount)
                .sum();
    }

    public boolean hasApplicable() {
        return discounts.stream()
                .anyMatch(Discount::isApplicable);
    }

    @Override
    public String toString() {
        return discounts.stream()
                .filter(Discount::isApplicable)
                .map(Discount::toString)
                .collect(Collectors.joining("\n"));
    }
}
