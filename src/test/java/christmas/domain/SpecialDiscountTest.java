package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialDiscountTest {
    @DisplayName("방문 날짜가 지정된 날짜가 아니면 할인금액이 0원")
    @ValueSource(ints = {1, 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 26, 27, 28, 29, 30})
    @ParameterizedTest
    void dateNotSpecial(int date) {
        SpecialDiscount specialDiscount = Discount.generateSpecialDiscount(Date.from(date));

        assertEquals(0, specialDiscount.getAmount());
    }

    @DisplayName("방문 날짜가 지정된 날짜면 할인금액이 0원")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    @ParameterizedTest
    void dateIsSpecial(int date) {
        SpecialDiscount specialDiscount = Discount.generateSpecialDiscount(Date.from(date));

        assertEquals(1_000, specialDiscount.getAmount());
    }
}
