package christmas.domain.visit;

import christmas.domain.exception.ExceptionMessage;
import christmas.util.ConvertUtil;
import christmas.util.SplitUtil;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderGenerator {
    private OrderGenerator() {
    }

    public static Order generate(final List<String> menuOrders) {
        List<List<String>> menus = SplitUtil.splitMenuOrders(menuOrders);
        validateMenus(menus);
        Map<String, Integer> numberByMenuName = mapByMenuName(menus);
        return Order.valueOf(mapByMenu(numberByMenuName));
    }

    private static Map<String, Integer> mapByMenuName(final List<List<String>> menus) {
        try {
            return menus.stream()
                    .collect(Collectors.toMap(menu -> menu.get(0), menu -> ConvertUtil.convertToMenuNumber(menu.get(1))));
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private static EnumMap<Menu, Integer> mapByMenu(final Map<String, Integer> numberByMenuName) {
        EnumMap<Menu, Integer> numberByMenu = new EnumMap<>(Menu.class);
        numberByMenuName.forEach((menuName, number)
                -> numberByMenu.put(Menu.getMenuByName(menuName), number));
        return numberByMenu;
    }

    private static void validateMenus(final List<List<String>> menus) {
        int validFormatNumber = (int) menus.stream()
                .filter(menu -> menu.size() == 2)
                .count();
        if (validFormatNumber != menus.size()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }
}
