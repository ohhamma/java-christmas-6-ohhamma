package christmas.domain;

import java.util.List;

public class Visit {
    private Date date;
    private Order order;

    public Visit() {
    }

    private Visit(Date date, Order order) {
        this.date = date;
        this.order = order;
    }

    public static Visit of(Date date, Order order) {
        return new Visit(date, order);
    }

    public void initDate(int date) {
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
