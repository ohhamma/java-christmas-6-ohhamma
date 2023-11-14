package christmas.controller;

import christmas.service.BadgeService;
import christmas.service.EventService;
import christmas.service.VisitService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final VisitService visitService;
    private final EventService eventService;
    private final BadgeService badgeService;

    public PlannerController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.visitService = new VisitService();
        this.eventService = new EventService();
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
        eventService.initEvents();
        eventService.initDiscounts(visitService.getVisit());
        eventService.initGiveaways(visitService.getVisit());
    }

    private void giveBadge() {
        badgeService.initBadge(eventService.getTotalEventAmount());
    }

    private void outputBenefits() {
        outputView.printVisitDate(visitService.getDate());
        outputView.printOrder(visitService.getOrder());
        outputView.printTotalOrderPrice(visitService.getTotalOrderPrice());
        outputView.printGiveaway(eventService.getGiveaways());
        outputView.printAppliedEvents(eventService.getEvents());
    }
}
