package christmas.view;

import christmas.domain.Date;
import christmas.domain.Events;
import christmas.domain.Giveaways;
import christmas.domain.Order;
import christmas.util.StringUtil;

public class OutputView {
    public void printException(String exception) {
        System.out.println(OutputMessage.ERROR_PREFIX.getMessage() + exception);
    }

    public void printIntroduce() {
        System.out.println(OutputMessage.INTRODUCE.getMessage());
    }

    public void printVisitDate(Date visitDate) {
        printNewLine();
        System.out.println(StringUtil.generateDate(visitDate) + OutputMessage.INFORM_VISIT.getMessage());
    }

    public void printOrder(Order order) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.ORDER_LABEL.getMessage()) + order);
    }

    public void printTotalOrderPrice(int totalOrderPrice) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.TOTAL_ORDER_PRICE_LABEL.getMessage()) + StringUtil.generateMoney(totalOrderPrice));
    }

    public void printGiveaway(Giveaways giveaways) {
        printNewLine();
        if (giveaways.hasApplicable()) {
            System.out.println(StringUtil.generateLabel(OutputMessage.GIVEAWAY_LABEL.getMessage()) + giveaways);
            return;
        }
        System.out.println(StringUtil.generateLabel(OutputMessage.GIVEAWAY_LABEL.getMessage()) + OutputMessage.NOT_APPLICABLE.getMessage());
    }

    public void printAppliedEvents(Events events) {
        printNewLine();
        if (events.hasApplicable()) {
            System.out.println(StringUtil.generateLabel(OutputMessage.DISCOUNT_LABEL.getMessage()) + events);
            return;
        }
        System.out.println(StringUtil.generateLabel(OutputMessage.DISCOUNT_LABEL.getMessage()) + OutputMessage.NOT_APPLICABLE.getMessage());
    }

    private void printNewLine() {
        System.out.println();
    }
}
