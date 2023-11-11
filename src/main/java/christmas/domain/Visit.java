package christmas.domain;

public class Visit {
    private Date date;

    public void initVisitDate(int date) {
        this.date = Date.from(date);
    }
}
