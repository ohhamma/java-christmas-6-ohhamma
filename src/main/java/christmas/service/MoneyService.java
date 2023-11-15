package christmas.service;

import christmas.domain.money.Money;

public class MoneyService {
    Money money;

    public void initMoney(int amount) {
        this.money = Money.from(amount);
    }

    public int getMoney() {
        return money.getAmount();
    }
}
