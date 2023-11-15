package christmas.view.message;

public enum OutputMessage {
    ERROR_PREFIX("[ERROR] "),
    INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INFORM_VISIT("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_LABEL("주문 메뉴"),
    TOTAL_ORDER_AMOUNT_LABEL("할인 전 총주문 금액"),
    GIVEAWAY_LABEL("증정 메뉴"),
    BENEFIT_LABEL("혜택 내역"),
    TOTAL_BENEFIT_AMOUNT_LABEL("총혜택 금액"),
    PAYMENT_AMOUNT_LABEL("할인 후 예상 결제 금액"),
    BADGE_LABEL("12월 이벤트 배지"),
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
