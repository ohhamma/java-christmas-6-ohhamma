package christmas.domain.money;

import christmas.domain.exception.ExceptionMessage;

public class Money {
    private final static int MONEY_MIN = 0;
    private final int amount;

    private Money(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money from(final int amount) {
        try {
            return new Money(amount);
        } catch (IllegalArgumentException e) {
            return new Money(MONEY_MIN);
        }
    }

    public int getAmount() {
        return amount;
    }

    private void validate(final int amount) {
        if (amount < MONEY_MIN) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY.getMessage());
        }
    }
}
