package christmas.view;

import christmas.domain.visit.Date;
import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.Giveaways;
import christmas.domain.visit.Order;
import christmas.util.StringUtil;
import christmas.view.message.OutputMessage;

public class OutputView {
    public void printException(final String exception) {
        System.out.println(OutputMessage.ERROR_PREFIX.getMessage() + exception);
    }

    public void printIntroduce() {
        System.out.println(OutputMessage.INTRODUCE.getMessage());
    }

    public void printDate(final Date visitDate) {
        printNewLine();
        System.out.println(StringUtil.generateDate(visitDate) + OutputMessage.INFORM_VISIT.getMessage());
    }

    public void printOrder(final Order order) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.ORDER_LABEL.getMessage()) + order);
    }

    public void printTotalOrderAmount(final int totalOrderAmount) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.TOTAL_ORDER_AMOUNT_LABEL.getMessage()) + StringUtil.generateMoney(totalOrderAmount));
    }

    public void printGiveaways(final Giveaways giveaways) {
        printNewLine();
        if (giveaways.hasApplicable()) {
            System.out.println(StringUtil.generateLabel(OutputMessage.GIVEAWAY_LABEL.getMessage()) + giveaways);
            return;
        }
        System.out.println(StringUtil.generateLabel(OutputMessage.GIVEAWAY_LABEL.getMessage()) + OutputMessage.NOT_APPLICABLE.getMessage());
    }

    public void printBenefits(final Benefits benefits) {
        printNewLine();
        if (benefits.hasApplicable()) {
            System.out.println(StringUtil.generateLabel(OutputMessage.BENEFIT_LABEL.getMessage()) + benefits);
            return;
        }
        System.out.println(StringUtil.generateLabel(OutputMessage.BENEFIT_LABEL.getMessage()) + OutputMessage.NOT_APPLICABLE.getMessage());
    }

    public void printTotalBenefitAmount(final int totalBenefitAmount) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.TOTAL_BENEFIT_AMOUNT_LABEL.getMessage()) + StringUtil.generateMoney(totalBenefitAmount * -1));
    }

    public void printPaymentAmount(final int paymentAmount) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.PAYMENT_AMOUNT_LABEL.getMessage()) + StringUtil.generateMoney(paymentAmount));
    }

    public void printBadge(final String badge) {
        printNewLine();
        System.out.println(StringUtil.generateLabel(OutputMessage.BADGE_LABEL.getMessage()) + badge);
    }

    private void printNewLine() {
        System.out.println();
    }
}
