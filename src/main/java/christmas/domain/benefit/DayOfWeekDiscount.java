package christmas.domain.benefit;

import christmas.domain.visit.MenuGroup;
import christmas.domain.visit.Date;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DayOfWeekDiscount {
    WEEKDAY_DISCOUNT(
            2_023,
            MenuGroup.DESSERT,
            Arrays.asList(
                    DayOfWeek.SUNDAY,
                    DayOfWeek.MONDAY,
                    DayOfWeek.TUESDAY,
                    DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY)),
    WEEKEND_DISCOUNT(
            2_023,
            MenuGroup.MAIN,
            Arrays.asList(
                    DayOfWeek.FRIDAY,
                    DayOfWeek.SATURDAY)),
    EMPTY(0,
            MenuGroup.EMPTY,
            Collections.EMPTY_LIST),
    ;

    private final int amount;
    private final MenuGroup menuGroup;
    private final List<DayOfWeek> daysOfWeek;

    DayOfWeekDiscount(final int amount, final MenuGroup menuGroup, final List<DayOfWeek> daysOfWeek) {
        this.amount = amount;
        this.menuGroup = menuGroup;
        this.daysOfWeek = daysOfWeek;
    }

    public static DayOfWeekDiscount getDayOfWeekDiscountByDate(final Date date) {
        return Arrays.stream(DayOfWeekDiscount.values())
                .filter(daysOfWeek -> daysOfWeek.hasDate(date))
                .findAny()
                .orElse(EMPTY);
    }

    private boolean hasDate(final Date date) {
        return daysOfWeek.stream()
                .anyMatch(days -> days == date.getDayOfWeek());
    }

    public int getAmount() {
        return amount;
    }

    public MenuGroup getMenuGroup() {
        return menuGroup;
    }
}
