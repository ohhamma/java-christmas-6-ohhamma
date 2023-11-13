package christmas.domain;

public interface Badge {
    int STAR_THRESHOLD = 5_000;
    int TREE_THRESHOLD = 10_000;
    int SANTA_THRESHOLD = 20_000;

    static Badge from(int discount) {
        if (discount >= SANTA_THRESHOLD) {
            return new SantaBadge();
        }
        if (discount >= TREE_THRESHOLD) {
            return new TreeBadge();
        }
        if (discount >= STAR_THRESHOLD) {
            return new StarBadge();
        }
        return new DefaultBadge();
    }

    String getName();
}
