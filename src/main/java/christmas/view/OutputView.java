package christmas.view;

import christmas.domain.Date;
import christmas.domain.Benefits;
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

    public void printDate(Date visitDate) {
        printNewLine();
        System.out.println(StringUtil.generateDate(visitDate) + OutputMessage.INFORM_VISIT.getMessage());
    }

    public void printOrder(Order order) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.ORDER_LABEL.getMessage()) + order);
    }

    public void printTotalOrderAmount(int totalOrderAmount) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.TOTAL_ORDER_AMOUNT_LABEL.getMessage()) + StringUtil.generateMoney(totalOrderAmount));
    }

    public void printGiveaways(Giveaways giveaways) {
        printNewLine();
        if (giveaways.hasApplicable()) {
            System.out.println(StringUtil.generateLabel(OutputMessage.GIVEAWAY_LABEL.getMessage()) + giveaways);
            return;
        }
        System.out.println(StringUtil.generateLabel(OutputMessage.GIVEAWAY_LABEL.getMessage()) + OutputMessage.NOT_APPLICABLE.getMessage());
    }

    public void printBenefits(Benefits benefits) {
        printNewLine();
        if (benefits.hasApplicable()) {
            System.out.println(StringUtil.generateLabel(OutputMessage.BENEFIT_LABEL.getMessage()) + benefits);
            return;
        }
        System.out.println(StringUtil.generateLabel(OutputMessage.BENEFIT_LABEL.getMessage()) + OutputMessage.NOT_APPLICABLE.getMessage());
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.TOTAL_BENEFIT_AMOUNT_LABEL.getMessage()) + StringUtil.generateMoney(totalBenefitAmount * -1));
    }

    private void printNewLine() {
        System.out.println();
    }
}
