package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.ConvertUtil;

public class InputView {
    public int readDate() {
        System.out.println(InputMessage.REQUEST_DATE.getMessage());
        String input = Console.readLine();
        return ConvertUtil.convertToNumber(input);
    }
}
