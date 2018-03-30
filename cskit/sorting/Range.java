package cskit.sorting;


public final class Range {
    public int from;
    public int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
        this(0, 0);
    }
}
