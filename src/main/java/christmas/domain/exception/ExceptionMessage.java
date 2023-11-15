package christmas.domain.exception;

public enum ExceptionMessage {
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_BEVERAGE("음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요."),
    INVALID_ORDER_TOTAL_MENU_NUMBER("메뉴는 한 번에 최대 20개까지 주문 가능합니다. 다시 입력해 주세요."),
    INVALID_MONEY("돈은 0원보다 작을 수 없습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
