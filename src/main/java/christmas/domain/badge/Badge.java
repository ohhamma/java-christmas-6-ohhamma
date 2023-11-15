package christmas.domain.badge;

public interface Badge {
    int STAR_THRESHOLD = 5_000;
    int TREE_THRESHOLD = 10_000;
    int SANTA_THRESHOLD = 20_000;

    static Badge from(final int benefitAmount) {
        if (benefitAmount >= SANTA_THRESHOLD) {
            return new SantaBadge();
        }
        if (benefitAmount >= TREE_THRESHOLD) {
            return new TreeBadge();
        }
        if (benefitAmount >= STAR_THRESHOLD) {
            return new StarBadge();
        }
        return new DefaultBadge();
    }

    String getName();
}
