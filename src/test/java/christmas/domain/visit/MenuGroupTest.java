package christmas.domain.visit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuGroupTest {
    @DisplayName("메뉴판에 없는 메뉴가 입력된 경우에 MenuGroup.EMPTY 반환")
    @ValueSource(strings = {"연어샐러드", "봉골레파스타", "고구마파스타", "화이트와인"})
    @ParameterizedTest
    void menuNameInvalid(final String menuName) {
        // given
        Menu menu = Menu.getMenuByName(menuName);

        // when
        MenuGroup menuGroup = MenuGroup.getMenuGroupByMenu(menu);

        // then
        assertEquals(MenuGroup.EMPTY, menuGroup);
    }

    @DisplayName("애피타이저 메뉴가 입력된 경우에 MenuGroup.APPETIZER 반환")
    @ValueSource(strings = {"양송이수프", "타파스", "시저샐러드"})
    @ParameterizedTest
    void menuInAppetizer(final String menuName) {
        // given
        Menu menu = Menu.getMenuByName(menuName);

        // when
        MenuGroup menuGroup = MenuGroup.getMenuGroupByMenu(menu);

        // then
        assertEquals(MenuGroup.APPETIZER, menuGroup);
    }

    @DisplayName("메인 메뉴가 입력된 경우에 MenuGroup.MAIN 반환")
    @ValueSource(strings = {"티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"})
    @ParameterizedTest
    void menuInMain(final String menuName) {
        // given
        Menu menu = Menu.getMenuByName(menuName);

        // when
        MenuGroup menuGroup = MenuGroup.getMenuGroupByMenu(menu);

        // then
        assertEquals(MenuGroup.MAIN, menuGroup);
    }

    @DisplayName("디저트 메뉴가 입력된 경우에 MenuGroup.DESSERT 반환")
    @ValueSource(strings = {"초코케이크", "아이스크림"})
    @ParameterizedTest
    void menuInDessert(final String menuName) {
        // given
        Menu menu = Menu.getMenuByName(menuName);

        // when
        MenuGroup menuGroup = MenuGroup.getMenuGroupByMenu(menu);

        // then
        assertEquals(MenuGroup.DESSERT, menuGroup);
    }

    @DisplayName("음료 메뉴가 입력된 경우에 MenuGroup.BEVERAGE 반환")
    @ValueSource(strings = {"제로콜라", "레드와인", "샴페인"})
    @ParameterizedTest
    void menuInBeverage(final String menuName) {
        // given
        Menu menu = Menu.getMenuByName(menuName);

        // when
        MenuGroup menuGroup = MenuGroup.getMenuGroupByMenu(menu);

        // then
        assertEquals(MenuGroup.BEVERAGE, menuGroup);
    }
}
