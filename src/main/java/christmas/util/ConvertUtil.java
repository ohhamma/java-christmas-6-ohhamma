package christmas.util;

import christmas.domain.ExceptionMessage;

public class ConvertUtil {
    private ConvertUtil() {
    }

    public static int convertToDate(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DATE.getMessage());
        }
    }

    public static int convertToMenuNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ORDER.getMessage());
        }
    }
}
