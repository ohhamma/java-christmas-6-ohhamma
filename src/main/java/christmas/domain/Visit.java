package christmas.domain;

import java.util.List;

public class Visit {
    private Date date;
    private Order order;

    public void initVisitDate(int date) {
        this.date = Date.from(date);
    }

    public void initOrder(List<String> menuOrders) {
        this.order = OrderGenerator.generate(menuOrders);
    }

    public Date getDate() {
        return date;
    }

    public Order getOrder() {
        return order;
    }
}
