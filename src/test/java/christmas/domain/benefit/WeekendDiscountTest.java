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
    void dateNotWeekday(int date) {
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add("티본스테이크-1");

        WeekdayDiscount weekdayDiscount = Discount.generateWeekdayDiscount(Date.from(date), OrderGenerator.generate(menuOrders));

        assertEquals(0, weekdayDiscount.getAmount());
    }

    @DisplayName("메인 메뉴가 0개면 할인금액이 0원")
    @ValueSource(strings = {"초코케이크-2", "시저샐러드-1", "양송이수프-3"})
    @ParameterizedTest
    void dessertMenuNone(String menuOrder) {
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        WeekendDiscount weekendDiscount = Discount.generateWeekendDiscount(Date.from(1), OrderGenerator.generate(menuOrders));

        assertEquals(0, weekendDiscount.getAmount());
    }

    @DisplayName("메인 메뉴가 1개면 할인금액이 2,023원")
    @ValueSource(strings = {"티본스테이크-1", "바비큐립-1", "해산물파스타-1", "크리스마스파스타-1"})
    @ParameterizedTest
    void dessertMenuOne(String menuOrder) {
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        WeekendDiscount weekendDiscount = Discount.generateWeekendDiscount(Date.from(1), OrderGenerator.generate(menuOrders));

        assertEquals(2_023, weekendDiscount.getAmount());
    }

    @DisplayName("메인 메뉴가 2개면 할인금액이 4,046원")
    @ValueSource(strings = {"티본스테이크-2", "바비큐립-2", "해산물파스타-2", "크리스마스파스타-2"})
    @ParameterizedTest
    void dessertMenuTwo(String menuOrder) {
        List<String> menuOrders = new ArrayList<>();
        menuOrders.add(menuOrder);

        WeekendDiscount weekendDiscount = Discount.generateWeekendDiscount(Date.from(1), OrderGenerator.generate(menuOrders));

        assertEquals(4_046, weekendDiscount.getAmount());
    }
}
