package christmas.domain;

import java.util.List;

public class Discounts {
    private List<Discount> discounts;

    private Discounts(final List<Discount> discounts) {
        this.discounts = discounts;
    }

    public static Discounts valueOf(final List<Discount> discounts) {
        return new Discounts(discounts);
    }
}
