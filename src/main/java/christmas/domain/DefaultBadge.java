package christmas.domain;

public class DefaultBadge implements Badge {
    private final String name = "없음";

    @Override
    public String getName() {
        return name;
    }
}
