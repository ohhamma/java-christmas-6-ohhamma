package christmas.controller;

import christmas.service.BadgeService;
import christmas.service.DiscountService;
import christmas.service.VisitService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final VisitService visitService;
    private final DiscountService discountService;
    private final BadgeService badgeService;

    public PlannerController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.visitService = new VisitService();
        this.discountService = new DiscountService();
        this.badgeService = new BadgeService();
    }

    public void run() {
        introduce();
        inputDate();
        inputOrder();
        calculateDiscount();
        giveBadge();
        outputBenefits();
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

    private void inputOrder() {
        try {
            List<String> menuOrders = inputView.readOrder();
            visitService.initOrder(menuOrders);
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            inputOrder();
        }
    }

    private void calculateDiscount() {
        discountService.initDiscounts(visitService.getVisit());
    }

    private void giveBadge() {
        badgeService.initBadge(discountService.getTotalDiscountAmount());
    }

    private void outputBenefits() {
        outputView.printVisitDate(visitService.getDate());
        outputView.printOrder(visitService.getOrder());
        outputView.printTotalOrderPrice(visitService.getTotalOrderPrice());
    }
}
