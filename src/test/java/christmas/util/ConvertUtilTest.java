package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ConvertUtilTest {
    @DisplayName("입력값이 null인 경우에 대한 예외 처리")
    @ParameterizedTest
    @NullSource
    void inputIsNull(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 비어있는 경우에 대한 예외 처리")
    @ParameterizedTest
    @EmptySource
    void inputIsEmpty(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 입력값에 대한 예외 처리")
    @ValueSource(strings = {"+", "-", "1a", "a1", "1+", "1-"})
    @ParameterizedTest
    void inputNotNumber(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
