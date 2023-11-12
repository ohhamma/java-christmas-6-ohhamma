package christmas.service;

import christmas.domain.Visit;

import java.util.Map;

public class VisitService {
    private Visit visit;

    public void initVisit() {
        this.visit = new Visit();
    }

    public void initVisitDate(int date) {
        visit.initVisitDate(date);
    }

    public void initOrder(Map<String, Integer> orderNumberByMenu) {
        visit.initOrder(orderNumberByMenu);
    }
}
