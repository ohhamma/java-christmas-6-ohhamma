package christmas.service;

import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.Giveaways;
import christmas.domain.visit.Visit;

public class BenefitService {
    Benefits benefits;

    public void initBenefits() {
        this.benefits = new Benefits();
    }

    public void initDiscounts(final Visit visit) {
        this.benefits.initDiscounts(visit);
    }

    public void initGiveaways(final Visit visit) {
        this.benefits.initGiveaways(visit);
    }

    public int getTotalBenefitAmount() {
        return benefits.getTotalBenefitAmount();
    }

    public int getTotalDiscountAmount() {
        return benefits.getDiscounts().getTotalDiscountAmount();
    }

    public Giveaways getGiveaways() {
        return benefits.getGiveaways();
    }

    public Benefits getBenefits() {
        return benefits;
    }
}
