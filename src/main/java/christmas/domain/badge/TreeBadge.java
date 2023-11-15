package christmas.domain.badge;

public class TreeBadge implements Badge {
    private final String name = "트리";

    @Override
    public String getName() {
        return name;
    }
}
