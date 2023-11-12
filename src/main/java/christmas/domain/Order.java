package christmas.domain;

import java.util.EnumMap;
import java.util.List;

public class Order {
    private static final int MENU_NUMBER_THRESHOLD = 1;
    private static final int TOTAL_MENU_NUMBER_MAX = 20;
    private final EnumMap<Menu, Integer> order;

    private Order(final EnumMap<Menu, Integer> order) {
        validateMenuName(order);
        validateMenuNumber(order);
        validateBeverage(order);
        validateTotalMenuNumber(order);
        this.order = order;
    }

    public static Order valueOf(final EnumMap<Menu, Integer> order) {
        return new Order(order);
    }

    private void validateMenuName(EnumMap<Menu, Integer> order) {
        if (order.getOrDefault(Menu.INVALID, 0) > 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private void validateMenuNumber(EnumMap<Menu, Integer> order) {
        List<Integer> menuNumbers = order.values()
                .stream()
                .filter(number -> number < MENU_NUMBER_THRESHOLD)
                .toList();
        if (menuNumbers.size() > 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private void validateBeverage(EnumMap<Menu, Integer> order) {
        boolean isAllBeverage = order.keySet()
                .stream()
                .allMatch(menu -> MenuGroup.getMenuGroupByMenu(menu) == MenuGroup.BEVERAGE);
        if (isAllBeverage) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_BEVERAGE.getMessage());
        }
    }

    private void validateTotalMenuNumber(EnumMap<Menu, Integer> order) {
        int totalMenuNumber = order.values()
                .stream()
                .reduce(0, Integer::sum);
        if (totalMenuNumber > TOTAL_MENU_NUMBER_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER_TOTAL_MENU_NUMBER.getMessage());
        }
    }
}
