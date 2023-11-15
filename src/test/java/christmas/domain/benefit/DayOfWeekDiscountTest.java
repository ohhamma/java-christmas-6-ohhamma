package christmas.domain.benefit;

import christmas.domain.visit.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOfWeekDiscountTest {
    @DisplayName("평일 주문에 해당하는 날짜가 입력된 경우에 DayOfWeekDiscount.WEEKDAY_DISCOUNT 반환")
    @ValueSource(ints = {3, 4, 5, 6, 7})
    @ParameterizedTest
    void dateInWeekdayDiscount(int day) {
        // given
        Date date = Date.from(day);

        // when
        DayOfWeekDiscount dayOfWeekDiscount = DayOfWeekDiscount.getDayOfWeekDiscountByDate(date);

        // then
        assertEquals(DayOfWeekDiscount.WEEKDAY_DISCOUNT, dayOfWeekDiscount);
    }

    @DisplayName("주말 주문에 해당하는 날짜가 입력된 경우에 DayOfWeekDiscount.WEEKEND_DISCOUNT 반환")
    @ValueSource(ints = {8, 9})
    @ParameterizedTest
    void dateInWeekendDiscount(int day) {
        // given
        Date date = Date.from(day);

        // when
        DayOfWeekDiscount dayOfWeekDiscount = DayOfWeekDiscount.getDayOfWeekDiscountByDate(date);

        // then
        assertEquals(DayOfWeekDiscount.WEEKEND_DISCOUNT, dayOfWeekDiscount);
    }
}
