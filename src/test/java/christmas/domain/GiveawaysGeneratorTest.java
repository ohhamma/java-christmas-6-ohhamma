package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GiveawaysGeneratorTest {
    @DisplayName("총주문 금액 10,000원보다 적으면 증정 금액 0원")
    @Test
    void totalOrderAmountLessThan10000() {
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("양송이수프-1");

        Visit visit = Visit.of(Date.from(25), OrderGenerator.generate(menuOrders));
        Giveaways giveaways = GiveawaysGenerator.generate(visit);

        assertEquals(0, giveaways.getTotalGiveawayAmount());
    }
}
