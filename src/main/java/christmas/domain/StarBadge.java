package christmas.domain;

public class StarBadge implements Badge {
    private final String name = "별";

    @Override
    public String getName() {
        return name;
    }
}
