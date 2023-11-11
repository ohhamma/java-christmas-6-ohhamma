package christmas.util;

import christmas.domain.ExceptionMessage;

public class ConvertUtil {
    private ConvertUtil() {
    }

    public static int convertToNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_DATE.getMessage());
        }
        return number;
    }
}
