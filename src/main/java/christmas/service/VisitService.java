package christmas.service;

import christmas.domain.Visit;

import java.util.List;

public class VisitService {
    private Visit visit;

    public void initVisit() {
        this.visit = new Visit();
    }

    public void initVisitDate(int date) {
        visit.initVisitDate(date);
    }

    public void initOrder(List<String> menuOrders) {
        visit.initOrder(menuOrders);
    }
}
