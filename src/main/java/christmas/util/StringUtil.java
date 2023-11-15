package christmas.util;

import christmas.domain.visit.Date;

public class StringUtil {
    public static String LABEL = "<%s>\n";
    public static String DATE = "%d월 %d일";
    public static String MONEY = "%,d원";
    public static String NUMBER = "%d개";

    private StringUtil() {
    }

    public static String generateLabel(final String message) {
        return String.format(LABEL, message);
    }

    public static String generateDate(final Date date) {
        return String.format(DATE, date.getMonth(), date.getDayOfMonth());
    }

    public static String generateMoney(final int money) {
        return String.format(MONEY, money);
    }

    public static String generateNumber(final int number) {
        return String.format(NUMBER, number);
    }
}
