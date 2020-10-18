package ru.academits.tunkenov.range;

public class Range {
    private double from;
    private double to;

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
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

    public Range getIntersection(Range range) {
        if (from >= range.to || to <= range.from) {
            return null;
        } else if (from == range.from && to == range.to) {
            return new Range(range.from, range.to);
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (from > range.to || to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        } else if (range.from == from && range.to == to) {
            return new Range[]{new Range(from, to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    public Range[] getDifference(Range range) {
        if (from >= range.from && to <= range.to) {
            return new Range[0];
        } else if (from < range.from && to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        } else if (from > range.from && to > range.to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{new Range(from, range.from), new Range(range.to, to)};
    }
}



