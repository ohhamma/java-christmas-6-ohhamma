package christmas.service;

import christmas.domain.Visit;

public class VisitService {
    private Visit visit;

    public void initVisit() {
        this.visit = new Visit();
    }

    public void initVisitDate(int date) {
        visit.initVisitDate(date);
    }
}
