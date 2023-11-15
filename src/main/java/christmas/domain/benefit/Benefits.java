package christmas.domain.benefit;

import christmas.domain.visit.Visit;
import christmas.util.StringUtil;

public class Benefits {
    private static final String BENEFITS_DELIMITER = "\n";
    private static final String TOTAL_GIVEAWAY_AMOUNT_DELIMITER = ": ";
    private static final String TOTAL_GIVEAWAY_AMOUNT_LABEL = "증정 이벤트";
    Discounts discounts;
    Giveaways giveaways;

    public void initDiscounts(final Visit visit) {
        this.discounts = DiscountsGenerator.generate(visit);
    }

    public void initGiveaways(final Visit visit) {
        this.giveaways = GiveawaysGenerator.generate(visit);
    }

    public int getTotalBenefitAmount() {
        return discounts.getTotalDiscountAmount() + giveaways.getTotalGiveawayAmount();
    }

    public Giveaways getGiveaways() {
        return giveaways;
    }

    public Discounts getDiscounts() {
        return discounts;
    }

    public boolean hasApplicable() {
        return discounts.hasApplicable() || giveaways.hasApplicable();
    }

    @Override
    public String toString() {
        String totalGiveawayAmount = String.join(TOTAL_GIVEAWAY_AMOUNT_DELIMITER, TOTAL_GIVEAWAY_AMOUNT_LABEL, StringUtil.generateMoney(giveaways.getTotalGiveawayAmount() * -1));
        return String.join(BENEFITS_DELIMITER, discounts.toString(), totalGiveawayAmount);
    }
}
