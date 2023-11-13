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
        System.out.println(generateLabel(OutputMessage.ORDER_LABEL.getMessage()) + order);
    }

    public void printTotalOrderPrice(int totalOrderPrice) {
        printNewLine();
        System.out.println(generateLabel(OutputMessage.TOTAL_ORDER_PRICE_LABEL.getMessage()) + generateMoney(totalOrderPrice));
    }

    private void printNewLine() {
        System.out.println();
    }

    private String generateLabel(String message) {
        return String.format(OutputMessage.LABEL.getMessage(), message);
    }

    private String generateMoney(int money) {
        return String.format(OutputMessage.MONEY.getMessage(), money);
    }
}
