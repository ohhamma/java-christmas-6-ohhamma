package christmas.util;

import christmas.domain.Date;

public class StringUtil {
    public static String LABEL = "<%s>\n";
    public static String DATE = "%d월 %d일";
    public static String MONEY = "%,d원";

    private StringUtil() {
    }

    public static String generateLabel(String message) {
        return String.format(LABEL, message);
    }

    public static String generateDate(Date date) {
        return String.format(DATE, date.getMonth(), date.getDayOfMonth());
    }

    public static String generateMoney(int money) {
        return String.format(MONEY, money);
    }
}
