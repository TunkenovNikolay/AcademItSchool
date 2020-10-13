package ru.academits.tunkenov.range;

class Range {
    private double from;
    private double to;

    @Override
    public String toString() {
        return from + ", " + to;
    }

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
        return from <= number && to >= number;
    }

    public double[] getCrossingInterval(Range newRange) {
        double newTo = newRange.getTo();
        double newFrom = newRange.getFrom();

        if (from >= newTo || to <= newFrom) {
            return null;
        } else if (newFrom <= from && newTo > from && newTo <= to) {
            return new double[]{from, newTo};
        } else if (newFrom >= from && newFrom <= to && newTo >= to) {
            return new double[]{newFrom, to};
        } else if (newFrom <= from && newTo >= to) {
            return new double[]{from, to};
        } else {
            return new double[]{newFrom, newTo};
        }
    }

    public Range[] combiningTwoIntervals(Range newRange) {
        double newTo = newRange.getTo();
        double newFrom = newRange.getFrom();

        if (from > newTo || to < newFrom) {
            Range[] arrayRange = new Range[2];
            arrayRange[0] = new Range(from, to);
            arrayRange[1] = new Range(newFrom, newTo);
            return arrayRange;
        } else if (newFrom <= from && newTo > from && newTo <= to) {
            Range[] arrayRange = new Range[1];
            arrayRange[0] = new Range(from, newTo);
            return arrayRange;
        } else if (newFrom >= from && newFrom <= to && newTo >= to) {
            Range[] arrayRange = new Range[1];
            arrayRange[0] = new Range(newFrom, to);
            return arrayRange;
        } else if (newFrom <= from && newTo >= to) {
            Range[] arrayRange = new Range[1];
            arrayRange[0] = new Range(newFrom, newTo);
            return arrayRange;
        } else {
            Range[] arrayRange = new Range[1];
            arrayRange[0] = new Range(from, to);
            return arrayRange;
        }
    }

    public Range[] getDifferenceOfTwoIntervals(Range newRange) {
        double newTo = newRange.getTo();
        double newFrom = newRange.getFrom();

        if (from == newFrom && to == newTo) {
            return null;
        } else if (newTo <= from || to <= newFrom) {
            Range[] arrayRange = new Range[2];
            arrayRange[0] = new Range(from, to);
            arrayRange[1] = new Range(newFrom, newTo);
            return arrayRange;
        } else if (newFrom < from && newTo <= from && newTo <= to) {
            Range[] arrayRange = new Range[1];
            arrayRange[0] = new Range(newFrom, from);
            return arrayRange;
        } else if (newFrom >= from && newFrom <= to && newTo > to) {
            Range[] arrayRange = new Range[1];
            arrayRange[0] = new Range(to, newTo);
            return arrayRange;
        } else if (newFrom > from && newTo > to) {
            Range[] arrayRange = new Range[2];
            arrayRange[0] = new Range(newFrom, from);
            arrayRange[1] = new Range(to, newTo);
            return arrayRange;
        } else {
            Range[] arrayRange = new Range[2];
            arrayRange[0] = new Range(from, newFrom);
            arrayRange[1] = new Range(newTo, to);
            return arrayRange;
        }
    }
}



