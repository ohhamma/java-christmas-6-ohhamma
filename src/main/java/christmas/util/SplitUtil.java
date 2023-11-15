package christmas.util;

import christmas.domain.exception.ExceptionMessage;

import java.util.List;

public class SplitUtil {
    private static final String ORDER_SPLITERATOR = ",";
    private static final String MENU_DELIMITER = "-";

    private SplitUtil() {
    }

    public static List<String> splitOrder(final String input) {
        try {
            return List.of(input.split(ORDER_SPLITERATOR, -1));
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }

    public static List<List<String>> splitMenuOrders(final List<String> menuOrders) {
        try {
            return menuOrders.stream()
                    .map(menuOrder -> List.of(menuOrder.split(MENU_DELIMITER, -1)))
                    .toList();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }
}
