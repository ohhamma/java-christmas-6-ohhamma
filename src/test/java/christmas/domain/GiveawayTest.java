package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiveawayTest {
    @DisplayName("할인 전 총주문 금액이 120,000원보다 작으면 할인금액이 0원")
    @ValueSource(strings = {"티본스테이크-1"})
    @ParameterizedTest
    void totalOrderPriceLessThanThreshold(String menuOrder) {
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        Giveaway giveaway = Discount.generateGiveaway(Date.from(25), OrderGenerator.generate(menuOrders));

        assertEquals(0, giveaway.getDiscount());
    }

    @DisplayName("할인 전 총주문 금액이 120,000원보다 크면 샴페인 증정 (할인 금액 25,000원)")
    @Test
    void totalOrderPriceLessThanThreshold() {
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("양송이수프-1");
        menuOrders.add("티본스테이크-1");
        menuOrders.add("아이스크림-1");
        menuOrders.add("레드와인-1");

        Giveaway giveaway = Discount.generateGiveaway(Date.from(25), OrderGenerator.generate(menuOrders));

        assertEquals(25_000, giveaway.getDiscount());
    }
}
