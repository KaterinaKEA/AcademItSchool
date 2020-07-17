package academit.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return (to - from);
    }

    public boolean isInside(double number) {
        return number <= to && number >= from;
    }

    public static Range getIntersectionRanges(Range range1, Range range2) {
        if (range1.getFrom() <= range2.getTo() && range1.getTo() >= range2.getFrom()) {
            return new Range(Math.max(range1.getFrom(), range2.getFrom()), Math.min(range1.getTo(), range2.getTo()));
        } else {
            return null;
        }
    }
}

