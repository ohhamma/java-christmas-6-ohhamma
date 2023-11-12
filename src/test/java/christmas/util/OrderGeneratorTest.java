package christmas.util;

import christmas.domain.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OrderGeneratorTest {
    @DisplayName("비어있는 주문에 대한 예외 처리")
    @ParameterizedTest
    @EmptySource
    void orderIsEmpty(String input) {
        assertThatThrownBy(() -> OrderGenerator.generate(List.of(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("잘못된 주문 형식에 대한 예외 처리")
    @ValueSource(strings = {",", "해산물파스타 2", "해산물파스타2", "해산물파스타-", "해산물파스타- 2", "해산물파스타 -2", "해산물파스타-2,", ",해산물파스타-2", "해산물파스타-2, 레드와인-1"})
    @ParameterizedTest
    void invalidFormat(String input) {
        assertThatThrownBy(() -> OrderGenerator.generate(List.of(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }
}
