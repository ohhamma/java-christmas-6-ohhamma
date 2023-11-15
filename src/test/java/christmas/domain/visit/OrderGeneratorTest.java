package christmas.domain.visit;

import christmas.domain.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OrderGeneratorTest {
    @DisplayName("비어있는 주문에 대한 예외 처리")
    @ParameterizedTest
    @EmptySource
    void orderIsEmpty(final String input) {
        // given, when, then
        assertThatThrownBy(() -> OrderGenerator.generate(List.of(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("잘못된 주문 형식에 대한 예외 처리")
    @ValueSource(strings = {",", "해산물파스타 2", "해산물파스타2", "해산물파스타-", "해산물파스타- 2", "해산물파스타 -2", "해산물파스타--2", "해산물파스타 --2", "해산물파스타- -2", "해산물파스타 --2", "해산물파스타-2,", ",해산물파스타-2", "해산물파스타-2, 레드와인-1"})
    @ParameterizedTest
    void orderInvalidFormat(final String input) {
        // given, when, then
        assertThatThrownBy(() -> OrderGenerator.generate(List.of(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("중복 메뉴를 포함하는 주문에 대한 예외 처리")
    @Test
    void duplicateOrders() {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("해산물파스타-1");
        menuOrders.add("해산물파스타-2");

        // when, then
        assertThatThrownBy(() -> OrderGenerator.generate(menuOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }
}
