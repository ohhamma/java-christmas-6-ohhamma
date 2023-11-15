package christmas.domain.visit;

import christmas.domain.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @DisplayName("메뉴판에 없는 메뉴가 입력된 경우에 대한 예외 처리")
    @ValueSource(strings = {"연어샐러드", "봉골레파스타", "고구마파스타", "화이트와인"})
    @ParameterizedTest
    void menuNameInvalid(String menuName) {
        // given
        EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);
        order.put(Menu.getMenuByName(menuName), 1);

        // when, then
        assertThatThrownBy(() -> Order.valueOf(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("메뉴 개수가 1보다 작은 경우에 대한 예외 처리")
    @ValueSource(ints = {0, -1, -100})
    @ParameterizedTest
    void menuNumberInvalid(int menuNumber) {
        // given
        EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);
        order.put(Menu.CHRISTMAS_PASTA, menuNumber);

        // when, then
        assertThatThrownBy(() -> Order.valueOf(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("음료만 주문한 경우에 대한 예외 처리")
    @ValueSource(strings = {"제로콜라", "레드와인", "샴페인"})
    @ParameterizedTest
    void onlyBeverages(String menuName) {
        // given
        EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);
        order.put(Menu.getMenuByName(menuName), 1);

        // when, then
        assertThatThrownBy(() -> Order.valueOf(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("주문 개수가 총 20개를 초과하는 경우에 대한 예외 처리")
    @Test
    void totalMenuNumberOver20() {
        // given
        EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);
        order.put(Menu.MUSHROOM_SOUP, 5);
        order.put(Menu.T_BONE_STEAK, 5);
        order.put(Menu.ICE_CREAM, 5);
        order.put(Menu.RED_WINE, 6);

        // when, then
        assertThatThrownBy(() -> Order.valueOf(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }

    @DisplayName("주문이 유효한 경우에 대한 확인")
    @Test
    void orderValid() {
        // given
        EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);
        order.put(Menu.T_BONE_STEAK, 1);
        order.put(Menu.BBQ_RIBS, 1);
        order.put(Menu.CHOCOLATE_CAKE, 2);
        order.put(Menu.ZERO_COKE, 1);

        // when
        Order validOrder = Order.valueOf(order);
        int mainMenuCount = order.keySet()
                .stream()
                .filter(menu -> MenuGroup.getMenuGroupByMenu(menu) == MenuGroup.MAIN)
                .mapToInt(order::get)
                .sum();

        // then
        assertEquals(mainMenuCount, validOrder.countMenuByMenuGroup(MenuGroup.MAIN));
    }
}
