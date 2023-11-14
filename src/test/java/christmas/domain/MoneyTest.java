package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {
    @DisplayName("돈이 0보다 작아지는 경우에 대한 예외 처리")
    @ValueSource(ints = {-100, -50, -1})
    @ParameterizedTest
    void amountLessThanZero(int amount) {
        Money money = Money.from(amount);

        assertEquals(0, money.getAmount());
    }
}
