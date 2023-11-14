package christmas.service;

import christmas.domain.Discounts;
import christmas.domain.Benefits;
import christmas.domain.Giveaways;
import christmas.domain.Visit;

public class BenefitService {
    Benefits benefits;

    public void initBenefits() {
        this.benefits = new Benefits();
    }

    public void initDiscounts(Visit visit) {
        this.benefits.initDiscounts(visit);
    }

    public void initGiveaways(Visit visit) {
        this.benefits.initGiveaways(visit);
    }

    public int getTotalBenefitAmount() {
        return benefits.getTotalBenefitAmount();
    }

    public Giveaways getGiveaways() {
        return benefits.getGiveaways();
    }

    public Discounts getDiscounts() {
        return benefits.getDiscounts();
    }

    public Benefits getBenefits() {
        return benefits;
    }
}