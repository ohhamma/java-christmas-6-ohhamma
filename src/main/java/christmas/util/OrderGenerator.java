package christmas.util;

import christmas.domain.ExceptionMessage;
import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderGenerator {
    private static final int MENU_DEFAULT_NUMBER = 0;

    private OrderGenerator() {
    }

    public static Order generate(List<String> menuOrders) {
        List<List<String>> menus = SplitUtil.splitMenuOrders(menuOrders);
        validateMenus(menus);
        Map<String, Integer> numberByMenuName = mapByMenuName(menus);
        return Order.valueOf(mapByMenu(numberByMenuName));
    }

    private static Map<String, Integer> mapByMenuName(List<List<String>> menus) {
        return menus.stream()
                .collect(Collectors.toMap(menu -> menu.get(0), menu -> ConvertUtil.convertToMenuNumber(menu.get(1))));
    }

    private static EnumMap<Menu, Integer> mapByMenu(Map<String, Integer> numberByMenuName) {
        EnumMap<Menu, Integer> numberByMenu = new EnumMap<>(Menu.class);
        numberByMenuName.forEach((menuName, number)
                -> numberByMenu.put(Menu.getMenu(menuName), numberByMenu.getOrDefault(Menu.getMenu(menuName), MENU_DEFAULT_NUMBER) + number));
        return numberByMenu;
    }

    private static void validateMenus(List<List<String>> menus) {
        int validFormatNumber = (int) menus.stream()
                .filter(order -> order.size() == 2)
                .count();
        if (validFormatNumber != menus.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }
}
