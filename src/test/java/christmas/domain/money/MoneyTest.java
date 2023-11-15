package christmas.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @DisplayName("돈이 0보다 작아지는 경우에 대한 예외 처리")
    @ValueSource(ints = {-100, -50, -1})
    @ParameterizedTest
    void amountUnderMinimum(final int amount) {
        // given, when
        Money money = Money.from(amount);

        // then
        assertEquals(0, money.getAmount());
    }

    @DisplayName("돈이 유효한 경우에 대한 확인")
    @ValueSource(ints = {0, 50, 100})
    @ParameterizedTest
    void amountValid(final int amount) {
        // given, when
        Money money = Money.from(amount);

        // then
        assertEquals(amount, money.getAmount());
    }
}
