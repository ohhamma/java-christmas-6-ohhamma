package christmas.service;

import christmas.domain.ChristmasDiscount;

import java.time.LocalDate;

public class DiscountService {
    private ChristmasDiscount christmasDiscount;

    public void initChristmasDiscount(LocalDate visitDate) {
        this.christmasDiscount = ChristmasDiscount.from(visitDate);
    }
}
