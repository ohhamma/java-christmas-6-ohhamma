package christmas.view;

public enum OutputMessage {
    ERROR_PREFIX("[ERROR] "),
    INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INFORM_VISIT("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_LABEL("주문 메뉴"),
    TOTAL_ORDER_PRICE_LABEL("할인 전 총주문 금액"),
    GIVEAWAY_LABEL("증정 메뉴"),
    DISCOUNT_LABEL("혜택 내역"),
    NOT_APPLICABLE("없음"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
