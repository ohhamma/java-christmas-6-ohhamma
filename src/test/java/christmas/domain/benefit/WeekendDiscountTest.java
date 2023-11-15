package christmas.domain.benefit;

import christmas.domain.visit.Date;
import christmas.domain.visit.OrderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeekendDiscountTest {
    @DisplayName("방문 날짜가 주말이 아니면 할인금액이 0원")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    @ParameterizedTest
    void dateNotWeekend(final int date) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("티본스테이크-1");

        // when
        WeekendDiscount weekendDiscount = Discount.generateWeekendDiscount(Date.from(date), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(0, weekendDiscount.amount());
    }

    @DisplayName("메인 메뉴가 0개면 할인금액이 0원")
    @ValueSource(strings = {"초코케이크-2", "시저샐러드-1", "양송이수프-3"})
    @ParameterizedTest
    void mainMenuNone(final String menuOrder) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        // when
        WeekendDiscount weekendDiscount = Discount.generateWeekendDiscount(Date.from(1), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(0, weekendDiscount.amount());
    }

    @DisplayName("메인 메뉴가 1개면 할인금액이 2,023원")
    @ValueSource(strings = {"티본스테이크-1", "바비큐립-1", "해산물파스타-1", "크리스마스파스타-1"})
    @ParameterizedTest
    void mainMenuOne(final String menuOrder) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        // when
        WeekendDiscount weekendDiscount = Discount.generateWeekendDiscount(Date.from(1), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(2_023, weekendDiscount.amount());
    }

    @DisplayName("메인 메뉴가 2개면 할인금액이 4,046원")
    @ValueSource(strings = {"티본스테이크-2", "바비큐립-2", "해산물파스타-2", "크리스마스파스타-2"})
    @ParameterizedTest
    void mainMenuTwo(final String menuOrder) {
        // given
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        // when
        WeekendDiscount weekendDiscount = Discount.generateWeekendDiscount(Date.from(1), OrderGenerator.generate(menuOrders));

        // then
        assertEquals(4_046, weekendDiscount.amount());
    }
}
