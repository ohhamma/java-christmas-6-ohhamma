package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BadgeTest {
    @DisplayName("총혜택 금액이 5,000원보다 작은 경우 없음")
    @ValueSource(ints = {0, 1_000, 2_000, 3_000, 4_000})
    @ParameterizedTest
    void discountLessThan5000(int discount) {
        Badge badge = Badge.from(discount);

        assertEquals("없음", badge.getName());
    }

    @DisplayName("총혜택 금액이 5,000 이상이고 10,000원보다 작은 경우 별")
    @ValueSource(ints = {5_000, 6_000, 7_000, 8_000, 9_000})
    @ParameterizedTest
    void discountLessThan10000(int discount) {
        Badge badge = Badge.from(discount);

        assertEquals("별", badge.getName());
    }

    @DisplayName("총혜택 금액이 10,000 이상이고 20,000원보다 작은 경우 트리")
    @ValueSource(ints = {10_000, 12_000, 14_000, 16_000, 18_000})
    @ParameterizedTest
    void discountLessThan20000(int discount) {
        Badge badge = Badge.from(discount);

        assertEquals("트리", badge.getName());
    }

    @DisplayName("총혜택 금액이 20,000 이상인 경우 산타")
    @ValueSource(ints = {20_000, 30_000, 40_000, 50_000, 100_000})
    @ParameterizedTest
    void discountMoreThan20000(int discount) {
        Badge badge = Badge.from(discount);

        assertEquals("산타", badge.getName());
    }
}
