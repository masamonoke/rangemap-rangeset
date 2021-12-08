package org.vsu.range;

public class IntRange extends Range<Integer>{

    public IntRange(Integer start, Integer end, BoundType leftBoundType, BoundType rightBoundType) {
        super(start, end, leftBoundType, rightBoundType);
    }

    @Override
    public int hashCode() {
        return (end - start) + leftBoundType.ordinal();
    }

    @Override
    public int compareTo(Range o) {
        int distance1 = Math.abs(this.end - this.start);
        if (this.leftBoundType == BoundType.CLOSED) {
            distance1++;
        }
        if (this.rightBoundType == BoundType.CLOSED) {
            distance1++;
        }

        IntRange intRange = (IntRange) o;
        int distance2 = Math.abs(intRange.end - intRange.start);
        if (intRange.leftBoundType == BoundType.CLOSED) {
            distance2++;
        }
        if (intRange.rightBoundType == BoundType.CLOSED) {
            distance2++;
        }

        return distance1 - distance2;
    }
}
