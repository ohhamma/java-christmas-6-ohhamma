package christmas.domain.badge;

public class DefaultBadge implements Badge {
    private final String name = "없음";

    @Override
    public String getName() {
        return name;
    }
}
