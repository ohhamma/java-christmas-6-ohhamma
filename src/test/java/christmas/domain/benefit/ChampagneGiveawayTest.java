package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.domain.visit.OrderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChampagneGiveawayTest {
    @DisplayName("할인 전 총주문 금액이 120,000원보다 작으면 할인금액이 0원")
    @Test
    void totalOrderPriceUnderThreshold() {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("티본스테이크-1");

        // when
        ChampagneGiveaway champagneGiveaway = Giveaway.generateChampagneGiveaway(Date.from(25), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(0, champagneGiveaway.amount());
    }

    @DisplayName("할인 전 총주문 금액이 120,000원보다 크면 샴페인 증정 (할인 금액 25,000원)")
    @Test
    void totalOrderPriceOverThreshold() {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("양송이수프-1");
        menuOrders.add("티본스테이크-1");
        menuOrders.add("아이스크림-1");
        menuOrders.add("레드와인-1");

        // when
        ChampagneGiveaway champagneGiveaway = Giveaway.generateChampagneGiveaway(Date.from(25), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(25_000, champagneGiveaway.amount());
    }
}
