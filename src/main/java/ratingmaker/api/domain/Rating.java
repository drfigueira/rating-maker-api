package ratingmaker.api.domain;

public enum Rating {

    TERRIBLE(1),
    BAD(2),
    REGULAR(3),
    NICE(4),
    GREAT(5);

    private final Integer value;

    Rating(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
