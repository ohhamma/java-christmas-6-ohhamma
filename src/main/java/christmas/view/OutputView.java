package christmas.view;

import christmas.domain.Date;
import christmas.domain.Order;

public class OutputView {
    public void printException(String exception) {
        System.out.println(OutputMessage.ERROR_PREFIX.getMessage() + exception);
    }

    public void printIntroduce() {
        System.out.println(OutputMessage.INTRODUCE.getMessage());
    }

    public void printVisitDate(Date visitDate) {
        printNewLine();
        System.out.println(String.format(OutputMessage.VISIT_DATE.getMessage(), visitDate.getMonth(), visitDate.getDayOfMonth()));
    }

    public void printOrder(Order order) {
        printNewLine();
        System.out.println(OutputMessage.ORDER_PREFIX.getMessage() + order);
    }

    private void printNewLine() {
        System.out.println();
    }
}
