package christmas.domain;

import christmas.util.OrderGenerator;

import java.util.Map;

public class Visit {
    private Date date;
    private Order order;

    public void initVisitDate(int date) {
        this.date = Date.from(date);
    }

    public void initOrder(Map<String, Integer> orderNumberByMenu) {
        this.order = OrderGenerator.generate(orderNumberByMenu);
    }
}
