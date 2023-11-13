package christmas.service;

import christmas.domain.Discounts;
import christmas.domain.DiscountsGenerator;
import christmas.domain.Visit;

public class DiscountService {
    Discounts discounts;

    public void initDiscounts(Visit visit) {
        this.discounts = DiscountsGenerator.generate(visit);
    }

    public int getTotalDiscountAmount() {
        return discounts.getTotalDiscountAmount();
    }
}
