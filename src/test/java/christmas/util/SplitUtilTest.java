package christmas.util;

import christmas.domain.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitUtilTest {
    @DisplayName("주문 입력값이 null인 경우에 대한 예외 처리")
    @ParameterizedTest
    @NullSource
    void orderIsNull(String input) {
        // given, when, then
        assertThatThrownBy(() -> SplitUtil.splitOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("올바른 주문 입력값에 대한 확인")
    @ValueSource(strings = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"})
    @ParameterizedTest
    void orderValid(String input) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("티본스테이크-1");
        menuOrders.add("바비큐립-1");
        menuOrders.add("초코케이크-2");
        menuOrders.add("제로콜라-1");

        // when, then
        assertEquals(menuOrders, SplitUtil.splitOrder(input));
    }

    @DisplayName("메뉴 입력값이 null인 경우에 대한 예외 처리")
    @ParameterizedTest
    @NullSource
    void menuOrdersIsNull(String input) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(input);

        // when, then
        assertThatThrownBy(() -> SplitUtil.splitMenuOrders(menuOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("올바른 메뉴 입력값에 대한 확인")
    @Test
    void menuOrdersValid() {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("티본스테이크-1");
        menuOrders.add("바비큐립-1");
        menuOrders.add("초코케이크-2");
        menuOrders.add("제로콜라-1");

        // when
        List<List<String>> menus = new ArrayList<>();
        menus.add(List.of("티본스테이크", "1"));
        menus.add(List.of("바비큐립", "1"));
        menus.add(List.of("초코케이크", "2"));
        menus.add(List.of("제로콜라", "1"));

        // then
        assertEquals(menus, SplitUtil.splitMenuOrders(menuOrders));
    }
}
