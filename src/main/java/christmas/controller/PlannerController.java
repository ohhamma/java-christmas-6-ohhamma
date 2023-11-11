package christmas.controller;

import christmas.service.VisitService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final VisitService visitService;

    public PlannerController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.visitService = new VisitService();
    }

    public void run() {
        introduce();
        inputDate();
    }

    private void introduce() {
        outputView.printIntroduce();
    }

    private void inputDate() {
        visitService.initVisit();
        try {
            int date = inputView.readDate();
            visitService.initVisitDate(date);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            inputDate();
        }
    }
}
