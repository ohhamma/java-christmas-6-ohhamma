package christmas.service;

import christmas.domain.Badge;

public class BadgeService {
    private Badge badge;

    public void initBadge(int discount) {
        this.badge = Badge.from(discount);
    }

    public String getBadgeName() {
        return badge.getName();
    }
}
