package org.vsu.range;

public class DoubleRange extends Range<Double> {
    public DoubleRange(Double start, Double end, BoundType leftBoundType, BoundType rightBoundType) {
        super(start, end, leftBoundType, rightBoundType);
    }

    @Override
    public int compareTo(Range o) {
        double distance1 = Math.abs(this.end - this.start);
        if (this.leftBoundType == BoundType.CLOSED) {
            distance1++;
        }
        if (this.rightBoundType == BoundType.CLOSED) {
            distance1++;
        }

        DoubleRange intRange = (DoubleRange) o;
        double distance2 = Math.abs(intRange.end - intRange.start);
        if (intRange.leftBoundType == BoundType.CLOSED) {
            distance2++;
        }
        if (intRange.rightBoundType == BoundType.CLOSED) {
            distance2++;
        }

        return (int) Math.round(distance1 - distance2);
    }
}
