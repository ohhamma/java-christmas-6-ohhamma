package christmas.util;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitUtil {
    private static final String ORDER_SPLITERATOR = ",";
    private static final String MENU_DELIMITER = "-";

    private SplitUtil() {
    }

    public static Map<String, Integer> splitIntoMenus(String input) {
        return Pattern.compile(ORDER_SPLITERATOR)
                .splitAsStream(input)
                .map(menu -> menu.split(MENU_DELIMITER, -1))
                .collect(Collectors.toMap(s -> s[0], s -> ConvertUtil.convertToMenuNumber(s[1])));
    }
}
