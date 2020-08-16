package academit.kondakova.range;

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

    public void setFrom(double from) {
        this.from = from;
    }


    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersectionRanges(Range range2) {
        double from2 = range2.getFrom();
        double to2 = range2.getTo();

        if (from <= to2 && to >= from2) {
            return new Range(Math.max(from, from2), Math.min(to, to2));
        } else {
            return null;
        }
    }
    //TODO 5. В пересечении по одной точке пусть считается, что пересечения нет
    //
    // TODO 6. Есть много ошибок в разности. И не должно быть логики про отнимание 1

    public Range[] getUnionRanges(Range range2) {
        Range[] rangeArray;
        double from2 = range2.getFrom();
        double to2 = range2.getTo();

        if (from <= to2 && to >= from2) {
            rangeArray = new Range[1];
            rangeArray[0] = new Range(Math.min(from, from2), Math.max(to, to2));
        } else {
            rangeArray = new Range[2];
            rangeArray[0] = new Range(from, to);
            rangeArray[1] = new Range(from2, to2);
        }
        return rangeArray;
    }

    public Range[] getRangesDifference(Range range2) {
        Range[] rangeArray;
        double from2 = range2.getFrom();
        double to2 = range2.getTo();

        if (from == to2 && to == from2) {
            return null;
        } else if (from <= to2 && to >= from2) {
            rangeArray = new Range[1];
            rangeArray[0] = new Range(from, from2 - 1);
        } else {
            rangeArray = new Range[2];
            rangeArray[0] = new Range(from, to);
            rangeArray[1] = new Range(from2, to2);
        }
        return rangeArray;
    }
}