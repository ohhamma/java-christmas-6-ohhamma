package christmas.view;

import christmas.domain.Date;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String VISIT_DATE = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public void printException(String exception) {
        System.out.println(ERROR_PREFIX + exception);
    }

    public void printIntroduce() {
        System.out.println(OutputMessage.INTRODUCE.getMessage());
    }

    public void printVisitDate(Date visitDate) {
        System.out.println(String.format(VISIT_DATE, visitDate.getMonth(), visitDate.getDayOfMonth()));
    }
}
