package christmas.util;

import christmas.domain.exception.ExceptionMessage;
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
    void dayIsNull(final String input) {
        // given, when, then
        assertThatThrownBy(() -> ConvertUtil.convertToDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }

    @DisplayName("날짜 입력값이 비어있는 경우에 대한 예외 처리")
    @ParameterizedTest
    @EmptySource
    void dayIsEmpty(final String input) {
        // given, when, then
        assertThatThrownBy(() -> ConvertUtil.convertToDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }

    @DisplayName("숫자가 아닌 날짜 입력값에 대한 예외 처리")
    @ValueSource(strings = {"+", "-", "1a", "a1", "1+", "1-"})
    @ParameterizedTest
    void dayNotNumber(final String input) {
        // given, when, then
        assertThatThrownBy(() -> ConvertUtil.convertToDay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_DATE.getMessage());
    }

    @DisplayName("메뉴 개수 입력값이 null인 경우에 대한 예외 처리")
    @ParameterizedTest
    @NullSource
    void menuNumberIsNull(final String input) {
        // given, when, then
        assertThatThrownBy(() -> ConvertUtil.convertToMenuNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("메뉴 개수 입력값이 비어있는 경우에 대한 예외 처리")
    @ParameterizedTest
    @EmptySource
    void menuNumberIsEmpty(final String input) {
        // given, when, then
        assertThatThrownBy(() -> ConvertUtil.convertToMenuNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("숫자가 아닌 메뉴 개수 입력값에 대한 예외 처리")
    @ValueSource(strings = {"+", "-", "1a", "a1", "1+", "1-"})
    @ParameterizedTest
    void menuNumberNotNumber(final String input) {
        // given, when, then
        assertThatThrownBy(() -> ConvertUtil.convertToMenuNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }
}
