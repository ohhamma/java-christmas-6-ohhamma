package christmas.domain.visit;

import java.util.List;

public class Visit {
    private Date date;
    private Order order;

    public Visit() {
    }

    private Visit(final Date date, final Order order) {
        this.date = date;
        this.order = order;
    }

    public static Visit of(final Date date, final Order order) {
        return new Visit(date, order);
    }

    public void initDate(final int day) {
        this.date = Date.from(day);
    }

    public void initOrder(final List<String> menuOrders) {
        this.order = OrderGenerator.generate(menuOrders);
    }

    public Date getDate() {
        return date;
    }

    public Order getOrder() {
        return order;
    }
}
