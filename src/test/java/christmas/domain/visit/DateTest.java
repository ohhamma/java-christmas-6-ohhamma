package christmas.domain.visit;

import christmas.domain.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DateTest {
    @DisplayName("방문 날짜가 1 이상 31 이하의 숫자 아닌 경우에 대한 예외 처리")
    @ValueSource(ints = {-100, -1, 0, 32, 100})
    @ParameterizedTest
    void dateOutOfRange(int date) {
        assertThatThrownBy(() -> Date.from(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }
}
