package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasDiscountTest {
    @DisplayName("방문 날짜가 2023.12.1에서 2023.12.25 사이가 아니면 할인금액이 0원")
    @Test
    void dateOutOfRange() {
        LocalDate visitDate = LocalDate.of(2023, 12, 26);

        ChristmasDiscount christmasDiscount = ChristmasDiscount.from(visitDate);

        assertEquals(0, christmasDiscount.getDiscount());
    }

    @DisplayName("방문 날짜가 2023.12.1이면 할인금액이 -1000원")
    @Test
    void dateIsStartDate() {
        LocalDate visitDate = LocalDate.of(2023, 12, 1);

        ChristmasDiscount christmasDiscount = ChristmasDiscount.from(visitDate);

        assertEquals(-1000, christmasDiscount.getDiscount());
    }

    @DisplayName("방문 날짜가 2023.12.25이면 할인금액이 -3400원")
    @Test
    void dateIsEndDate() {
        LocalDate visitDate = LocalDate.of(2023, 12, 25);

        ChristmasDiscount christmasDiscount = ChristmasDiscount.from(visitDate);

        assertEquals(-3400, christmasDiscount.getDiscount());
    }
}
