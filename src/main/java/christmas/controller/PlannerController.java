package christmas.controller;

import christmas.service.MoneyService;
import christmas.service.BadgeService;
import christmas.service.BenefitService;
import christmas.service.VisitService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final VisitService visitService;
    private final BenefitService benefitService;
    private final BadgeService badgeService;
    private final MoneyService moneyService;

    public PlannerController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.visitService = new VisitService();
        this.benefitService = new BenefitService();
        this.badgeService = new BadgeService();
        this.moneyService = new MoneyService();
    }

    public void run() {
        introduce();
        inputDate();
        inputOrder();
        applyBenefits();
        applyBadge();
        outputResults();
    }

    private void introduce() {
        outputView.printIntroduce();
    }

    private void inputDate() {
        visitService.initVisit();
        try {
            int day = inputView.readDate();
            visitService.initDate(day);
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

    private void applyBenefits() {
        benefitService.initBenefits();
        benefitService.initDiscounts(visitService.getVisit());
        benefitService.initGiveaways(visitService.getVisit());
    }

    private void applyBadge() {
        badgeService.initBadge(benefitService.getTotalBenefitAmount());
    }

    private void outputResults() {
        outputVisit();
        outputBenefit();
        outputMoney();
        outputBadge();
    }

    private void outputVisit() {
        outputView.printDate(visitService.getDate());
        outputView.printOrder(visitService.getOrder());
        outputView.printTotalOrderAmount(visitService.getTotalOrderAmount());
    }

    private void outputBenefit() {
        outputView.printGiveaways(benefitService.getGiveaways());
        outputView.printBenefits(benefitService.getBenefits());
        outputView.printTotalBenefitAmount(benefitService.getTotalBenefitAmount());
    }

    private void outputMoney() {
        moneyService.initMoney(visitService.getTotalOrderAmount() - benefitService.getTotalDiscountAmount());
        outputView.printPaymentAmount(moneyService.getMoney());
    }

    private void outputBadge() {
        outputView.printBadge(badgeService.getBadgeName());
    }
}
