package org.vsu.range.rangeset;

import org.junit.jupiter.api.Test;
import org.vsu.range.BoundType;
import org.vsu.range.IntRange;
import org.vsu.range.Range;

import static org.junit.jupiter.api.Assertions.*;

class RangeSetTest {
    @Test
    void test1() {
        Range<Integer> range1 = new IntRange(0, 10, BoundType.OPEN, BoundType.OPEN);
        RangeSet<Integer> rangeSet = new RangeSet<>();
        rangeSet.add(range1);
        rangeSet.add(range1);
        rangeSet.add(new IntRange(0, 10, BoundType.OPEN, BoundType.CLOSED));
        assertEquals(2, rangeSet.size());
    }
}