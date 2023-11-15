package christmas.util;

import christmas.domain.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SplitUtilTest {
    @DisplayName("주문 입력값이 null인 경우에 대한 예외 처리")
    @ParameterizedTest
    @NullSource
    void orderIsNull(String input) {
        assertThatThrownBy(() -> SplitUtil.splitOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_ORDER.getMessage());
    }
}
