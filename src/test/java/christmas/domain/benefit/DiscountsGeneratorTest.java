package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.domain.visit.OrderGenerator;
import christmas.domain.visit.Visit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountsGeneratorTest {
    @DisplayName("총주문 금액 10,000원보다 적으면 할인 금액 0원")
    @Test
    void totalOrderAmountUnderThreshold() {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("양송이수프-1");

        // when
        Visit visit = Visit.of(Date.from(25), OrderGenerator.generate(menuOrders));
        Discounts discounts = DiscountsGenerator.generate(visit);

        // then
        assertEquals(0, discounts.getTotalDiscountAmount());
    }
}
