package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasDiscountTest {
    @DisplayName("방문 날짜가 2023.12.1에서 2023.12.25 사이가 아니면 할인금액이 0원")
    @Test
    void dateOutOfRange() {
        ChristmasDiscount christmasDiscount = Discount.generateChristmasDiscount(Date.from(26));

        assertEquals(0, christmasDiscount.getDiscount());
    }

    @DisplayName("방문 날짜가 2023.12.1이면 할인금액이 1,000원")
    @Test
    void dateIsStartDate() {
        ChristmasDiscount christmasDiscount = Discount.generateChristmasDiscount(Date.from(1));

        assertEquals(1_000, christmasDiscount.getDiscount());
    }

    @DisplayName("방문 날짜가 2023.12.25이면 할인금액이 3,400원")
    @Test
    void dateIsEndDate() {
        ChristmasDiscount christmasDiscount = Discount.generateChristmasDiscount(Date.from(25));

        assertEquals(3_400, christmasDiscount.getDiscount());
    }
}
