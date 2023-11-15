package christmas.service;

import christmas.domain.visit.Date;
import christmas.domain.visit.Order;
import christmas.domain.visit.Visit;

import java.util.List;

public class VisitService {
    private Visit visit;

    public void initVisit() {
        this.visit = new Visit();
    }

    public void initDate(int day) {
        visit.initDate(day);
    }

    public void initOrder(List<String> menuOrders) {
        visit.initOrder(menuOrders);
    }

    public Visit getVisit() {
        return visit;
    }

    public Date getDate() {
        return visit.getDate();
    }

    public Order getOrder() {
        return visit.getOrder();
    }

    public int getTotalOrderAmount() {
        return visit.getOrder().getTotalOrderAmount();
    }
}
