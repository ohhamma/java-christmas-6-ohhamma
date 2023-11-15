package christmas.domain.benefit;

import christmas.domain.visit.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasDiscountTest {
    @DisplayName("방문 날짜가 2023.12.1에서 2023.12.25 사이가 아닌 유효한 날짜면 할인금액이 0원")
    @Test
    void dateOutOfRange() {
        // given, when
        ChristmasDiscount christmasDiscount = Discount.generateChristmasDiscount(Date.from(26));

        // then
        assertEquals(0, christmasDiscount.amount());
    }

    @DisplayName("방문 날짜가 2023.12.1이면 할인금액이 1,000원")
    @Test
    void dateIsStartDate() {
        // given, when
        ChristmasDiscount christmasDiscount = Discount.generateChristmasDiscount(Date.from(1));

        // then
        assertEquals(1_000, christmasDiscount.amount());
    }

    @DisplayName("방문 날짜가 2023.12.25이면 할인금액이 3,400원")
    @Test
    void dateIsEndDate() {
        // given, when
        ChristmasDiscount christmasDiscount = Discount.generateChristmasDiscount(Date.from(25));

        // then
        assertEquals(3_400, christmasDiscount.amount());
    }
}
