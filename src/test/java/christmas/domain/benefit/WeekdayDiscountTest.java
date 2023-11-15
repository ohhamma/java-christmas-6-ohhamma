package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.domain.visit.OrderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeekdayDiscountTest {
    @DisplayName("방문 날짜가 평일이 아니면 할인금액이 0원")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    @ParameterizedTest
    void dateNotWeekday(int date) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("초코케이크-1");

        // when
        WeekdayDiscount weekdayDiscount = Discount.generateWeekdayDiscount(Date.from(date), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(0, weekdayDiscount.amount());
    }

    @DisplayName("디저트 메뉴가 0개면 할인금액이 0원")
    @ValueSource(strings = {"해산물파스타-2", "시저샐러드-1", "양송이수프-3"})
    @ParameterizedTest
    void dessertMenuNone(String menuOrder) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        // when
        WeekdayDiscount weekdayDiscount = Discount.generateWeekdayDiscount(Date.from(3), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(0, weekdayDiscount.amount());
    }

    @DisplayName("디저트 메뉴가 1개면 할인금액이 2,023원")
    @ValueSource(strings = {"초코케이크-1", "아이스크림-1"})
    @ParameterizedTest
    void dessertMenuOne(String menuOrder) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        // when
        WeekdayDiscount weekdayDiscount = Discount.generateWeekdayDiscount(Date.from(3), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(2_023, weekdayDiscount.amount());
    }

    @DisplayName("디저트 메뉴가 2개면 할인금액이 4,046원")
    @ValueSource(strings = {"초코케이크-2", "아이스크림-2"})
    @ParameterizedTest
    void dessertMenuTwo(String menuOrder) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        // when
        WeekdayDiscount weekdayDiscount = Discount.generateWeekdayDiscount(Date.from(3), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(4_046, weekdayDiscount.amount());
    }
}
