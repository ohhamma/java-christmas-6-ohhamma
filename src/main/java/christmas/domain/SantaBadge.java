package christmas.domain;

public class SantaBadge implements Badge {
    private final String name = "산타";

    @Override
    public String getName() {
        return name;
    }
}
