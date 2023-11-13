package christmas.domain;

public class DefaultDiscount implements Discount {
    private static final int DISCOUNT_AMOUNT = 0;
    private final int discount;

    public DefaultDiscount(final int discount) {
        this.discount = discount;
    }

    public static int calculateDiscount() {
        return DISCOUNT_AMOUNT;
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isApplicable() {
        return discount != 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
