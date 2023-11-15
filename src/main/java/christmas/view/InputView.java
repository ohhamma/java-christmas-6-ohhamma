package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.ConvertUtil;
import christmas.util.SplitUtil;
import christmas.view.message.InputMessage;

import java.util.List;

public class InputView {
    public int readDate() {
        System.out.println(InputMessage.REQUEST_DATE.getMessage());
        String input = Console.readLine();
        return ConvertUtil.convertToDay(input);
    }

    public List<String> readOrder() {
        System.out.println(InputMessage.REQUEST_ORDER.getMessage());
        String input = Console.readLine();
        return SplitUtil.splitOrder(input);
    }
}
