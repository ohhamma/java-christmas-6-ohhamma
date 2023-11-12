package christmas.util;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.EnumMap;
import java.util.Map;

public class OrderGenerator {
    private static int MENU_DEFAULT_NUMBER = 0;

    private OrderGenerator() {
    }

    public static Order generate(Map<String, Integer> orderNumberByMenu) {
        EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);
        orderNumberByMenu.forEach((menu, number)
                -> order.put(Menu.getMenu(menu), order.getOrDefault(Menu.getMenu(menu), MENU_DEFAULT_NUMBER) + number));
        return Order.valueOf(order);
    }
}
