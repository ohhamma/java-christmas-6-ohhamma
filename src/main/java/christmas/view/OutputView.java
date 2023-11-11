package christmas.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printException(String exception) {
        System.out.println(ERROR_PREFIX + exception);
    }

    public void printIntroduce() {
        System.out.println(OutputMessage.INTRODUCE.getMessage());
    }
}
