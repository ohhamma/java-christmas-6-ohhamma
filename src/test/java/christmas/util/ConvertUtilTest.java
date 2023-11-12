package christmas.util;

import christmas.domain.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ConvertUtilTest {
    @DisplayName("날짜 입력값이 null인 경우에 대한 예외 처리")
    @ParameterizedTest
    @NullSource
    void dateIsNull(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }

    @DisplayName("날짜 입력값이 비어있는 경우에 대한 예외 처리")
    @ParameterizedTest
    @EmptySource
    void dateIsEmpty(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }

    @DisplayName("숫자가 아닌 날짜 입력값에 대한 예외 처리")
    @ValueSource(strings = {"+", "-", "1a", "a1", "1+", "1-"})
    @ParameterizedTest
    void dateNotNumber(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }

    @DisplayName("메뉴 개수 입력값이 null인 경우에 대한 예외 처리")
    @ParameterizedTest
    @NullSource
    void menuNumberIsNull(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToMenuNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("메뉴 개수 입력값이 비어있는 경우에 대한 예외 처리")
    @ParameterizedTest
    @EmptySource
    void menuNumberIsEmpty(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToMenuNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("숫자가 아닌 메뉴 개수 입력값에 대한 예외 처리")
    @ValueSource(strings = {"+", "-", "1a", "a1", "1+", "1-"})
    @ParameterizedTest
    void menuNumberNotNumber(String input) {
        assertThatThrownBy(() -> ConvertUtil.convertToMenuNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }
}
