package christmas.view;

public enum OutputMessage {
    ERROR_PREFIX("[ERROR] "),
    INTRODUCE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_DATE("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_PREFIX("<주문 메뉴>\n"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
