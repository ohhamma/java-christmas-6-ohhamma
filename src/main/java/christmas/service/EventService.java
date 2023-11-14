package christmas.service;

import christmas.domain.Discounts;
import christmas.domain.Events;
import christmas.domain.Giveaways;
import christmas.domain.Visit;

public class EventService {
    Events events;

    public void initEvents() {
        this.events = new Events();
    }

    public void initDiscounts(Visit visit) {
        this.events.initDiscounts(visit);
    }

    public void initGiveaways(Visit visit) {
        this.events.initGiveaways(visit);
    }

    public int getTotalEventAmount() {
        return events.getTotalEventAmount();
    }

    public Giveaways getGiveaways() {
        return events.getGiveaways();
    }

    public Discounts getDiscounts() {
        return events.getDiscounts();
    }

    public Events getEvents() {
        return events;
    }
}
