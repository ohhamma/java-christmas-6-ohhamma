package christmas.domain.benefit;

import christmas.domain.visit.Visit;
import christmas.util.StringUtil;

public class Benefits {
    Discounts discounts;
    Giveaways giveaways;

    public void initDiscounts(Visit visit) {
        this.discounts = DiscountsGenerator.generate(visit);
    }

    public void initGiveaways(Visit visit) {
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
        return String.join("\n", discounts.toString(), String.join(": ", "증정 이벤트", StringUtil.generateMoney(giveaways.getTotalGiveawayAmount() * -1)));
    }
}
