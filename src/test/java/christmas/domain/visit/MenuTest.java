package christmas.domain.visit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {
    @DisplayName("메뉴판에 없는 메뉴가 입력된 경우에 Menu.INVALID 반환")
    @ValueSource(strings = {"연어샐러드", "봉골레파스타", "고구마파스타", "화이트와인"})
    @ParameterizedTest
    void menuNameInvalid(String menuName) {
        Menu menu = Menu.getMenuByName(menuName);

        assertEquals(Menu.INVALID, menu);
    }

    @DisplayName("메뉴판에 있는 메뉴가 입력된 경우에 해당 메뉴 반환")
    @ValueSource(strings = {"크리스마스파스타"})
    @ParameterizedTest
    void menuNameValid(String menuName) {
        Menu menu = Menu.getMenuByName(menuName);

        assertEquals(Menu.CHRISTMAS_PASTA, menu);
    }
}
