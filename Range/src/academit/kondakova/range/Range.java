package academit.kondakova.range;

public class Range {
    private double from;
    private double to;

    public Range() {
    }

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

    public Range getIntersectionRanges(Range range1, Range range2) {
        if (range1.getFrom() <= range2.getTo() && range1.getTo() >= range2.getFrom()) {
            return new Range(Math.max(range1.getFrom(), range2.getFrom()), Math.min(range1.getTo(), range2.getTo()));
        } else {
            return null;
        }
    }

    public Range[] getUnionRanges(Range range1, Range range2) {
        Range[] rangeArray;

        if (range1.getFrom() <= range2.getTo() && range1.getTo() >= range2.getFrom()) {
            rangeArray = new Range[1];
            rangeArray[0] = new Range(Math.min(range1.getFrom(), range2.getFrom()), Math.max(range1.getTo(), range2.getTo()));
        } else {
            rangeArray = new Range[2];
            rangeArray[0] = range1;
            rangeArray[1] = range2;
        }
        return rangeArray;
    }

    public Range[] getRangesDifference(Range range1, Range range2) {
        Range[] rangeArray;
        if (range1.getFrom() == range2.getTo() && range1.getTo() == range2.getFrom()) {
            return null;
        } else if (range1.getFrom() <= range2.getTo() && range1.getTo() >= range2.getFrom()) {
            rangeArray = new Range[1];
            rangeArray[0] = new Range(range1.getFrom(), range2.getFrom() - 1);
        } else {
            rangeArray = new Range[2];
            rangeArray[0] = range1;
            rangeArray[1] = range2;
        }
        return rangeArray;
    }
}