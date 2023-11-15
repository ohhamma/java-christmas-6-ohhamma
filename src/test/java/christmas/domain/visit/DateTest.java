package christmas.domain.visit;

import christmas.domain.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateTest {
    @DisplayName("방문 날짜가 1 이상 31 이하의 숫자가 아닌 경우에 대한 예외 처리")
    @ValueSource(ints = {-100, -1, 0, 32, 100})
    @ParameterizedTest
    void dateOutOfRange(int day) {
        assertThatThrownBy(() -> Date.from(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }

    @DisplayName("방문 날짜가 유효한 경우에 대한 확인")
    @ValueSource(ints = {1, 15, 31})
    @ParameterizedTest
    void dateIsValid(int day) {
        Date date = Date.from(day);
        LocalDate localDate = LocalDate.of(2023, 12, day);

        assertTrue(date.isEqual(localDate));
    }
}
