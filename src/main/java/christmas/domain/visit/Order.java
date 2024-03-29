package christmas.domain.visit;

import christmas.domain.exception.ExceptionMessage;
import christmas.util.StringUtil;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static final int MENU_NUMBER_THRESHOLD = 1;
    private static final int TOTAL_MENU_NUMBER_MAX = 20;
    private static final String MENU_DELIMITER = " ";
    private static final String ORDER_DELIMITER = "\n";
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

    public int countMenuByMenuGroup(final MenuGroup menuGroup) {
        return order.keySet()
                .stream()
                .filter(menuGroup::hasMenu)
                .mapToInt(order::get)
                .sum();
    }

    public int getTotalOrderAmount() {
        return order.keySet()
                .stream()
                .mapToInt(menu -> order.get(menu) * menu.getPrice())
                .sum();
    }

    private void validateMenuName(final EnumMap<Menu, Integer> order) {
        if (order.getOrDefault(Menu.INVALID, 0) > 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private void validateMenuNumber(final EnumMap<Menu, Integer> order) {
        List<Integer> menuNumbers = order.values()
                .stream()
                .filter(number -> number < MENU_NUMBER_THRESHOLD)
                .toList();
        if (menuNumbers.size() > 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private void validateBeverage(final EnumMap<Menu, Integer> order) {
        boolean isAllBeverage = order.keySet()
                .stream()
                .allMatch(menu -> MenuGroup.getMenuGroupByMenu(menu) == MenuGroup.BEVERAGE);
        if (isAllBeverage) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    private void validateTotalMenuNumber(final EnumMap<Menu, Integer> order) {
        int totalMenuNumber = order.values()
                .stream()
                .reduce(0, Integer::sum);
        if (totalMenuNumber > TOTAL_MENU_NUMBER_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    @Override
    public String toString() {
        return order.keySet()
                .stream()
                .map(menu -> String.join(MENU_DELIMITER, menu.getName(), StringUtil.generateNumber(order.get(menu))))
                .collect(Collectors.joining(ORDER_DELIMITER));
    }
}
