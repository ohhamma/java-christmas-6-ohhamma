package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.ConvertUtil;
import christmas.util.SplitUtil;

import java.util.Map;

public class InputView {
    public int readDate() {
        System.out.println(InputMessage.REQUEST_DATE.getMessage());
        String input = Console.readLine();
        return ConvertUtil.convertToDate(input);
    }

    public Map<String, Integer> readOrder() {
        System.out.println(InputMessage.REQUEST_ORDER.getMessage());
        String input = Console.readLine();
        return SplitUtil.splitIntoMenus(input);
    }
}
